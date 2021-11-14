package controller;

import View.tm.StudentTM;
import bo.BoFactory;
import bo.custom.BatchBO;
import bo.custom.CourseBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.BatchDTO;
import dto.CourseDTO;
import dto.StudentDTO;
import generate.IDGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentRegistrationViewController implements Initializable {
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentID;
    public JFXTextField txtGuardianName;
    public JFXComboBox cmbGrade;
    public JFXComboBox cmbCourse;
    public JFXDatePicker dpDOB;
    public TableView <StudentTM>tblStudent;
    public JFXButton btnAddStudent;
    public JFXTextField txtGuardianContact;
    public Button btnCancel;
    public TableColumn colGurdianName;
    public TableColumn colGuardianContact;
    public TableColumn colAddress;
    public TableColumn colCourse;
    public TableColumn colGrade;
    public TableColumn colDOB;
    public TableColumn colStudentName;
    public TableColumn colStudentId;
    public JFXTextField txtAddress;
    StudentBO bo;

    ObservableList<String> batchList=FXCollections.observableArrayList();
    ObservableList<String> courseList=FXCollections.observableArrayList();

    BatchBO batchBO = BoFactory.getInstance().getBo(BoFactory.BoType.BATCH);
    CourseBO courseBO = BoFactory.getInstance().getBo(BoFactory.BoType.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {

            bo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

            loadId();


            colStudentId.setCellValueFactory(new PropertyValueFactory("studentID"));
            colStudentName.setCellValueFactory(new PropertyValueFactory("studentName"));
            colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
            colGrade.setCellValueFactory(new PropertyValueFactory("grade"));
            colCourse.setCellValueFactory(new PropertyValueFactory("course"));
            colAddress.setCellValueFactory(new PropertyValueFactory("address"));
            colGurdianName.setCellValueFactory(new PropertyValueFactory("gurdianName"));
            colGuardianContact.setCellValueFactory(new PropertyValueFactory("gurdianContact"));

//            tblStudent.getSelectionModel().selectedItemProperty().
//                    addListener(((observable, oldValue, newValue) ->{
//                        setData(newValue);
//                    } ));

            loadAllStudents();

            studentID();


            ArrayList<BatchDTO> all1 = null;
            all1 = batchBO.getAll();
            for (BatchDTO dto : all1) {
                batchList.add(dto.getBatchName());
            }

            cmbGrade.setItems(batchList);

            ArrayList<CourseDTO> all2 = null;
            all2 = courseBO.getAll();
            for (CourseDTO dto : all2) {
                courseList.add(dto.getCourseName());
            }

            cmbCourse.setItems(courseList);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadId() throws Exception {
        String id = bo.getStudentId();
        txtStudentID.setText(id);
    }

    private void setData(StudentTM tm) {
        txtStudentID.setText(String.valueOf(tm.getStudentID()));
        txtStudentName.setText(tm.getStudentName());
        dpDOB.setValue(LocalDate.parse(tm.getDob()));
        cmbGrade.setValue(tm.getGrade());
        cmbCourse.setValue(tm.getCourse());
        txtAddress.setText(tm.getAddress());
        txtGuardianName.setText(tm.getGurdianName());
        txtGuardianContact.setText(tm.getGurdianContact());
    }

    private void loadAllStudents() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> allCustomers = bo.getAllStudent();
        for (StudentDTO dto : allCustomers) {
            StudentTM tm = new StudentTM(dto.getStudentId(),
                    dto.getStudentName(),
                    dto.getDob(),
                    dto.getCourseId(),
                    dto.getBatchId(),
                    dto.getAddress(),
                    dto.getGuardianName(),
                    dto.getGuardianContact()
                    );
            tmList.add(tm);
            System.out.println(dto.getBatchId());
        }
        tblStudent.setItems(tmList);

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) throws Exception {

        int batchId = batchBO.getId(cmbGrade.getValue().toString());
        int courseId = courseBO.getId(cmbCourse.getValue().toString());


        boolean isSaved = bo.saveStudent(new StudentDTO(txtStudentID.getText(),
                        txtStudentName.getText(),
                        dpDOB.getValue().toString(),
                        batchId,
                        courseId,
                        txtAddress.getText(),
                        txtGuardianName.getText(),
                        txtGuardianContact.getText()
        ));

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Registration Successful", ButtonType.OK).show();
            Clear();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Registration Failed", ButtonType.OK).show();
        }





    }

    private void Clear() {
        txtStudentID.setText("");
        txtStudentName.setText("");
        dpDOB.setValue(null);
        cmbGrade.setValue("");
        cmbCourse.setValue("");
        txtAddress.setText("");
        txtGuardianName.setText("");
        txtGuardianContact.setText("");
    }

    private void studentID(){

            String studentId;
        try {
            studentId = IDGenerator.getNewID("student", "studentID", "S");
            txtStudentID.setText(studentId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

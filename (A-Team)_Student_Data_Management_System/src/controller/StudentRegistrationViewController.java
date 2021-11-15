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
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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

    public StudentRegistrationViewController() throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {

            bo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

            loadId();


            colStudentId.setCellValueFactory(new PropertyValueFactory("studentID"));
            colStudentName.setCellValueFactory(new PropertyValueFactory("studentName"));
            colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
            colGrade.setCellValueFactory(new PropertyValueFactory("batchId"));
            colCourse.setCellValueFactory(new PropertyValueFactory("courseId"));
            colAddress.setCellValueFactory(new PropertyValueFactory("address"));
            colGurdianName.setCellValueFactory(new PropertyValueFactory("gurdianName"));
            colGuardianContact.setCellValueFactory(new PropertyValueFactory("gurdianContact"));

            tblStudent.getSelectionModel().selectedItemProperty().
                    addListener(((observable, oldValue, newValue) ->{
                        setData(newValue);
                    } ));

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

    int batchId = batchBO.getId(cmbGrade.getValue().toString());
    int courseId = courseBO.getId(cmbCourse.getValue().toString());

    private void loadId() throws Exception {
        String id = bo.getStudentId();
        txtStudentID.setText(id);
    }

    private void setData(StudentTM tm) {
        txtStudentID.setText(String.valueOf(tm.getStudentID()));
        txtStudentName.setText(tm.getStudentName());
        dpDOB.setValue(LocalDate.parse(tm.getDob()));
        cmbGrade.setValue(tm.getBatchId());
        cmbCourse.setValue(tm.getCourseId());
        txtAddress.setText(tm.getAddress());
        txtGuardianName.setText(tm.getGurdianName());
        txtGuardianContact.setText(tm.getGurdianContact());
    }

    private void loadAllStudents() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> allStudent = bo.getAllStudent();
        for (StudentDTO dto : allStudent) {
            StudentTM tm = new StudentTM(dto.getStudentId(),
                    dto.getStudentName(),
                    dto.getDob(),
                    batchId,
                    courseId,
                    dto.getAddress(),
                    dto.getGuardianName(),
                    dto.getGuardianContact()
                    );
            tmList.add(tm);
        }
        tblStudent.setItems(tmList);
        tblStudent.refresh();

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnAddStudentOnAction(ActionEvent actionEvent) throws Exception {



//        if (Pattern.compile("^[A-z ]{1,50}$").matcher(txtStudentName.getText()).matches()) {
//            txtStudentName.setFocusColor(Paint.valueOf("green"));
//            txtStudentName.requestFocus();
//            if (Pattern.compile("^[A-z  , 0-9 / \\\\]{1,30}$").matcher(txtAddress.getText()).matches()) {
//                txtAddress.setFocusColor(Paint.valueOf("green"));
//                txtAddress.requestFocus();
//                if (Pattern.compile("^[A-z ]{1,50}$").matcher(txtGuardianName.getText()).matches()) {
//                    txtGuardianName.setFocusColor(Paint.valueOf("green"));
//                    txtGuardianName.requestFocus();
//                    if (Pattern.compile("[0-9]{3}(-)[0-9]{7}$").matcher(txtGuardianContact.getText()).matches()) {
//                        txtGuardianContact.setFocusColor(Paint.valueOf("green"));
//                        txtGuardianContact.requestFocus();
//
//                        boolean isSaved = bo.saveStudent(new StudentDTO(txtStudentID.getText(),
//                                txtStudentName.getText(),
//                                dpDOB.getValue().toString(),
//                                batchId,
//                                courseId,
//                                txtAddress.getText(),
//                                txtGuardianName.getText(),
//                                txtGuardianContact.getText()
//                        ));
//
//                        if (isSaved) {
//                            new Alert(Alert.AlertType.INFORMATION, "Registration Successful", ButtonType.OK).show();
//                            Clear();
//                        } else {
//                            new Alert(Alert.AlertType.INFORMATION, "Registration Failed", ButtonType.OK).show();
//                        }
//
//                    }else{
//                        txtGuardianContact.setFocusColor(Paint.valueOf("red"));
//                        txtGuardianContact.requestFocus();
//                    }
//                }else{
//                    txtGuardianName.setFocusColor(Paint.valueOf("red"));
//                    txtGuardianName.requestFocus();
//                }
//            }else{
//                txtAddress.setFocusColor(Paint.valueOf("red"));
//                txtAddress.requestFocus();
//            }
//        }else{
//            txtStudentName.setFocusColor(Paint.valueOf("red"));
//            txtStudentName.requestFocus();
//        }



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

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
import com.sun.deploy.uitoolkit.ToolkitStore;
import dto.BatchDTO;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudentManagementViewController implements Initializable {
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtGuardianName;
    public JFXButton btnSearch;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public Button btnCancel;
    public JFXTextField txtGuardianContact;
    public TextField txtSearch;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colDOB;
    public TableColumn colGrade;
    public TableColumn colCourse;
    public TableColumn colAddress;
    public JFXComboBox cmbCourse;
    public TableColumn colGurdianName;
    public TableColumn colGuardianContact;
    public TableColumn colOperator;
    public JFXDatePicker dpDOB;
    public JFXComboBox cmbGrade;
    public TableView tblStudent;
    StudentBO bo;

    ObservableList<String> batchList= FXCollections.observableArrayList();
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
            colGrade.setCellValueFactory(new PropertyValueFactory("batchId"));
            colCourse.setCellValueFactory(new PropertyValueFactory("courseId"));
            colAddress.setCellValueFactory(new PropertyValueFactory("address"));
            colGurdianName.setCellValueFactory(new PropertyValueFactory("gurdianName"));
            colGuardianContact.setCellValueFactory(new PropertyValueFactory("gurdianContact"));
            colOperator.setCellValueFactory(new PropertyValueFactory("btn"));

            tblStudent.getSelectionModel().selectedItemProperty().
                    addListener(((observable, oldValue, newValue) -> {
                        setData((StudentTM) newValue);
                    }));

            loadAllStudents();

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

    private void loadId() throws Exception {
        String id = bo.getStudentId();
        txtStudentID.setText(id);
    }

    private void loadAllStudents() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> allStudents = bo.getAllStudent();

        for (StudentDTO dto : allStudents) {
            Button btn = new Button("Delete");
            String batchId = batchBO.getName(dto.getBatchId());
            String courseId = courseBO.getName(dto.getCourseId());
            StudentTM tm = new StudentTM(dto.getStudentId(),
                    dto.getStudentName(),
                    dto.getDob(),
                    batchId,
                    courseId,
                    dto.getAddress(),
                    dto.getGuardianName(),
                    dto.getGuardianContact(),
                    btn
            );
            tmList.add(tm);
            btn.setOnAction((e) -> {

                ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure", ok, no);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no) == ok) {
                    try {
                        if (bo.deleteStudent(String.valueOf(tm.getStudentID()))) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK).show();
                            loadAllStudents();
                            return;
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });

        }
        tblStudent.setItems(tmList);

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo.getStudent(txtStudentID.getText());
        if (dto != null) {
            txtStudentID.setText(String.valueOf(dto.getStudentId()));
            txtStudentName.setText(dto.getStudentName());
            dpDOB.setValue(LocalDate.parse(dto.getDob()));
            cmbGrade.setValue(dto.getBatchId());
            cmbCourse.setValue(dto.getCourseId());
            txtAddress.setText(dto.getAddress());
            txtGuardianName.setText(dto.getGuardianName());
            txtGuardianContact.setText(dto.getGuardianContact() + "");
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {

        int batchId = batchBO.getId(cmbGrade.getValue().toString());
        int courseId = courseBO.getId(cmbCourse.getValue().toString());

        if (Pattern.compile("^[A-z ]{1,50}$").matcher(txtStudentName.getText()).matches()) {
            txtStudentName.setFocusColor(Paint.valueOf("green"));
            txtStudentName.requestFocus();
            if (Pattern.compile("^[A-z  , 0-9 / \\\\]{1,30}$").matcher(txtAddress.getText()).matches()) {
                txtAddress.setFocusColor(Paint.valueOf("green"));
                txtAddress.requestFocus();
                if (Pattern.compile("^[A-z ]{1,50}$").matcher(txtGuardianName.getText()).matches()) {
                    txtGuardianName.setFocusColor(Paint.valueOf("green"));
                    txtGuardianName.requestFocus();
                    if (Pattern.compile("[0-9]{3}(-)[0-9]{7}$").matcher(txtGuardianContact.getText()).matches()) {
                        txtGuardianContact.setFocusColor(Paint.valueOf("green"));
                        txtGuardianContact.requestFocus();

                        boolean iaUpdate = bo.updateStudent(new StudentDTO(txtStudentID.getText(),
                                txtStudentName.getText(),
                                dpDOB.getValue().toString(),
                                batchId,
                                courseId,
                                txtAddress.getText(),
                                txtGuardianName.getText(),
                                txtGuardianContact.getText()
                        ));

                        if (iaUpdate) {
                            new Alert(Alert.AlertType.INFORMATION, "Update Successful", ButtonType.OK).show();
                            Clear();
                        } else {
                            new Alert(Alert.AlertType.INFORMATION, "Update Failed", ButtonType.OK).show();
                        }

                    }else{
                        txtGuardianContact.setFocusColor(Paint.valueOf("red"));
                        txtGuardianContact.requestFocus();
                    }
                }else{
                    txtGuardianName.setFocusColor(Paint.valueOf("red"));
                    txtGuardianName.requestFocus();
                }
            }else{
                txtAddress.setFocusColor(Paint.valueOf("red"));
                txtAddress.requestFocus();
            }
        }else{
            txtStudentName.setFocusColor(Paint.valueOf("red"));
            txtStudentName.requestFocus();
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

    public void btnCancelOnAction(ActionEvent actionEvent) {

    }


}

package controller;

import View.tm.AttendanceTM;
import View.tm.StudentTM;
import bo.BoFactory;
import bo.custom.AttendanceBO;
import bo.custom.BatchBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import dto.AttendanceDTO;
import dto.BatchDTO;
import dto.StudentDTO;
import entity.AttendanceEntity;
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

public class StudentAttendanceViewController implements Initializable {
    public Button btnCancel;
    public JFXTextField txtStudentId;
    public JFXComboBox cmbBatch;
    public TableView tblAttendance;
    public TableColumn colStudentId;
    public TableColumn colGrade;
    public TableColumn colDate;
    public TableColumn colTimeIn;
    public TableColumn colTimeOut;
    public JFXTimePicker tpArrivalTime;
    public JFXTimePicker tpLeavingTime;
    public JFXButton btnLeaving;
    public JFXButton btnArrival;
    AttendanceBO bo;

    private String attID="";

    ObservableList<String> batchList= FXCollections.observableArrayList();

    BatchBO batchBO = BoFactory.getInstance().getBo(BoFactory.BoType.BATCH);

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {

            bo = BoFactory.getInstance().getBo(BoFactory.BoType.ATTENDANCE);

//            colStudentId.setCellValueFactory(new PropertyValueFactory("studentID"));
//            colGrade.setCellValueFactory(new PropertyValueFactory("batchId"));
//            colDate.setCellValueFactory(new PropertyValueFactory("date"));
//            colTimeIn.setCellValueFactory(new PropertyValueFactory("arrivalTime"));
//            colTimeOut.setCellValueFactory(new PropertyValueFactory("courseId"));
//
//            tblAttendance.getSelectionModel().selectedItemProperty().
//                    addListener(((observable, oldValue, newValue) -> {
//                        setData((AttendanceTM) newValue);
//                    }));

//            loadAllAttendance();

            bo = BoFactory.getInstance().getBo(BoFactory.BoType.ATTENDANCE);

            attendanceId();

            ArrayList<BatchDTO> all1 = null;
            all1 = batchBO.getAll();
            for (BatchDTO dto : all1) {
                batchList.add(dto.getBatchName());
            }

            cmbBatch.setItems(batchList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setData(AttendanceTM tm) {
        txtStudentId.setText(String.valueOf(tm.getStudentId()));
        cmbBatch.setValue(tm.getBatchId());
        tpArrivalTime.setValue(tm.getArrivalTime());
        tpLeavingTime.setValue(tm.getLeavingTime());
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnArrivalOnAction(ActionEvent actionEvent) throws Exception {

        int batchId = batchBO.getId(cmbBatch.getValue().toString());

        boolean  isSaved = bo.addArrival(new AttendanceDTO(
                        attID,
                        txtStudentId.getText(),
                        batchId,
                        tpArrivalTime.getValue().toString(),
                        tpLeavingTime.getValue().toString()

        ));



        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Added Successful", ButtonType.OK).show();
            Clear();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Added Failed", ButtonType.OK).show();
        }
    }

        private void Clear() {
            txtStudentId.setText("");
            cmbBatch.setValue(null);
            tpArrivalTime.setValue(null);
            tpLeavingTime.setValue(null);
        }

    public void btnLeavingOnAction(ActionEvent actionEvent) throws Exception {

        int batchId = batchBO.getId(cmbBatch.getValue().toString());

        boolean iaUpdate = bo.addLeaving(new AttendanceDTO(
                attID,
                txtStudentId.getText(),
                batchId,
                tpArrivalTime.getValue().toString(),
                tpLeavingTime.getValue().toString()
        ));

        if (iaUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "Update Successful", ButtonType.OK).show();
            Clear();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Update Failed", ButtonType.OK).show();
        }
    }


    private void loadAllAttendance() throws Exception {

        ObservableList<AttendanceTM> tmList = FXCollections.observableArrayList();
        List<AttendanceDTO> allAttendance = bo.getAllAttendance();

        for (AttendanceDTO dto : allAttendance) {
            String batchId = batchBO.getName(dto.getBatchId());
            AttendanceTM tm = new AttendanceTM(dto.getStudentId(),
                    batchId,
                    dto.getArrivalTime(),
                    dto.getLeavingTime()
            );
            tmList.add(tm);
        }

        tblAttendance.setItems(tmList);

    }

    private void attendanceId(){

        String attendanceId;
        try {
            attendanceId = IDGenerator.getNewID("attendance", "attendanceId", "A");
            attID=attendanceId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

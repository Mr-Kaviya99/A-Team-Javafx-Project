package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ExamAndMarksViewController {
    public JFXTextField txtBatch;
    public JFXButton btnAdd;
    public Button btnCancel;
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtExamID;
    public JFXTextField txtMarks;
    public JFXTextField txtExamName;
    public JFXButton btnAddExam;
    public AnchorPane root1;

    private void initUi(String location) throws IOException {
        this.root1.getChildren().clear();
        this.root1.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void txtStudentIDOnAction(ActionEvent actionEvent) {
    }

    public void btnAddExamOnAction(ActionEvent actionEvent) throws IOException {
        initUi("AddExamForm.fxml");
    }
}

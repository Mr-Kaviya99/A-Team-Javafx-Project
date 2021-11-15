package controller;

import bo.BoFactory;
import bo.custom.ExamBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.AttendanceDTO;
import dto.ExamDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddExamFormController {
    public AnchorPane addExam;
    public JFXTextField txtExamName;
    public JFXButton btnAdd;
    public JFXTextField txtExamId;
    ExamBO bo;

    ExamBO examBO = BoFactory.getInstance().getBo(BoFactory.BoType.EXAM);

    public void initialize() throws Exception {

        Clear();

    }

    public void addExamOnAction(MouseEvent mouseEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = false;
        try {
            isSaved = bo.Save(
                    new ExamDTO(Integer.parseInt(txtExamId.getText()),
                            txtExamName.getText()
                    ));
            System.out.println(txtExamId.getText()+txtExamName.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Added Successful", ButtonType.OK).show();
            Clear();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Added Failed", ButtonType.OK).show();
        }
    }

    private void Clear() throws Exception {
        txtExamId.setText(examBO.getNextId() + "");
        txtExamName.setText("");
    }

}

package controller;

import bo.BoFactory;
import bo.custom.MonthBO;
import bo.custom.PaymentBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.MonthDAO;
import dto.MonthDTO;
import dto.PaymentDTO;
import dto.StudentDTO;
import generate.IDGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MonthlyPaymentController  implements Initializable {
    public Button btnCancel;
    public JFXButton btnSetPayment;
    public JFXComboBox cmbStudentId;
    public TableView tblPayment;
    public TableColumn colMonth;
    public TableColumn colPaymentStatus;
    public JFXComboBox cmbMonth;
    public JFXTextField cmbMonthlyPay;

    PaymentBO bo;
    private String paymentID="";

    ObservableList<String> monthList= FXCollections.observableArrayList();
    ObservableList<String> studentList= FXCollections.observableArrayList();

    MonthBO monthBO = BoFactory.getInstance().getBo(BoFactory.BoType.MONTH);
    StudentBO studentBO = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bo = BoFactory.getInstance().getBo(BoFactory.BoType.PAYMENT);

        try {

            PaymentID();

            List<StudentDTO> all1 = null;
            all1 = studentBO.getAllStudent();
            for (StudentDTO dto : all1) {
                studentList.add(dto.getStudentId());
            }

            cmbStudentId.setItems(studentList);


            List<MonthDTO> all2 = null;
            all2 = monthBO.getAll();
            for (MonthDTO dto : all2) {
                monthList.add(dto.getName());
            }

            cmbMonth.setItems(monthList);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public void btnSetPaymentOnAction(ActionEvent actionEvent) {

        boolean isSaved = false;

        try {
            isSaved = bo.save(new PaymentDTO(paymentID,
                    cmbStudentId.getValue().toString(),
                    cmbMonth.getValue().toString(),
                    new BigDecimal(cmbMonthlyPay.getText())
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Registration Successful", ButtonType.OK).show();
//            Clear();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Registration Failed", ButtonType.OK).show();
        }


    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }


    private void PaymentID(){

        String studentId;
        try {
            studentId = IDGenerator.getNewID("monthly_payment", "paymentID", "PAY");
            paymentID=studentId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

package controller;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DashBoardViewController {


    public Button btnStudentManagement;
    public Button btnMonthlyPayments;
    public Button btnExams_Marks;
    public Button btnStudentsAttendance;
    public AnchorPane root;
    public ImageView imgHome;
    public Button btnStudentRegistration;
    public ImageView imgStManage;
    public ImageView imgStuAttendance;
    public ImageView imgExamMarks;
    public ImageView imgMonPayment;
    public ImageView imgStudentRegistration;
    public Label lblTime;
    public Label lblDate;

    public void initialize() throws IOException {
        initUi("DefaultHomepageView.fxml");
        genarateOrderDate();
        setLblTime();
    }



    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/" + location)));

    }

    public void btnStudentManagementOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentManagementView.fxml");
    }

    public void btnMonthlyPaymentsOnAction(ActionEvent actionEvent) throws IOException {
        initUi("MonthlyPayment.fxml");
    }

    public void btnExams_MarksOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ExamAndMarksView.fxml");
    }

    public void btnStudentsAttendanceOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentAttendanceView.fxml");
    }

    public void imgHomeOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("DefaultHomepageView.fxml");
    }

    public void btnStudentRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentRegistrationView.fxml");
    }

    private void genarateOrderDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String orderDate = sdf.format(date);
        lblDate.setText(orderDate);
    }

    public void setLblTime(){
        Timeline timeline=new Timeline(new KeyFrame(Duration.ZERO, event -> {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("hh:mm");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void imgStudentRegistration(MouseEvent mouseEvent) throws IOException {
        initUi("StudentRegistrationView.fxml");
    }

    public void imgStManageOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("StudentManagementView.fxml");
    }

    public void imgStuAttendance(MouseEvent mouseEvent) throws IOException {
        initUi("StudentAttendanceView.fxml");
    }

    public void imgExamMarks(MouseEvent mouseEvent) throws IOException {
        initUi("ExamAndMarksView.fxml");
    }

    public void imgMonPaymentOnAction(MouseEvent mouseEvent) throws IOException {
        initUi("MonthlyPayment.fxml");
    }
}

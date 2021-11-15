package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import javafx.scene.control.Label;

public class DefaultHomepageViewController {
    public Label lblStudentCount;

    StudentBO studentBO = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

    public void initialize() {
        try {

            lblStudentCount.setText(String.valueOf(studentBO.getCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

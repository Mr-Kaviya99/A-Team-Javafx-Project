package View.tm;

import javafx.scene.control.Button;

public class StudentTM {
        private String studentID;
        private String studentName;
        private String dob;
        private String batchId;
        private String courseId;
        private String address;
        private String gurdianName;
        private String gurdianContact;
        private Button btn;

    public StudentTM(String studentId, String studentName, String dob, int batchId, int courseId, String address, String guardianName, String guardianContact) {
    }

    public StudentTM(String studentID, String studentName, String dob, String batchId, String courseId, String address, String gurdianName, String gurdianContact, Button btn) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dob = dob;
        this.batchId = batchId;
        this.courseId = courseId;
        this.address = address;
        this.gurdianName = gurdianName;
        this.gurdianContact = gurdianContact;
        this.btn = btn;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGurdianName() {
        return gurdianName;
    }

    public void setGurdianName(String gurdianName) {
        this.gurdianName = gurdianName;
    }

    public String getGurdianContact() {
        return gurdianContact;
    }

    public void setGurdianContact(String gurdianContact) {
        this.gurdianContact = gurdianContact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", dob='" + dob + '\'' +
                ", batchId=" + batchId +
                ", courseId='" + courseId + '\'' +
                ", address='" + address + '\'' +
                ", gurdianName='" + gurdianName + '\'' +
                ", gurdianContact='" + gurdianContact + '\'' +
                '}';
    }
}

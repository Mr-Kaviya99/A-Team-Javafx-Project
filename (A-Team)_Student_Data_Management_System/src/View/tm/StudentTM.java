package View.tm;

public class StudentTM {
        private String studentID;
        private String studentName;
        private String dob;
        private int grade;
        private int course;
        private String address;
        private String gurdianName;
        private String gurdianContact;

    public StudentTM() {
    }

    public StudentTM(String studentID, String studentName, String dob, int grade, int course, String address, String gurdianName, String gurdianContact) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dob = dob;
        this.grade = grade;
        this.course = course;
        this.address = address;
        this.gurdianName = gurdianName;
        this.gurdianContact = gurdianContact;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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

    @Override
    public String toString() {
        return "StudentTM{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", dob='" + dob + '\'' +
                ", grade=" + grade +
                ", course=" + course +
                ", address='" + address + '\'' +
                ", gurdianName='" + gurdianName + '\'' +
                ", gurdianContact='" + gurdianContact + '\'' +
                '}';
    }
}

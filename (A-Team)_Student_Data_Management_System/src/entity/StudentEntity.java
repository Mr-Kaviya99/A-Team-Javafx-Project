package entity;

public class StudentEntity implements SuperEntity {
    private String studentId;
    private String studentName;
    private String dob;
    private int batchId;
    private int courseId;
    private String address;
    private String guardianName;
    private String guardianContact;

    public StudentEntity() {
    }

    public StudentEntity(String studentId, String studentName, String dob, int batchId, int courseId, String address, String guardianName, String guardianContact) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.batchId = batchId;
        this.courseId = courseId;
        this.address = address;
        this.guardianName = guardianName;
        this.guardianContact = guardianContact;
    }

    public StudentEntity(String studentId, int batchId, int courseId, String studentName, String dob, String address, String guardianName, String guardianContact) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.batchId = batchId;
        this.courseId = courseId;
        this.address = address;
        this.guardianName = guardianName;
        this.guardianContact = guardianContact;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianContact() {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }
}

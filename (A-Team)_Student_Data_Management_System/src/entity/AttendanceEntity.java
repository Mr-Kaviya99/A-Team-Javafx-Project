package entity;

public class AttendanceEntity implements SuperEntity {
    private String attendanceId;
    private String studentId;
    private int batchId;
    private String arrivalTime;
    private String leavingTime;

    public AttendanceEntity() {
    }

    public AttendanceEntity(String attendanceId, String studentId, int batchId, String arrivalTime, String leavingTime) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.batchId = batchId;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }

    public AttendanceEntity(String studentId, int batchId, String arrivalTime, String leavingTime) {
        this.studentId = studentId;
        this.batchId = batchId;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int courseId) {
        this.batchId = batchId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(String leavingTime) {
        this.leavingTime = leavingTime;
    }
}

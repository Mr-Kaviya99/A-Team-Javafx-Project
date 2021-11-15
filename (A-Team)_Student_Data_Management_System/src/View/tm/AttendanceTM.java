package View.tm;

import java.time.LocalTime;

public class AttendanceTM {
    private String attendanceId;
    private String studentId;
    private String batchId;
    private String arrivalTime;
    private String leavingTime;

    public AttendanceTM() {
    }

    public AttendanceTM(String attendanceId, String studentId, String batchId, String arrivalTime, String leavingTime) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.batchId = batchId;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }

    public AttendanceTM(String studentId, String batchId, String arrivalTime, String leavingTime) {
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

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String courseId) {
        this.batchId = courseId;
    }

    public LocalTime getArrivalTime() {
        return LocalTime.parse(arrivalTime);
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getLeavingTime() {
        return LocalTime.parse(leavingTime);
    }

    public void setLeavingTime(String leavingTime) {
        this.leavingTime = leavingTime;
    }


}

package dto;

public class AttendanceDTO {
    private int attendanceID;
    private String arrivalTime;
    private String leavingTime;
    private String date;

    public AttendanceDTO() {
    }

    public AttendanceDTO(int attendanceID, String arrivalTime, String leavingTime, String date) {
        this.attendanceID = attendanceID;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
        this.date = date;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package dto;

public class AttendanceDTO {
    private String attId;
    private String studentId;
    private int batchId;
    private String arrivalTime;
    private String leavingTime;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String attId, String studentId, int batchId, String arrivalTime, String leavingTime) {
        this.attId = attId;
        this.studentId = studentId;
        this.batchId = batchId;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }

    public String getAttId() {
        return attId;
    }

    public void setAttId(String attId) {
        this.attId = attId;
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

    public void setBatchId(int batchId) {
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

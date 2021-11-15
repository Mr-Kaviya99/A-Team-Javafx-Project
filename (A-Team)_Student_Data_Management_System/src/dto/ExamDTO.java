package dto;

public class ExamDTO {
    private int examID;
    private String examName;
    private int marks;

    public ExamDTO(int i, String text) {
    }

    public ExamDTO(int examID, String examName, int marks) {
        this.examID = examID;
        this.examName = examName;
        this.marks = marks;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

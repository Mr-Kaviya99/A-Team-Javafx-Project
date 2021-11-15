package entity;

public class ExamEntity implements SuperEntity {
    private int examId;
    private String examName;

    public ExamEntity() {
    }

    public ExamEntity(int examId, String examName) {
        this.examId = examId;
        this.examName = examName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}

package entity;

public class CourseEntity implements SuperEntity {
    private int courseID;
    private String courseName;

    public CourseEntity() {
    }

    public CourseEntity(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

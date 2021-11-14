package bo.custom;

import dto.CourseDTO;

import java.util.ArrayList;

public interface CourseBO {
    public ArrayList<CourseDTO> getAll()throws Exception;
    public  int getId(String courseName)throws Exception;
}

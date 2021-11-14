package dao.custom;

import dao.SuperDAO;
import entity.CourseEntity;

import java.util.List;

public interface CourseDAO  extends SuperDAO<CourseEntity,String> {
    List<CourseEntity> getAll() throws Exception;
    public  int getId(String courseName)throws Exception;
    public int getNextId() throws Exception;
}

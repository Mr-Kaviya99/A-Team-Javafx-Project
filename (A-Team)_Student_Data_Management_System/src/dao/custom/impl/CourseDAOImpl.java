package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseDAO;
import entity.BatchEntity;
import entity.CourseEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<CourseEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Course");
        ArrayList<CourseEntity> CourseList = new ArrayList<>();
        while (resultSet.next()){
            CourseList.add(
                    new CourseEntity(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
        }
        return CourseList;
    }

    @Override
    public int getId(String courseName) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT courseId FROM Course WHERE courseName=?",courseName);
        int courseId = 0;
        if (resultSet.next()){
            courseId = resultSet.getInt(1);
        }
        return courseId;
    }

    @Override
    public int getNextId() throws Exception {
        return 0;
    }

    @Override
    public String getName(int courseId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT courseName FROM Course WHERE courseId=?",courseId);
        String courseName = "";
        if (resultSet.next()){
            courseName = resultSet.getString(1);
        }
        return courseName;
    }
}

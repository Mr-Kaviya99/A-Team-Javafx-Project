package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import db.DBConnection;
import entity.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {



    @Override
    public boolean save(StudentEntity entity) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1,entity.getStudentId());
        pstm.setObject(2,entity.getBatchId());
        pstm.setObject(3,entity.getCourseId());
        pstm.setObject(4,entity.getStudentName());
        pstm.setObject(5,entity.getDob());
        pstm.setObject(6,entity.getAddress());
        pstm.setObject(7,entity.getGuardianName());
        pstm.setObject(8,entity.getGuardianContact());
        pstm.setObject(9,new Date());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(StudentEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public List getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");
        ArrayList<StudentEntity> studentList = new ArrayList<>();
        while (resultSet.next()){
            studentList.add(
                    new StudentEntity(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)
                    ));
        }
        return studentList;
    }

    @Override
    public StudentEntity get() throws Exception {
        return null;
    }
}

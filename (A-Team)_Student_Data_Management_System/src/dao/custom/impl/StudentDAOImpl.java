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
    public boolean update(StudentEntity student) throws Exception {
        return CrudUtil.execute("UPDATE Student SET studentName=?, dob=?, batchId=?, courseId=?, address=?, guardianName=?, guardianContact=? WHERE StudentId=?",
                student.getStudentName(),
                student.getDob(),
                student.getBatchId(),
                student.getCourseId(),
                student.getAddress(),
                student.getGuardianName(),
                student.getGuardianContact(),
                student.getStudentId()
        );
    }

    @Override
    public boolean delete(String studentId) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE studentId=?",studentId);
    }

    @Override
    public List<StudentEntity> getAll() throws Exception {
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
    public StudentEntity get(String studentId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE id=?", studentId);
        if (resultSet.next()) {
            return new StudentEntity(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
        return null;
    }

    @Override
    public int getCount() throws Exception {
        int count = 0;
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(studentId) from Student");
        if (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }
}

package dao.custom.impl;

import dao.custom.AttendanceDAO;
import db.DBConnection;
import entity.AttendanceEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean save(AttendanceEntity entity) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO attendance VALUES (?,?,?,?,?,?)");
        pstm.setObject(1, entity.getAttendanceId());
        pstm.setObject(2,entity.getStudentId());
        pstm.setObject(3,entity.getBatchId());
        pstm.setObject(4,entity.getArrivalTime());
        pstm.setObject(5,entity.getLeavingTime());
        pstm.setObject(6, new Date());



        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(AttendanceEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String studentId) throws Exception {
        return false;
    }

    @Override
    public List<AttendanceEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public AttendanceEntity get(String studentId) throws Exception {
        return null;
    }

    @Override
    public AttendanceEntity get() throws Exception {
        return null;
    }
}

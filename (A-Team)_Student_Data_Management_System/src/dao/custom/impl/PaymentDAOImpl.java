package dao.custom.impl;

import dao.custom.PaymentDAO;
import db.DBConnection;
import entity.PaymentEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(PaymentEntity entity) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO monthly_payment VALUES (?,?,?,?)");
        pstm.setObject(1,entity.getPaymentID());
        pstm.setObject(2,entity.getStudentId());
        pstm.setObject(3,entity.getMonthName());
        pstm.setObject(4,entity.getMonthlyFee());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(PaymentEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public List<PaymentEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public PaymentEntity get(String key) throws Exception {
        return null;
    }
}

package bo.custom.impl;

import bo.custom.PaymentBO;
import dao.DaoFactory;
import dao.custom.PaymentDAO;
import dto.PaymentDTO;
import entity.PaymentEntity;

import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.PAYMENT);

    @Override
    public boolean save(PaymentDTO dto) throws Exception {
        return paymentDAO.save(new PaymentEntity(dto.getPaymentID(),
                dto.getStudentId(),
                dto.getMonthName(),
                dto.getMonthlyFee()
        ));
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public PaymentDTO get(String id) throws Exception {
        return null;
    }

    @Override
    public List<PaymentDTO> getAll() throws Exception {
        return null;
    }

    @Override
    public String getStudentId() throws Exception {
        return null;
    }
}

package bo.custom;

import dto.PaymentDTO;

import java.util.List;

public interface PaymentBO {
    public boolean save(PaymentDTO dto)throws Exception;
    public boolean update(PaymentDTO dto)throws Exception;
    public boolean delete(String id)throws Exception;
    public PaymentDTO get(String id)throws Exception;
    public List<PaymentDTO> getAll()throws Exception;
    public String getStudentId()throws Exception;
}

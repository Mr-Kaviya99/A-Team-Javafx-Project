package dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private String paymentID;
    private String studentId;
    private String monthName;
    private BigDecimal monthlyFee;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentID, String studentId, String monthName, BigDecimal monthlyFee) {
        this.paymentID = paymentID;
        this.studentId = studentId;
        this.monthName = monthName;
        this.monthlyFee = monthlyFee;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}

package dto;

public class paymentDTO {
    private int paymentID;
    private String paymentMonth;
    private double monthlyPayment;

    public paymentDTO() {
    }

    public paymentDTO(int paymentID, String paymentMonth, double monthlyPayment) {
        this.paymentID = paymentID;
        this.paymentMonth = paymentMonth;
        this.monthlyPayment = monthlyPayment;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(String paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}

package Entity;

import java.math.BigDecimal;

public class Payment {
    private int paymentId;
    private BigDecimal amount;
    public enum Status  { PENDING, SUCCESS, FAILED };
    private String currency;
    private Status status;

    public Payment(int paymentId, BigDecimal amount, String currency, Status status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "Payment ID: " + paymentId + ", Amount: " + amount + " " + currency + ", Status: " + status;
    }

}

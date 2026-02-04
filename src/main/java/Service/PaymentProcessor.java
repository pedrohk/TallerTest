package Service;

import Entity.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {

    List<Payment> paymentList = new ArrayList<>();

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public void addAllPayments(List<Payment> payments) {
        paymentList.addAll(payments);
    }

    public List<Payment> getAllPayments() {
        return paymentList;
    }

    public List<Payment> getPaymentsByStatus(Payment.Status status) {
        List<Payment> filteredPayments = new ArrayList<>();
        paymentList.stream().filter(
                p -> p.getStatus().equals(status))
                .forEach(p -> filteredPayments.add(p)
                );

        return filteredPayments;
    }

    public int getTotalPayments() {
        return paymentList.size();
    }

    public BigDecimal getTotalAmount() {
        return paymentList.stream()
                .filter(p -> p.getStatus() == Payment.Status.SUCCESS)
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public BigDecimal getAvarageAmount() {
        long successCount = paymentList.stream()
                .filter(p -> p.getStatus() == Payment.Status.SUCCESS)
                .count();

        if (successCount == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalAmount = getTotalAmount();
        return totalAmount.divide(BigDecimal.valueOf(successCount), BigDecimal.ROUND_HALF_UP);
    }

    public void printStatistics() {
        System.out.println(" --- Payment Statistics ---");
        System.out.println("Total Payments: " + getTotalPayments());
        System.out.println("Total Amount: " + getTotalAmount());
        System.out.println("Average Amount: " + getAvarageAmount());
    }




}

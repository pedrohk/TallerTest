import Entity.Payment;
import Service.PaymentProcessor;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.addPayment(new Payment(1, new java.math.BigDecimal("100.00"), "USD", Payment.Status.SUCCESS));
        paymentProcessor.addPayment(new Payment(2, new java.math.BigDecimal("50.00"), "USD", Payment.Status.PENDING));
        paymentProcessor.addPayment(new Payment(3, new java.math.BigDecimal("75.00"), "USD", Payment.Status.FAILED));
        paymentProcessor.addPayment(new Payment(4, new java.math.BigDecimal("200.00"), "USD", Payment.Status.SUCCESS));

        System.out.println("All Payments:");
        paymentProcessor.getAllPayments().forEach(System.out::println);

        paymentProcessor.printStatistics();


        System.out.println("processing heavy processing...");
        long count = paymentProcessor.getAllPayments().parallelStream().peek(
                p -> System.out.println("processing" + p.getPaymentId() + " on thread " + Thread.currentThread().getName()) ).count();




    }



}

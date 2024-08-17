package LLD.vending.machine;

public interface PaymentProcessor {
    public boolean processPayment(float price);
    public boolean refund();
}

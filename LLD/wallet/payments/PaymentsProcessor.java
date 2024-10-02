package wallet.payments;

import java.util.HashMap;
import java.util.Map;

public class PaymentsProcessor {
    
    static PaymentsProcessor paymentsProcessor;

    private PaymentsProcessor(){}

    public static PaymentsProcessor getPaymentsProcessorInstance(){
        if( paymentsProcessor == null){
            paymentsProcessor = new PaymentsProcessor();
        }
        return paymentsProcessor;
    }

    public boolean processPayment(int amount, PaymentType type){
        Payments payments;
        switch (type) {
            case CREDIT_CARD:
                payments = new CCPayments();
                return payments.process(amount);
            case DEBIT_CARD:
                payments = new DCPayments();
                return payments.process(amount);
            case UPI:
                payments = new UPIPayments();
                return payments.process(amount);
            default:
                payments = new UPIPayments();
                return payments.process(amount);
        }
    }

}

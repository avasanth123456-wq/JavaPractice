package InterfacePayment;

interface Payment {
    void pay(int amount);

    default void transactionDetails() {
        System.out.println(" Transaction processed successfully");
    }

    static void paymentGateway() {
        System.out.println("connecting to payment Gateway");
    }

    class CreditCardPayment implements Payment {
        public void pay(int amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card.");
        }
    }

    public class PaymentDemo {
        public static void main(String[] args) {
            Payment.paymentGateway();

            Payment p = new CreditCardPayment();
            p.pay(5000);
            p.transactionDetails();
        }

    }
}

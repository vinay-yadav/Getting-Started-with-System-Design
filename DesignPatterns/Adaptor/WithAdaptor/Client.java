package DesignPatterns.Adaptor.WithAdaptor;

public class Client {
    public static void main(String[] args) {
        BankAPIAdaptor bankAPIAdaptor = new YesBankAPIAdapter();
        PhonePe pe = new PhonePe(bankAPIAdaptor);
        try {
            System.out.println("Current balance: " + pe.doSomething());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

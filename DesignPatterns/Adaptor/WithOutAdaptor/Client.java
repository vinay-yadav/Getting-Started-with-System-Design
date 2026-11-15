package DesignPatterns.Adaptor.WithOutAdaptor;

public class Client {
    public static void main(String[] args) {
        PhonePe p = new PhonePe();
        int balance = p.checkBalance();
        System.out.println("Balance: " + balance);
    }
}

package DesignPatterns.Adaptor.WithAdaptor;

public interface BankAPIAdaptor {
    double getBalance(String accountNumber);

    boolean sendMoney(String fromAccount, String toAccount, double amount);
}

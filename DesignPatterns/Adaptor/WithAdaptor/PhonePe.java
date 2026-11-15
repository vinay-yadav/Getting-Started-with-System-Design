package DesignPatterns.Adaptor.WithAdaptor;

public class PhonePe {
    private BankAPIAdaptor bankAPI;

    public PhonePe(BankAPIAdaptor bankAPI) {
        this.bankAPI = bankAPI;
    }

    double doSomething() throws InterruptedException {
        double currentBalance = bankAPI.getBalance("accountNumber");
        return currentBalance * 2;
    }
}

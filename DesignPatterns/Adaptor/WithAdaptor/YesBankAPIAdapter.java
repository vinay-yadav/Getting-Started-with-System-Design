package DesignPatterns.Adaptor.WithAdaptor;

import DesignPatterns.Adaptor.WithAdaptor.thirdparty.YesBankAPI;

public class YesBankAPIAdapter implements BankAPIAdaptor {
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return yesBankAPI.checkBalance();
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}

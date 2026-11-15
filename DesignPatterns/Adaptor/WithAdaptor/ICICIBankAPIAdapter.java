package DesignPatterns.Adaptor.WithAdaptor;

import DesignPatterns.Adaptor.WithAdaptor.thirdparty.ICICIBankAPI;

public class ICICIBankAPIAdapter implements BankAPIAdaptor {
    private ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return iciciBankAPI.balanceCheck();
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}

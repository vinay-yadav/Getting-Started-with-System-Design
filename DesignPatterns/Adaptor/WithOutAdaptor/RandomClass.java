package DesignPatterns.Adaptor.WithOutAdaptor;

public class RandomClass {
    // YesBankAPI yesBankAPI;
    ICICIBankAPI iciciBankAPI;

    RandomClass() {
        // this.yesBankAPI = new YesBankAPI();
        this.iciciBankAPI = new ICICIBankAPI();
    }

    public void someRandomMethod() {
        // int b = yesBankAPI.getBalance();
        int b = iciciBankAPI.balanceCheck();
        System.out.println(b);
    }
}

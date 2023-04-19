package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
       super(name,balance,0);

       this.rate=rate;
       this.maxWithdrawalLimit=maxWithdrawalLimit;

      // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        if(amount <= maxWithdrawalLimit)
            super.withdraw(amount);
        else {
//        if(amount > maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        return getBalance()*(1+(rate*years)/100);
    }

    public double getCompoundInterest(int times, int years){
        return getBalance()*Math.pow((1+rate/(100*times)),times*years);
    }

}

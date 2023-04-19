package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
       super();
       this.setName(name);
       this.setBalance(balance);
       this.rate=rate;
       this.maxWithdrawalLimit=maxWithdrawalLimit;

       this.setMinBalance(0);// minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(amount>getBalance()){
            throw new Exception("Insufficient Balance");

        }
        this.withdraw(amount);
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        double finalAmount;
      finalAmount=this.getBalance() + (this.getBalance()* ((this.rate *years )/100 ));// Return the final amount considering that bank gives simple interest on current amount
         return finalAmount;
    }

    public double getCompoundInterest(int times, int years){
        double finalAmount;
        finalAmount = this.getBalance() * Math.pow(1 + (rate/times),(times*years));

        // Return the final amount considering that bank gives compound interest on current amount given times per year
                      return finalAmount;
    }

}

package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        String AccountNumber="";
       if(digits>9 || sum > 9*digits){
           throw new Exception("Account Number can not be generated");//Each digit of an account number can lie between 0 and 9 (both inclusive)
       }
       while(sum>=9){
           AccountNumber=AccountNumber+9;
           sum=sum-9;
       }
       if(sum>0){
           AccountNumber=AccountNumber+sum;
       }
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        return AccountNumber;
    }

    public void deposit(double amount) {
      this.balance=balance+amount;  //add amount to balance

    }

    public void withdraw(double amount) throws Exception {
        if(minBalance>(balance-amount)){
            throw new Exception("Insufficient Balance");// Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        }
          this.balance=balance-amount;
    }

}
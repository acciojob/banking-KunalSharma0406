package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        super();
        this.setName(name);
        this.setBalance(balance);
        this.institutionName=institutionName;
        this.setMinBalance(0);//minimum balance is 0 by default

    }

}

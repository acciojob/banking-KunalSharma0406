package com.driver;



public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
       if(balance<5000){
           throw new Exception("Insufficient Balance");// minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
       }



    }

    public void validateLicenseId() throws Exception {

        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int[] charCounts = new int[256]; // assumes ASCII characters
        for (int i = 0; i <this.tradeLicenseId.length(); i++) {
            char c = this.tradeLicenseId.charAt(i);
            charCounts[c]++;
        }

        int maxCount = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
            }
        }

        if (maxCount > (this.tradeLicenseId.length() + 1) / 2) {
            throw new Exception("Valid License ID cannot be generated.");
        }
    }
    }




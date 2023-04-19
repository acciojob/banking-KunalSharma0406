package com.driver;

import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super();
       if(balance<5000){
           throw new Exception("Insufficient Balance");// minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
       }

           this.setName(name);
            this.setBalance(balance);
            this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {

        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < this.tradeLicenseId.length(); i++) {
            char c = this.tradeLicenseId.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c : frequencyMap.keySet()) {
            if (frequencyMap.get(c) > (this.tradeLicenseId.length() + 1) / 2) {
                throw new Exception("Valid License ID cannot be generated.");
            }
        }
    }
    }



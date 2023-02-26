package com.aydin.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction{
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String payee,String phoneNumber,double amount) {
        super(amount, payee);
        this.phoneNumber = phoneNumber;
        this.setType("PhoneBillPaymentTransaction");
    }
}

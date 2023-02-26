package com.aydin.model;

public class CheckTransaction extends Transaction{

    public CheckTransaction(Double amount) {
        super(amount);
        this.setType("CheckTransaction");
    }
}
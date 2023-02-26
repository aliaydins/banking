package com.aydin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction() {
        this.setType("WithdrawalTransaction");
    }

    public WithdrawalTransaction(double amount) {
        super(amount);
        this.setType("WithdrawalTransaction");
    }
}


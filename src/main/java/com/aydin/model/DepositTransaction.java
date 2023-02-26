package com.aydin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositTransaction extends Transaction {

    public DepositTransaction() {
        this.setType("DepositTransaction");
    }

    public DepositTransaction(double amount) {
        super(amount);
        this.setType("DepositTransaction");
    }

}

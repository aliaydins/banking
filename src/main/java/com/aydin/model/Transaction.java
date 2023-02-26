package com.aydin.model;

import jakarta.persistence.Embeddable;

import java.util.Date;
import java.util.UUID;

@Embeddable
public class Transaction {
    private Date date;
    private double amount;
    private String type;
    private String approvalCode;

    public Transaction(double amount) {
        this.amount = amount;
        this.approvalCode = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public Transaction() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                ", approvalCode='" + approvalCode + '\'' +
                '}';
    }
}

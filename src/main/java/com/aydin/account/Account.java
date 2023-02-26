package com.aydin.account;

import com.aydin.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.util.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    private String owner;
    private String accountNumber;
    private double balance = 0.0;
    @CreatedDate
    private Date createDate = new Date();
    @ElementCollection
    private List<Transaction> transactions = new ArrayList<Transaction>();


    public Integer getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.createDate = new Date();
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", createDate=" + createDate +
                ", transactions=" + transactions +
                '}';
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {

        if (transaction instanceof DepositTransaction) {
            deposit(transaction.getAmount());
            transactions.add(transaction);
        }else if (transaction instanceof WithdrawalTransaction){
            withdraw(transaction.getAmount());
            transactions.add(transaction);
        }else if (transaction instanceof PhoneBillPaymentTransaction){
            payBill(transaction.getAmount());
            transactions.add(transaction);
        } else {
            throw new InsufficientBalanceException("Not Found Transaction Types.");
        }
    }

    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.getBalance() < amount) throw new InsufficientBalanceException("Insufficient Balance");
        this.setBalance(this.getBalance() - amount);
    }

    public void payBill(double amount) throws InsufficientBalanceException {
        withdraw(amount);
    }
}

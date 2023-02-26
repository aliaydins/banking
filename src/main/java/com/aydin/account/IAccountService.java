package com.aydin.account;

import com.aydin.model.DepositTransaction;
import com.aydin.model.InsufficientBalanceException;
import com.aydin.model.WithdrawalTransaction;
import com.aydin.utils.TransactionStatus;

public interface IAccountService {
    Account findAccount(String accountNumber);

    TransactionStatus credit(String accountNumber, DepositTransaction transaction) throws InsufficientBalanceException;

    TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException;
}

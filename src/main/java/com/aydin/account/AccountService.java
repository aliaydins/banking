package com.aydin.account;

import com.aydin.model.DepositTransaction;
import com.aydin.model.InsufficientBalanceException;
import com.aydin.model.WithdrawalTransaction;
import com.aydin.utils.TransactionStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findAccount(String accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber);
    }

    @Override
    public TransactionStatus credit(String accountNumber, DepositTransaction transaction) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if(account != null) {
            DepositTransaction depositTransaction = new DepositTransaction(transaction.getAmount());
            account.post(depositTransaction);
            accountRepository.save(account);
            TransactionStatus status = new TransactionStatus(HttpStatus.OK,depositTransaction.getApprovalCode());
            return status;
        }
        return null;
    }

    @Override
    public TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if(account !=null){
            WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(transaction.getAmount());
            account.post(withdrawalTransaction);
            accountRepository.save(account);
            TransactionStatus status = new TransactionStatus(HttpStatus.OK,withdrawalTransaction.getApprovalCode());
            return status;
        }
        return null;
    }
}

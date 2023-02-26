package com.aydin.account;

import com.aydin.model.DepositTransaction;
import com.aydin.model.InsufficientBalanceException;
import com.aydin.model.PhoneBillPaymentTransaction;
import com.aydin.model.WithdrawalTransaction;
import com.aydin.utils.TransactionStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "account/v1/")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAllAccount();
    }

    @GetMapping(path = "{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) {
        Account result = accountService.findAccount(accountNumber);
        if (result != null) return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<Account>(result, HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PostMapping("credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {
        TransactionStatus status = accountService.credit(accountNumber, transaction);
        if(status != null) return new ResponseEntity<TransactionStatus>(status, status.getStatus());
        return new ResponseEntity<TransactionStatus>(new TransactionStatus(HttpStatus.NOT_FOUND,null),HttpStatus.NOT_FOUND);
    }

    @PostMapping("debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        TransactionStatus status = accountService.debit(accountNumber, transaction);
        if(status!=null )return new ResponseEntity<TransactionStatus>(status, status.getStatus());
        return new ResponseEntity<TransactionStatus>(new TransactionStatus(HttpStatus.NOT_FOUND,null),HttpStatus.NOT_FOUND);
    }

}

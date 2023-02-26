package com.aydin.account;

import com.aydin.model.DepositTransaction;
import com.aydin.model.InsufficientBalanceException;
import com.aydin.model.PhoneBillPaymentTransaction;
import com.aydin.model.WithdrawalTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountModelTest {

    @Test
    public  void AccountModelTest() throws InsufficientBalanceException {
        Account account = new Account("Ali Aydın", "12345");
        account.post(new DepositTransaction(1000));
        account.post(new WithdrawalTransaction(200));
        account.post(new PhoneBillPaymentTransaction( "Vodafone","5536776261",96.50));
        assertEquals(account.getBalance(), 703.50, 0.0001);
    }

}
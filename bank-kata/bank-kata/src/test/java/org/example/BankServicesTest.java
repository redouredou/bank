package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankServicesTest {

    BankServices bankServices = new BankServicesImpl();

    @Test
    public void it_should_makeDeposit_of_10_on_selected_account(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingDepositByAccount(BigDecimal.valueOf(10), compteCourant);

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(110), compteCourant.getBalance());

    }

    @Test
    public void it_should_makeWithdrawal_of_10_on_selected_account(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(10), compteCourant);

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(90), compteCourant.getBalance());

    }

    @Test
    public void it_throw_an_IllegalArgumentException_when_withdrawal_amount_is_strictly_greater_than_account_balance(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));

        //WHEN
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(150), compteCourant);
        });

        String expectedMessage = "You can't withdraw more than you have in your account balance";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }
}

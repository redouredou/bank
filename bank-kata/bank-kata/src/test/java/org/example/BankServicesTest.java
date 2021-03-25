package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(150), compteCourant));

        String expectedMessage = Error.UNAUTHORIZED_WITHDRAWAL.toString();
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void it_should_display_an_empty_history_of_the_operation_accounts_if_there_is_no_operations(){
        //GIVEN
        Account account = new Account();

        //WHEN
        String history = bankServices.printStatementsHistory(account);

        //THEN
        Assertions.assertEquals("| OPERATION | DATE | AMOUNT | BALANCE |", history);
    }

    @Test
    public void it_should_display_an_history_with_one_operation_maked(){
        //GIVEN
        Account account = new Account();
        bankServices.makingDepositByAccount(BigDecimal.valueOf(50), account);

        //WHEN
        String history = bankServices.printStatementsHistory(account);

        //THEN
        Assertions.assertEquals("| OPERATION | DATE | AMOUNT | BALANCE |\n" +
                "| DEPOSIT | 25/03/2021 | 50 | 50 |", history);
    }
}

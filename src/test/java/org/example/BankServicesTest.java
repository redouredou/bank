package org.example;

import org.example.model.Account;
import org.example.model.Amount;
import org.example.model.Error;
import org.example.services.BankServices;
import org.example.services.BankServicesImpl;
import org.example.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

class BankServicesTest {

    BankServices bankServices = new BankServicesImpl();

    static String date;

    @BeforeAll
    static void init(){
        date = Utils.getFormattedDate(new Date());
    }

    @Test
    void it_should_makeDeposit_of_10_on_selected_account(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(10)), compteCourant);

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(110), compteCourant.getBalance());

    }

    @Test
    void it_should_makeWithdrawal_of_10_on_selected_account(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(10)), compteCourant);

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(90), compteCourant.getBalance());

    }

    @Test
    void it_throw_an_IllegalArgumentException_when_withdrawal_amount_is_strictly_greater_than_account_balance(){
        //GIVEN
        Account compteCourant = new Account(BigDecimal.valueOf(100));
        Amount amount = new Amount(BigDecimal.valueOf(150));
        //WHEN
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> bankServices.makingWithdrawalByAccount(amount, compteCourant));

        String expectedMessage = Error.UNAUTHORIZED_WITHDRAWAL.toString();
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void it_should_display_an_empty_history_of_the_operation_accounts_if_there_is_no_operations(){
        //GIVEN
        Account account = new Account();

        //WHEN
        String history = bankServices.printStatementsHistory(account);

        //THEN
        Assertions.assertEquals("| OPERATION | DATE | AMOUNT | BALANCE |", history);
    }

    @Test
    void it_should_display_an_history_with_one_operation_made(){
        //GIVEN
        Account account = new Account();
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(50)), account);

        //WHEN
        String history = bankServices.printStatementsHistory(account);

        //THEN
        Assertions.assertEquals("| OPERATION | DATE | AMOUNT | BALANCE |\n" +
                "| DEPOSIT | "+date+" | 50 | 50 |", history);
    }

    @Test
    void it_should_display_an_history_with_two_operation_made(){
        //GIVEN
        Account account = new Account();
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(50)), account);
        bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(10)), account);

        //WHEN
        String history = bankServices.printStatementsHistory(account);

        //THEN
        Assertions.assertEquals("| OPERATION | DATE | AMOUNT | BALANCE |\n" +
                "| DEPOSIT | "+date+" | 50 | 50 |\n" +
                "| WITHDRAWAL | "+date+" | 10 | 40 |", history);
    }

}

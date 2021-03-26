package org.example;

import org.example.model.Account;
import org.example.model.Amount;
import org.example.services.BankServices;
import org.example.services.BankServicesImpl;
import org.example.utils.Utils;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.util.Date;

class AccountStatementTest {

    BankServices bankServices = new BankServicesImpl();

    static String date;

    @BeforeAll
    public static void init(){
        date = Utils.getFormattedDate(new Date());
    }

    @Test
    @DisplayName("it should the one account statement according to the operation with the date, amount and balance")
    void it_should_have_one_account_statement_for_one_operation(){
        // GIVEN
        Account account = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(20)), account);

        //THEN
        Assertions.assertEquals(date, account.getAccountStatements().get(0).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(20), account.getAccountStatements().get(0).getAmount().getValue());
        Assertions.assertEquals(BigDecimal.valueOf(120), account.getAccountStatements().get(0).getBalance());
    }

    @Test
    @DisplayName("it should have two account statements according to the operations with the date, amount and balance")
    void it_should_have_two_account_statements_for_two_operation(){
        // GIVEN
        Account account = new Account(BigDecimal.valueOf(100));

        //WHEN
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(20)), account);
        bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(30)), account);

        //THEN
        Assertions.assertEquals(date, account.getAccountStatements().get(0).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(20), account.getAccountStatements().get(0).getAmount().getValue());
        Assertions.assertEquals(BigDecimal.valueOf(120), account.getAccountStatements().get(0).getBalance());

        Assertions.assertEquals(date, account.getAccountStatements().get(1).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(30), account.getAccountStatements().get(1).getAmount().getValue());
        Assertions.assertEquals(BigDecimal.valueOf(90), account.getAccountStatements().get(1).getBalance());
    }
}

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountStatementTest {

    BankServices bankServices = new BankServicesImpl();

    @Test
    @DisplayName("it should the one account statement according to the operation with the date, amount and balance")
    public void it_should_have_one_account_statement_for_one_operation(){
        // GIVEN

        Account account = new Account(BigDecimal.valueOf(100));
        AccountStatement accountStatement = new AccountStatement();

        List<AccountStatement> accountStatements = new ArrayList<>();

        bankServices.makingDepositByAccount(BigDecimal.valueOf(20), account, accountStatements);

        Assertions.assertEquals("25/03/2021", accountStatements.get(0).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(20), accountStatements.get(0).getAmount());
        Assertions.assertEquals(BigDecimal.valueOf(120), accountStatements.get(0).getBalance());
    }

    @Test
    @DisplayName("it should have two account statements according to the operations with the date, amount and balance")
    public void it_should_have_two_account_statements_for_two_operation(){
        // GIVEN

        Account account = new Account(BigDecimal.valueOf(100));
        List<AccountStatement> accountStatements = new ArrayList<>();

        bankServices.makingDepositByAccount(BigDecimal.valueOf(20), account, accountStatements);
        bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(30), account, accountStatements);

        Assertions.assertEquals("25/03/2021", accountStatements.get(0).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(20), accountStatements.get(0).getAmount());
        Assertions.assertEquals(BigDecimal.valueOf(120), accountStatements.get(0).getBalance());

        Assertions.assertEquals("25/03/2021", accountStatements.get(1).getDate());
        Assertions.assertEquals(BigDecimal.valueOf(30), accountStatements.get(1).getAmount());
        Assertions.assertEquals(BigDecimal.valueOf(90), accountStatements.get(1).getBalance());
    }
}

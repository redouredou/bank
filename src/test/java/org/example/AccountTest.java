package org.example;


import org.example.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

class AccountTest
{

    @Test
    @DisplayName("It should have 0 in the account when it's created by default")
    void it_should_have_0_in_the_account_when_account_created(){
        //GIVEN
        Account account = new Account();

        //WHEN
        BigDecimal actualBalance = account.getBalance();

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(0), actualBalance);
    }

    @Test
    @DisplayName("It should have 100 in the account when the account is initialized with 100")
    void it_should_have_100_in_the_account_when_account_is_initialized_with_100(){
        //GIVEN
        Account account = new Account(BigDecimal.valueOf(100));

        //WHEN
        BigDecimal actualBalance = account.getBalance();

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(100), actualBalance);
    }

    @Test
    @DisplayName("It should have 200 in the account balance when add 100")
    void it_should_have_200_in_the_account_when_add_100(){
        //GIVEN
        Account account = new Account(BigDecimal.valueOf(100));

        //WHEN
        account.add(BigDecimal.valueOf(100));

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(200), account.getBalance());
    }

    @Test
    @DisplayName("It should have 100 in the account balance when subtract 50")
    void it_should_have_100_in_the_account_when_remove_50(){
        //GIVEN
        Account account = new Account(BigDecimal.valueOf(150));

        //WHEN
        account.subtract(BigDecimal.valueOf(50));

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(100), account.getBalance());
    }

    @Test
    @DisplayName("It should return UnsupportedOperationException when adding into getAccountStatements list")
    void it_should_throw_UnsupportedOperationException_when_add_into_getAccountStatements_list(){
        //GIVEN
        Account account = new Account(BigDecimal.valueOf(150));
        AccountStatement accountException = new AccountStatement(OperationTypes.DEPOSIT, "25/03/20", new Amount(BigDecimal.TEN), BigDecimal.TEN);

        account.updateAccountStatements(OperationTypes.DEPOSIT, "25/03/20", new Amount(BigDecimal.TEN));

        List<AccountStatement> accountStatementList = account.getAccountStatements();

        //WHEN
        Assertions.assertThrows( UnsupportedOperationException.class, () -> {
            accountStatementList.add(accountException);
        });

    }


}

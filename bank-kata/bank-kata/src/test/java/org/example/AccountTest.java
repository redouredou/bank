package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest
{

    @Test
    @DisplayName("It should have 0 to the account when it's created by default")
    public void it_should_have_0_to_the_account_when_account_created(){
        //GIVEN
        Account account = new Account();

        //WHEN
        BigDecimal actualBalance = account.getBalance();

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(0), actualBalance);
    }

    @Test
    @DisplayName("It should have 100 to the account when the account is initialized with 100")
    public void it_should_have_100_to_the_account_when_account_is_initialized_with_100(){
        //GIVEN
        Account account = new Account(BigDecimal.valueOf(100));

        //WHEN
        BigDecimal actualBalance = account.getBalance();

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(100), actualBalance);
    }
}

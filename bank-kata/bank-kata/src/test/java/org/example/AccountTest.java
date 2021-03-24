package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest
{

    @Test
    @DisplayName("It should have 0 to the account when it's created")
    public void it_should_have_0_to_the_account_when_account_created(){
        //GIVEN
        Account account = new Account();

        //WHEN
        BigDecimal actualBalance = account.getBalance();

        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(0), actualBalance);
    }
}

package org.example;

import java.math.BigDecimal;

public class Account {
    BigDecimal balance;

    public Account(){
        this.balance = BigDecimal.valueOf(0);
    }

    public BigDecimal getBalance(){
        return this.balance;
    }
}

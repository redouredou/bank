package org.example;

import java.math.BigDecimal;

public class Account {
    BigDecimal balance;

    public Account(){
        this.balance = BigDecimal.valueOf(0);
    }

    public Account(BigDecimal balance){
        this.balance = balance;
    }
    public BigDecimal getBalance(){
        return this.balance;
    }
}

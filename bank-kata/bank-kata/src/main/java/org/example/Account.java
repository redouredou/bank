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

    public void add(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void subtract(BigDecimal amount){
        this.balance = this.balance.subtract(amount);
    }

}

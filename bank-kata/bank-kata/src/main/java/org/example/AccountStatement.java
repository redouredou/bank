package org.example;

import java.math.BigDecimal;
import java.util.Date;

public class AccountStatement {
    private BigDecimal balance;
    private String date;
    private BigDecimal amount;

    public AccountStatement(){}

    public AccountStatement(String date, BigDecimal amount, BigDecimal balance){
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

package org.example;

import java.math.BigDecimal;

public class AccountStatement {
    private OperationTypes operationTypes;
    private BigDecimal balance;
    private String date;
    private BigDecimal amount;

    public AccountStatement(){}

    public AccountStatement(OperationTypes operationTypes, String date, BigDecimal amount, BigDecimal balance){
        this.operationTypes = operationTypes;
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

    public String getOperationTypes(){
        return this.operationTypes.name();
    }
}

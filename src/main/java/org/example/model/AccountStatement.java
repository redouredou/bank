package org.example.model;

import java.math.BigDecimal;

public class AccountStatement {
    private OperationTypes operationTypes;
    private BigDecimal balance;
    private String date;
    private Amount amount;

    public AccountStatement(){}

    public AccountStatement(OperationTypes operationTypes, String date, Amount amount, BigDecimal balance){
        this.operationTypes = operationTypes;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getDate() {
        return date;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getOperationTypes(){
        return this.operationTypes.name();
    }
}

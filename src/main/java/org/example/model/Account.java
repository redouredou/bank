package org.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    BigDecimal balance;
    List<AccountStatement> accountStatements;

    public Account(){
        this.balance = BigDecimal.valueOf(0);
        accountStatements = new ArrayList<>();
    }

    public Account(BigDecimal balance){
        this.balance = balance;
        accountStatements = new ArrayList<>();
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

    public void updateAccountStatements(OperationTypes operationTypes,String date, Amount amount){
        accountStatements.add(new AccountStatement(operationTypes, date, amount, this.balance));
    }

    public List<AccountStatement> getAccountStatements(){
        return Collections.unmodifiableList(accountStatements);
    }


}

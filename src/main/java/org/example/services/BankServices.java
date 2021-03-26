package org.example.services;

import org.example.model.Account;

import java.math.BigDecimal;

public interface BankServices{
     void makingDepositByAccount(BigDecimal depositAmount, Account account);
     void makingWithdrawalByAccount(BigDecimal withdrawalAmount, Account account);
     String printStatementsHistory(Account account);
}

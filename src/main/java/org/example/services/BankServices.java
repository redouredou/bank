package org.example.services;

import org.example.model.Account;
import org.example.model.Amount;

public interface BankServices{
     void makingDepositByAccount(Amount depositAmount, Account account);
     void makingWithdrawalByAccount(Amount withdrawalAmount, Account account);
     String printStatementsHistory(Account account);
}

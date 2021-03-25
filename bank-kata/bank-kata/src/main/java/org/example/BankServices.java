package org.example;

import java.math.BigDecimal;
import java.util.List;

public interface BankServices {
     void makingDepositByAccount(BigDecimal depositAmount, Account account);
     void makingWithdrawalByAccount(BigDecimal withdrawalAmount, Account account);
}

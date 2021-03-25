package org.example;

import java.math.BigDecimal;
import java.util.List;

public interface BankServices {
     void makingDepositByAccount(BigDecimal depositAmount, Account account, List<AccountStatement> accountStatement);
     void makingWithdrawalByAccount(BigDecimal withdrawalAmount, Account account, List<AccountStatement> accountStatement);
}

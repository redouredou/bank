package org.example;

import java.math.BigDecimal;

public class BankServicesImpl implements BankServices{


    @Override
    public void makingDepositByAccount(BigDecimal depositAmount, Account account) {
        account.add(depositAmount);
    }

    @Override
    public void makingWithdrawalByAccount(BigDecimal withdrawalAccount, Account account) {
        account.subtract(withdrawalAccount);
    }
}

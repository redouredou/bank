package org.example;

import java.math.BigDecimal;

public class BankServicesImpl implements BankServices{


    @Override
    public void makingDepositByAccount(BigDecimal depositAmount, Account account) {
        account.add(depositAmount);
    }

    @Override
    public void makingWithdrawalByAccount(BigDecimal withdrawalAccount, Account account) {
        if(withdrawalAccount.compareTo(account.getBalance()) == -1){
            account.subtract(withdrawalAccount);
        }else{
            throw new IllegalArgumentException(Error.UNAUTHORIZED_WITHDRAWAL.toString());
        }
    }
}

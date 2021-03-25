package org.example;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BankServicesImpl implements BankServices{


    @Override
    public void makingDepositByAccount(BigDecimal depositAmount, Account account, List<AccountStatement> accountStatements) {
        account.add(depositAmount);
        accountStatements.add(new AccountStatement(
                Utils.getFormattedDate(new Date()),
                depositAmount,
                account.getBalance()));
    }

    @Override
    public void makingWithdrawalByAccount(BigDecimal withdrawalAccount, Account account, List<AccountStatement> accountStatements) {
        if(withdrawalAccount.compareTo(account.getBalance()) < 0){
            account.subtract(withdrawalAccount);
            accountStatements.add(new AccountStatement(
                    Utils.getFormattedDate(new Date()),
                    withdrawalAccount,
                    account.getBalance()));
        }else{
            throw new IllegalArgumentException(Error.UNAUTHORIZED_WITHDRAWAL.toString());
        }
    }
}

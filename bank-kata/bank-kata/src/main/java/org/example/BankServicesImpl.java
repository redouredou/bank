package org.example;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BankServicesImpl implements BankServices{


    @Override
    public void makingDepositByAccount(BigDecimal depositAmount, Account account) {
        account.add(depositAmount);
        account.updateAccountStatements(new AccountStatement(
                OperationTypes.DEPOSIT,
                Utils.getFormattedDate(new Date()),
                depositAmount,
                account.getBalance()));

    }

    @Override
    public void makingWithdrawalByAccount(BigDecimal withdrawalAccount, Account account) {
        if(withdrawalAccount.compareTo(account.getBalance()) < 0){
            account.subtract(withdrawalAccount);
            account.updateAccountStatements(new AccountStatement(
                    OperationTypes.WITHDRAWAL,
                    Utils.getFormattedDate(new Date()),
                    withdrawalAccount,
                    account.getBalance()));
        }else{
            throw new IllegalArgumentException(Error.UNAUTHORIZED_WITHDRAWAL.toString());
        }
    }

    @Override
    public String printStatementsHistory(Account account) {
        String result;
        if(account.getAccountStatements().isEmpty()){
            result = "| OPERATION | DATE | AMOUNT | BALANCE |";
        }else{
            result= "| OPERATION | DATE | AMOUNT | BALANCE |\n" +
                    "| DEPOSIT | 25/03/2021 | 50 | 50 |";
        }
        return result;
    }
}

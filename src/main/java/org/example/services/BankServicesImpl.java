package org.example.services;

import org.example.model.Account;
import org.example.model.AccountStatement;
import org.example.model.Error;
import org.example.model.OperationTypes;
import org.example.utils.Utils;

import java.math.BigDecimal;
import java.util.Date;

public class BankServicesImpl implements BankServices {


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
    public void makingWithdrawalByAccount(BigDecimal withdrawalAccount, Account account){
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
        StringBuilder result;
        if(account.getAccountStatements().isEmpty()){
            result = new StringBuilder("| OPERATION | DATE | AMOUNT | BALANCE |");
        }else{
            result = new StringBuilder("| OPERATION | DATE | AMOUNT | BALANCE |\n");
            AccountStatement accountStatement;
            for(int i = 0; i < account.getAccountStatements().size() ; i++){
                accountStatement = account.getAccountStatements().get(i);
                result.append("| ").append(accountStatement.getOperationTypes())
                        .append(" | ").append(accountStatement.getDate())
                        .append(" | ").append(accountStatement.getAmount())
                        .append(" | ").append(accountStatement.getBalance()).append(" |");
                if(i != account.getAccountStatements().size() - 1){
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
}

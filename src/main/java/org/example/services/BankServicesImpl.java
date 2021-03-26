package org.example.services;

import org.example.model.*;
import org.example.model.Error;
import org.example.utils.Utils;
import java.util.Date;

public class BankServicesImpl implements BankServices {


    @Override
    public void makingDepositByAccount(Amount depositAmount, Account account) {
        account.add(depositAmount.getValue());
        account.updateAccountStatements(
                OperationTypes.DEPOSIT,
                Utils.getFormattedDate(new Date()),
                depositAmount);

    }

    @Override
    public void makingWithdrawalByAccount(Amount withdrawalAccount, Account account){
        if(withdrawalAccount.getValue().compareTo(account.getBalance()) < 0){
            account.subtract(withdrawalAccount.getValue());
            account.updateAccountStatements(
                    OperationTypes.WITHDRAWAL,
                    Utils.getFormattedDate(new Date()),
                    withdrawalAccount);
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
                        .append(" | ").append(accountStatement.getAmount().getValue())
                        .append(" | ").append(accountStatement.getBalance()).append(" |");
                if(i != account.getAccountStatements().size() - 1){
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
}

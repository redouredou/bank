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
        String result;
        StringBuilder resultBuilder;
        if(account.getAccountStatements().isEmpty()){
            result = "| OPERATION | DATE | AMOUNT | BALANCE |";
        }else{
            resultBuilder = new StringBuilder("| OPERATION | DATE | AMOUNT | BALANCE |\n");
            account.getAccountStatements().forEach(accountStatement ->
                    resultBuilder.append("| ").append(accountStatement.getOperationTypes())
                        .append(" | ").append(accountStatement.getDate())
                        .append(" | ").append(accountStatement.getAmount().getValue())
                        .append(" | ").append(accountStatement.getBalance()).append(" |")
                        .append("\n"));

                result = resultBuilder.substring(0, resultBuilder.length() - 1);
        }
        return result;
    }
}

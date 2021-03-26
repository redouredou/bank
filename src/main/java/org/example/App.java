package org.example;

import org.example.model.Account;
import org.example.model.Amount;
import org.example.services.BankServices;
import org.example.services.BankServicesImpl;
import java.math.BigDecimal;


public class App
{

    public static void main( String[] args )
    {
        Account compteCourant = new Account();
        BankServices bankServices = new BankServicesImpl();

        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(100)), compteCourant);
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(100.0326)), compteCourant);
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(100)), compteCourant);
        bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(23)), compteCourant);
        bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(53)), compteCourant);
        try{
            bankServices.makingWithdrawalByAccount(new Amount(BigDecimal.valueOf(400)), compteCourant);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(39)), compteCourant);
        bankServices.makingDepositByAccount(new Amount(BigDecimal.valueOf(39)), compteCourant);

        System.out.println(bankServices.printStatementsHistory(compteCourant));



    }
}

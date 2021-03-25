package org.example;

import org.example.model.Account;
import org.example.services.BankServices;
import org.example.services.BankServicesImpl;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Account compteCourant = new Account();
        BankServices bankServices = new BankServicesImpl();

            bankServices.makingDepositByAccount(BigDecimal.valueOf(100), compteCourant);
            bankServices.makingDepositByAccount(BigDecimal.valueOf(100.0326), compteCourant);
            bankServices.makingDepositByAccount(BigDecimal.valueOf(100), compteCourant);
            bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(23), compteCourant);
            bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(53), compteCourant);
            try{
                bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(400), compteCourant);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            bankServices.makingDepositByAccount(BigDecimal.valueOf(39), compteCourant);
            bankServices.makingDepositByAccount(BigDecimal.valueOf(39), compteCourant);



            System.out.println(bankServices.printStatementsHistory(compteCourant));



    }
}

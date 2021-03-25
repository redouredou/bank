package org.example;

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
        bankServices.makingDepositByAccount(BigDecimal.valueOf(100), compteCourant);
        bankServices.makingDepositByAccount(BigDecimal.valueOf(100), compteCourant);
        bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(23), compteCourant);
        bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(53), compteCourant);
        bankServices.makingDepositByAccount(BigDecimal.valueOf(39), compteCourant);
        bankServices.makingWithdrawalByAccount(BigDecimal.valueOf(300), compteCourant);

        System.out.println(bankServices.printStatementsHistory(compteCourant));
    }
}

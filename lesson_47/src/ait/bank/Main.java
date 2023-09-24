package ait.bank;

import ait.bank.model.Account;
import ait.bank.model.AccountCreateException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list= List.of("DE1234567890123","DE1234567890124","DR1234567890123","DD1234567");
        List<Account> accounts = new ArrayList<>();

        for (String str: list) {

            try {
                accounts.add(createAccount(str));

            } catch (AccountCreateException e) {
                System.out.println("---  " +str);
                System.out.println(e.getErrorsList());
            }
        }

        System.out.println(accounts);
    }

    public static Account createAccount(String iban) throws AccountCreateException{
        List<String> errors = new ArrayList<>();
        AccountCreateException exception = new AccountCreateException(errors);

        if(iban==null || !isNumbersOnly(iban.substring(2))) errors.add("Error 1");
        if(iban.length()<14 || iban.length()>16) errors.add("Error 2");
        if(!iban.startsWith("DE")) errors.add("Error 3");

        if(!errors.isEmpty()) throw exception;

        return new Account(iban);
    }

    private  static boolean isNumbersOnly(String str){
        for (char ch:str.toCharArray()){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
}

package ait.bank;

import ait.bank.model.Account;
import ait.bank.exceptions.*;
import ait.bank.model.Person;

import java.util.*;

public class BankingAppl {
    public static void main(String[] args) {
        List<String> list= List.of("DE1613321892788;Jack Johnson","DE1234567890124;May", "DE16133Y4427567;","UK16123244275;Ann Smith");
        List<Account> accounts = new ArrayList<>();

        for (String str: list) {

            try {
                accounts.add(createAccount(str));

            } catch (AccountCreateException e) {
                System.out.println("---  " +str);
                System.out.println(e.getErrorList());
            }
        }

        System.out.println(accounts);

    }

    public static Account createAccount(String account) throws AccountCreateException {
        List<String> errors = new ArrayList<>();
        AccountCreateException exception = new AccountCreateException(errors);

        String[] arr = account.split(";");
        String iban = arr[0];
        List<String> list;
        String firstN = "";
        String lastN = "";

        if (arr.length < 2){
            errors.add("Owner field is missing");
        }else{
            list = List.of(arr[1].split(" "));
            if (list.size() < 2){
                errors.add("Owner name should be full");
            }else{
                firstN = list.get(0);
                lastN = list.get(1);
            }
        }

        if(iban.isEmpty() || !isNumbersOnly(iban.substring(2))) errors.add("argument is not correct");
        if(iban.length()<15) errors.add("The iban should be no less [15] character length");
        if(!iban.startsWith("DE")) errors.add("The country code should be 'DE'");


        if (!errors.isEmpty()) throw exception;

        return new Account(iban,new Person(firstN, lastN));
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

package ait.bank;

import ait.bank.model.Account;
import ait.bank.model.AccountFormatException;
import ait.bank.model.WrongAccountCountryCodeException;
import static ait.bank.model.Account.createAccount;

public class BankingAppl {

    /*
    Представте, вы пишете банковскую программу.
    Создайте два checked exception:   AccountFormatException и WrongAccountCountryCodeException.
    Напишите метод, который получает строеку с номером вида: DE171271782891.
    Если строка короче 14 символов или длиннее 16  - >  AccountFormatException.
    Если строка не начинается с символов "DE" - WrongAccountCountryCodeException,
    если что-то другое (например передан null) ->  IllegalArgumentException.
    При нормалтном потоке выполнения, метод создает новый объект Accaunt и возвращает его.
    Напишите вызов вашего метода с обработкой возможных исключений.
     */
    public static void main(String[] args) {
        try{
            Account account = createAccount("DR1234567890123");
            //Account account = createAccount(null);
            System.out.println(account);
        } catch (IllegalArgumentException e){
            System.err.println("arg is not correct");
        } catch (AccountFormatException e){
            System.err.println("The iban should be [14,16] character len");
        } catch (WrongAccountCountryCodeException e){
            System.err.println("The country code should be 'DE' ");
        }
    }
}

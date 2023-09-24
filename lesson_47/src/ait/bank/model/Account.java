package ait.bank.model;

public class Account {
    private String iban;

    public Account(String code) {
        this.iban = code;
    }

    @Override
    public String toString() {
        return "Account{" +
                "code='" + iban + '\'' +
                '}';
    }
    public static Account createAccount(String iban) throws AccountFormatException, WrongAccountCountryCodeException {
        if (iban == null || !isDigitsOnly(iban.substring(2))) throw new IllegalArgumentException();
        if (iban.length() < 14 || iban.length() > 16) throw new AccountFormatException();
        if (!iban.startsWith("DE")) throw new WrongAccountCountryCodeException();
        return new Account(iban);
    }

    public static boolean isDigitsOnly(String str){
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }
}

package ait.exception;

public class Main {
    /*
    Написать метод, который получает в качестве параметра строку длтнной 16 символов и,
    если строка не соответствует этому требованию выбрасывает IllegalArgumentException
    */

    public static void main(String[] args) {
        String str1 = "1234567890123456";
        String str2 = "12345";

        printString(str1);
        printString(str2);
    }

    public static void printString(String string){
        if (string == null ||string.length() != 16) throw new IllegalArgumentException("String length [16]");
        System.out.println(string);
    }
}

package ait.bank.exceptions;

import java.util.List;

public class AccountCreateException extends Exception{
    private List<String> errorList;

    public AccountCreateException(List<String> errorList) {
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}

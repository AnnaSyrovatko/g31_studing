package ait.bank.model;

import java.util.List;

public class AccountCreateException extends Exception {
    private List<String> errorsList;

    public AccountCreateException(List<String> errorsList) {
        this.errorsList = errorsList;
    }

    public List<String> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<String> errorsList) {
        this.errorsList = errorsList;
    }
}

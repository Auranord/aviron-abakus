package de.aviron.abakus.enums;

public enum BankTransactionError {
    TEST("Test");

    private final String error;

    BankTransactionError(String error) {
        this.error = error;
    }
    
    public String getError() {
        return error;
    }
    
}

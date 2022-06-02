package de.aviron.abakus.enums;

public enum ErrorMessage {
    USER_EXISTS("Benutzer existiert bereits", "Der angegebene Benutzer existiert bereits."),
    LOGIN_FAILED("Login fehlgeschlagen", "Die angegebenen Benutzerdaten sind ungültig.");

    private final String error;
    private final String message;

    ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }
    
    public String getError() {
        return error;
    }

    public String getErrorMessage() {
        return message;
    }
}

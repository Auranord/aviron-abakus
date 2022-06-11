package de.aviron.abakus.enums;

public enum UserStatus {
    VACATION("Urlaubsmodus"),
    INACTIVE("Inaktiv"),
    BANNED("Gesperrt");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }

}

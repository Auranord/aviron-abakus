package de.aviron.abakus.enums;

public enum UserPermission {
    TEST_TEST("test:test");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
    
    public String getPermission() {
        return permission;
    }

}

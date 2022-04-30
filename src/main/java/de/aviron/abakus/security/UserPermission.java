package de.aviron.abakus.security;

public enum UserPermission {
    FIGURE_READ("figure:read"),
    FIGURE_WRITE("figure:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
    
    public String getPermission() {
        return permission;
    }

}

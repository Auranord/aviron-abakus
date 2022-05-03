package de.aviron.abakus.enums;

public enum UserSince {
    ADERSIN_OLD("Adersin: Alte Welt"),
    ADERSIN_NEW("Adersin: Neue Welt"),
    ADERSIN_GAIA("Adersin: Gaia");

    private final String since;

    UserSince(String since) {
        this.since = since;
    }
    
    public String getSince() {
        return since;
    }

}

package de.aviron.abakus.enums;

public enum JournalCategory {
    TEST("Test");

    private final String category;

    JournalCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return category;
    }
    
}

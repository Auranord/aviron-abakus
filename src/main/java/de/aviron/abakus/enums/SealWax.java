package de.aviron.abakus.enums;

public enum SealWax {
    SEAL_A(12345),
    SEAL_B(12345),
    SEAL_C(12345);

    private final Integer wax; // wax ist eine image id

    SealWax(Integer wax) {
        this.wax = wax;
    }
    
    public Integer getWax() {
        return wax;
    }    

}

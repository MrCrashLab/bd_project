package test.Models;

public class Employess {
    private String NAME;
    private String SURNAME;
    private String RANG;

    public Employess(String NAME, String SURNAME, String RANG) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.RANG = RANG;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public String getRANG() {
        return RANG;
    }

    public void setRANG(String RANG) {
        this.RANG = RANG;
    }
}

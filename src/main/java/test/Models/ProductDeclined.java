package test.Models;

public class ProductDeclined {
    private String Type;
    private int Number;

    public ProductDeclined(String type, int number) {
        Type = type;
        Number = number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}

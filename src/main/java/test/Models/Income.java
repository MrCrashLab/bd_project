package test.Models;

public class Income {
    private String Type;
    private String Main;
    private String Confirmation;
    private String Periodicity;
    private String PaymentManner;
    private String Currency;
    private String Value;
    private String Average;

    public Income(String type, String main, String confirmation, String periodicity, String paymentManner, String currency, String value, String average) {
        Type = type;
        Main = main;
        Confirmation = confirmation;
        Periodicity = periodicity;
        PaymentManner = paymentManner;
        Currency = currency;
        Value = value;
        Average = average;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMain() {
        return Main;
    }

    public void setMain(String main) {
        Main = main;
    }

    public String getConfirmation() {
        return Confirmation;
    }

    public void setConfirmation(String confirmation) {
        Confirmation = confirmation;
    }

    public String getPeriodicity() {
        return Periodicity;
    }

    public void setPeriodicity(String periodicity) {
        Periodicity = periodicity;
    }

    public String getPaymentManner() {
        return PaymentManner;
    }

    public void setPaymentManner(String paymentManner) {
        PaymentManner = paymentManner;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getAverage() {
        return Average;
    }

    public void setAverage(String average) {
        Average = average;
    }
}

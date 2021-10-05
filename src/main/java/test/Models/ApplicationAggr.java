package test.Models;

import java.sql.Date;

public class ApplicationAggr {
    private String Type;
    private int Number;
    private int TotalLimit;
    private int TotalPayment;
    private int LimitProductCategory;
    private int LimitProductName;
    private Date LastDateCreated;
    private Date LastDateFunded;

    public ApplicationAggr(String type, int number, int totalLimit, int totalPayment, int limitProductCategory, int limitProductName, Date lastDateCreated, Date lastDateFunded) {
        Type = type;
        Number = number;
        TotalLimit = totalLimit;
        TotalPayment = totalPayment;
        LimitProductCategory = limitProductCategory;
        LimitProductName = limitProductName;
        LastDateCreated = lastDateCreated;
        LastDateFunded = lastDateFunded;
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

    public int getTotalLimit() {
        return TotalLimit;
    }

    public void setTotalLimit(int totalLimit) {
        TotalLimit = totalLimit;
    }

    public int getTotalPayment() {
        return TotalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        TotalPayment = totalPayment;
    }

    public int getLimitProductCategory() {
        return LimitProductCategory;
    }

    public void setLimitProductCategory(int limitProductCategory) {
        LimitProductCategory = limitProductCategory;
    }

    public int getLimitProductName() {
        return LimitProductName;
    }

    public void setLimitProductName(int limitProductName) {
        LimitProductName = limitProductName;
    }

    public Date getLastDateCreated() {
        return LastDateCreated;
    }

    public void setLastDateCreated(Date lastDateCreated) {
        LastDateCreated = lastDateCreated;
    }

    public Date getLastDateFunded() {
        return LastDateFunded;
    }

    public void setLastDateFunded(Date lastDateFunded) {
        LastDateFunded = lastDateFunded;
    }
}

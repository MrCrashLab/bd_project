package test.Models;

import java.sql.Date;

public class Loan {
    private String Type;
    private String Status;
    private int Annuity;
    private int InitialAmount;
    private int Outstanding;
    private int PaidInterest;
    private int PledgeValue;
    private Date DateFunded;
    private Date DateRealClose;

    public Loan(String type, String status, int annuity, int initialAmount, int outstanding, int paidInterest, int pledgeValue, Date dateFunded, Date dateRealClose) {
        Type = type;
        Status = status;
        Annuity = annuity;
        InitialAmount = initialAmount;
        Outstanding = outstanding;
        PaidInterest = paidInterest;
        PledgeValue = pledgeValue;
        DateFunded = dateFunded;
        DateRealClose = dateRealClose;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAnnuity() {
        return Annuity;
    }

    public void setAnnuity(int annuity) {
        Annuity = annuity;
    }

    public int getInitialAmount() {
        return InitialAmount;
    }

    public void setInitialAmount(int initialAmount) {
        InitialAmount = initialAmount;
    }

    public int getOutstanding() {
        return Outstanding;
    }

    public void setOutstanding(int outstanding) {
        Outstanding = outstanding;
    }

    public int getPaidInterest() {
        return PaidInterest;
    }

    public void setPaidInterest(int paidInterest) {
        PaidInterest = paidInterest;
    }

    public int getPledgeValue() {
        return PledgeValue;
    }

    public void setPledgeValue(int pledgeValue) {
        PledgeValue = pledgeValue;
    }

    public Date getDateFunded() {
        return DateFunded;
    }

    public void setDateFunded(Date dateFunded) {
        DateFunded = dateFunded;
    }

    public Date getDateRealClose() {
        return DateRealClose;
    }

    public void setDateRealClose(Date dateRealClose) {
        DateRealClose = dateRealClose;
    }
}

package test.Models;

import java.sql.Date;

public class Declined {
    private Date LastDate;

    public Declined(Date lastDate) {
        LastDate = lastDate;
    }

    public Declined() {
    }

    public Date getLastDate() {
        return LastDate;
    }

    public void setLastDate(Date lastDate) {
        LastDate = lastDate;
    }
}

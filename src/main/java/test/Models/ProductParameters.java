package test.Models;

import java.sql.Date;

public class ProductParameters {
    private String ProductCategory;
    private String ProductName;
    private String Purpose;
    private Date DisbursementDate;
    private String RepaymentScheme;
    private Date FirstPaymentDate;
    private Date RepaymentDate;
    private String DownPaymentSource;
    private int DelayPeriod;
    private int RefSum;

    public ProductParameters(String productCategory, String productName, String purpose, Date disbursementDate,
                             String repaymentScheme, Date firstPaymentDate, Date repaymentDate, String
                                     downPaymentSource, int delayPeriod, int refSum) {
        ProductCategory = productCategory;
        ProductName = productName;
        Purpose = purpose;
        DisbursementDate = disbursementDate;
        RepaymentScheme = repaymentScheme;
        FirstPaymentDate = firstPaymentDate;
        RepaymentDate = repaymentDate;
        DownPaymentSource = downPaymentSource;
        DelayPeriod = delayPeriod;
        RefSum = refSum;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public Date getDisbursementDate() {
        return DisbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        DisbursementDate = disbursementDate;
    }

    public String getRepaymentScheme() {
        return RepaymentScheme;
    }

    public void setRepaymentScheme(String repaymentScheme) {
        RepaymentScheme = repaymentScheme;
    }

    public Date getFirstPaymentDate() {
        return FirstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        FirstPaymentDate = firstPaymentDate;
    }

    public Date getRepaymentDate() {
        return RepaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        RepaymentDate = repaymentDate;
    }

    public String getDownPaymentSource() {
        return DownPaymentSource;
    }

    public void setDownPaymentSource(String downPaymentSource) {
        DownPaymentSource = downPaymentSource;
    }

    public int getDelayPeriod() {
        return DelayPeriod;
    }

    public void setDelayPeriod(int delayPeriod) {
        DelayPeriod = delayPeriod;
    }

    public int getRefSum() {
        return RefSum;
    }

    public void setRefSum(int refSum) {
        RefSum = refSum;
    }
}

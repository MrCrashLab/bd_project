package test.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class ApplicationForClient {
    private String ApplicationNum;
    private String Stage;
    private String Source;
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
    private String Type;
    private String Status;
    private int Annuity;
    private int InitialAmount;
    private int Outstanding;
    private int PaidInterest;
    private int PledgeValue;
    private Date DateFunded;
    private Date DateRealClose;

    @JsonCreator
    public ApplicationForClient(@JsonProperty("ApplicationNum") String applicationNum, @JsonProperty("Stage")  String stage,
                                @JsonProperty("Source") String source,@JsonProperty("ProductCategory")  String productCategory,
                                @JsonProperty("ProductName") String productName,@JsonProperty("Purpose")  String purpose,
                                @JsonProperty("DisbursementDate") Date disbursementDate,@JsonProperty("RepaymentScheme")  String repaymentScheme,
                                @JsonProperty("FirstPaymentDate") Date firstPaymentDate, @JsonProperty("RepaymentDate") Date repaymentDate,
                                @JsonProperty("DownPaymentSource") String downPaymentSource, @JsonProperty("DelayPeriod") int delayPeriod,
                                @JsonProperty("RefSum") int refSum, @JsonProperty("Type") String type,
                                @JsonProperty("Status") String status, @JsonProperty("Annuity") int annuity,
                                @JsonProperty("InitialAmount") int initialAmount, @JsonProperty("Outstanding") int outstanding,
                                @JsonProperty("PaidInterest") int paidInterest, @JsonProperty("PledgeValue") int pledgeValue,
                                @JsonProperty("DateFunded") Date dateFunded, @JsonProperty("DateRealClose") Date dateRealClose) {
        ApplicationNum = applicationNum;
        Stage = stage;
        Source = source;
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

    public String getApplicationNum() {
        return ApplicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        ApplicationNum = applicationNum;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
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

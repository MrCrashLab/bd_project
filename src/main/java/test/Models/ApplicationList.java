package test.Models;

import java.sql.Date;

public class ApplicationList {
    private String PrimaryKey;
    private String StageID;
    private String ProductCategory;
    private String ProductID;
    private String ProductName;
    private String MarketingSegment;
    private String ParticipationType;
    private int Limit;
    private int Payment;
    private Date DateCreation;
    private Date DateApproved;
    private String Status;
    private Date OpenDate;
    private Date FinishDate;

    public ApplicationList(String primaryKey, String stageID, String productCategory, String productID, String productName, String marketingSegment, String participationType, int limit, int payment, Date dateCreation, Date dateApproved, String status, Date openDate, Date finishDate) {
        PrimaryKey = primaryKey;
        StageID = stageID;
        ProductCategory = productCategory;
        ProductID = productID;
        ProductName = productName;
        MarketingSegment = marketingSegment;
        ParticipationType = participationType;
        Limit = limit;
        Payment = payment;
        DateCreation = dateCreation;
        DateApproved = dateApproved;
        Status = status;
        OpenDate = openDate;
        FinishDate = finishDate;
    }

    public String getPrimaryKey() {
        return PrimaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        PrimaryKey = primaryKey;
    }

    public String getStageID() {
        return StageID;
    }

    public void setStageID(String stageID) {
        StageID = stageID;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getMarketingSegment() {
        return MarketingSegment;
    }

    public void setMarketingSegment(String marketingSegment) {
        MarketingSegment = marketingSegment;
    }

    public String getParticipationType() {
        return ParticipationType;
    }

    public void setParticipationType(String participationType) {
        ParticipationType = participationType;
    }

    public int getLimit() {
        return Limit;
    }

    public void setLimit(int limit) {
        Limit = limit;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        DateApproved = dateApproved;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getOpenDate() {
        return OpenDate;
    }

    public void setOpenDate(Date openDate) {
        OpenDate = openDate;
    }

    public Date getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(Date finishDate) {
        FinishDate = finishDate;
    }
}

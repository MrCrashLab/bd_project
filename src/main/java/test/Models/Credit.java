package test.Models;


import java.sql.Date;

public class Credit {
    private String Index;
    private String Type;
    private String PrimaryKey;
    private String ContractRef;
    private String Currency;
    private Date IssueDate;
    private String Annuity;
    private String Product;
    private String Comment;

    public Credit(String index, String type, String primaryKey, String contractRef, String currency, Date issueDate, String annuity, String product, String comment) {
        Index = index;
        Type = type;
        PrimaryKey = primaryKey;
        ContractRef = contractRef;
        Currency = currency;
        IssueDate = issueDate;
        Annuity = annuity;
        Product = product;
        Comment = comment;
    }

    public String getIndex() {
        return Index;
    }

    public void setIndex(String index) {
        Index = index;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPrimaryKey() {
        return PrimaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        PrimaryKey = primaryKey;
    }

    public String getContractRef() {
        return ContractRef;
    }

    public void setContractRef(String contractRef) {
        ContractRef = contractRef;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public String getAnnuity() {
        return Annuity;
    }

    public void setAnnuity(String annuity) {
        Annuity = annuity;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}

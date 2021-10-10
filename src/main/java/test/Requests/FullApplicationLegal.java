package test.Requests;

import test.Models.*;

public class FullApplicationLegal {
    private Application application;
    private ApplicationAggr applicationAggr;
    private ApplicationList applicationList;
    private LegalEntity legalEntity;
    private Credit credit;
    private Declined declined;
    private Employess employess;
    private Income income;
    private Loan loan;
    private ProductDeclined productDeclined;
    private ProductParameters productParameters;

    public FullApplicationLegal(Application application, ApplicationAggr applicationAggr, ApplicationList applicationList, LegalEntity legalEntity, Credit credit, Declined declined, Employess employess, Income income, Loan loan, ProductDeclined productDeclined, ProductParameters productParameters) {
        this.application = application;
        this.applicationAggr = applicationAggr;
        this.applicationList = applicationList;
        this.legalEntity = legalEntity;
        this.credit = credit;
        this.declined = declined;
        this.employess = employess;
        this.income = income;
        this.loan = loan;
        this.productDeclined = productDeclined;
        this.productParameters = productParameters;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public ApplicationAggr getApplicationAggr() {
        return applicationAggr;
    }

    public void setApplicationAggr(ApplicationAggr applicationAggr) {
        this.applicationAggr = applicationAggr;
    }

    public ApplicationList getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ApplicationList applicationList) {
        this.applicationList = applicationList;
    }

    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Declined getDeclined() {
        return declined;
    }

    public void setDeclined(Declined declined) {
        this.declined = declined;
    }

    public Employess getEmployess() {
        return employess;
    }

    public void setEmployess(Employess employess) {
        this.employess = employess;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public ProductDeclined getProductDeclined() {
        return productDeclined;
    }

    public void setProductDeclined(ProductDeclined productDeclined) {
        this.productDeclined = productDeclined;
    }

    public ProductParameters getProductParameters() {
        return productParameters;
    }

    public void setProductParameters(ProductParameters productParameters) {
        this.productParameters = productParameters;
    }
}

package test.Models;

import java.sql.Date;

public class LegalEntity {
    private String CompanyName;
    private String INN;
    private String OGRN;
    private Date DateFoundation;
    private String CompanyAge;
    private String BusinessDuration;
    private String BusinessFocus;
    private String Sector;
    private String EmployeesNumber;

    public LegalEntity(String companyName, String INN, String OGRN, Date dateFoundation, String companyAge, String businessDuration, String businessFocus, String sector, String employeesNumber) {
        CompanyName = companyName;
        this.INN = INN;
        this.OGRN = OGRN;
        DateFoundation = dateFoundation;
        CompanyAge = companyAge;
        BusinessDuration = businessDuration;
        BusinessFocus = businessFocus;
        Sector = sector;
        EmployeesNumber = employeesNumber;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public Date getDateFoundation() {
        return DateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        DateFoundation = dateFoundation;
    }

    public String getCompanyAge() {
        return CompanyAge;
    }

    public void setCompanyAge(String companyAge) {
        CompanyAge = companyAge;
    }

    public String getBusinessDuration() {
        return BusinessDuration;
    }

    public void setBusinessDuration(String businessDuration) {
        BusinessDuration = businessDuration;
    }

    public String getBusinessFocus() {
        return BusinessFocus;
    }

    public void setBusinessFocus(String businessFocus) {
        BusinessFocus = businessFocus;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getEmployeesNumber() {
        return EmployeesNumber;
    }

    public void setEmployeesNumber(String employeesNumber) {
        EmployeesNumber = employeesNumber;
    }
}

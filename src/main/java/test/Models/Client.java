package test.Models;

import java.sql.Date;

public class Client {
    private Date BirthDate;
    private String BirthPlace;
    private int Age;
    private String Gender;
    private String Citizenship;
    private String Education;
    private String Surname;
    private String Name;
    private String Patronymic;
    private String DocumentType;
    private String Passportnum;
    private Date Issuedate;
    private String IssuePlace;
    private String IssueAuthority;
    private String Departmentcode;
    private String SNILS;

    public Client(Date birthDate, String birthPlace, int age, String gender, String citizenship, String education, String surname, String name, String patronymic, String documentType, String passportnum, Date issuedate, String issuePlace, String issueAuthority, String departmentcode, String SNILS) {
        BirthDate = birthDate;
        BirthPlace = birthPlace;
        Age = age;
        Gender = gender;
        Citizenship = citizenship;
        Education = education;
        Surname = surname;
        Name = name;
        Patronymic = patronymic;
        DocumentType = documentType;
        Passportnum = passportnum;
        Issuedate = issuedate;
        IssuePlace = issuePlace;
        IssueAuthority = issueAuthority;
        Departmentcode = departmentcode;
        this.SNILS = SNILS;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getBirthPlace() {
        return BirthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        BirthPlace = birthPlace;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setCitizenship(String citizenship) {
        Citizenship = citizenship;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    public String getPassportnum() {
        return Passportnum;
    }

    public void setPassportnum(String passportnum) {
        Passportnum = passportnum;
    }

    public Date getIssuedate() {
        return Issuedate;
    }

    public void setIssuedate(Date issuedate) {
        Issuedate = issuedate;
    }

    public String getIssuePlace() {
        return IssuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        IssuePlace = issuePlace;
    }

    public String getIssueAuthority() {
        return IssueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        IssueAuthority = issueAuthority;
    }

    public String getDepartmentcode() {
        return Departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        Departmentcode = departmentcode;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }
}

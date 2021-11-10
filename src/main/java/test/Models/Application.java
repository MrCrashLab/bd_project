package test.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.sql.Date;


public class Application {
    private int id;
    private String ApplicationNum;
    private String Stage;
    private String Source;
    private String Region;
    private String Branch;
    private Date DateCreation;
    private String Priority;

    public Application(int id, String applicationNum, String stage, String source, String region, String branch, Date dateCreation, String priority) {
        this.id = id;
        ApplicationNum = applicationNum;
        Stage = stage;
        Source = source;
        Region = region;
        Branch = branch;
        DateCreation = dateCreation;
        Priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }
}

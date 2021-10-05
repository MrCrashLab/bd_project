package test.Requests;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import test.Models.Application;
import test.Models.ApplicationAggr;
import test.Models.ApplicationList;

@JsonRootName(value = "Example")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT ,use = JsonTypeInfo.Id.NAME)
public class Example {
    private ApplicationAggr applicationAggr;
    private ApplicationList applicationList;
    private Application application;

    public Example(ApplicationAggr applicationAggr, ApplicationList applicationList, Application application) {
        this.applicationAggr = applicationAggr;
        this.applicationList = applicationList;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}

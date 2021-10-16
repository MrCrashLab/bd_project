package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.Models.Application;
import test.Requests.FullApplicationClient;
import test.Requests.FullApplicationLegal;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class API {
    private final BankSystem bankSystem;

    @Autowired
    public API(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @RequestMapping(value = "/application/client/{name}/{surname}", method = RequestMethod.GET)
    public List<FullApplicationClient> getApplicationsClient(@PathVariable("name") String name, @PathVariable("surname") String surname)
    {
        bankSystem.getFullApplicationClient(name, surname);
        return bankSystem.getFullApplicationClients();
    }

    @RequestMapping(value = "/application/legal/{id}", method = RequestMethod.GET)
    public List<FullApplicationLegal> getApplicationsLegal(@PathVariable("id") int id)
    {
        bankSystem.getFullApplicationLegal(id);
        return bankSystem.getFullApplicationLegals();
    }

    @RequestMapping(value = "/application/client/enter/{name}/{pass}")
    public Boolean getLoginClient(@PathVariable("name") String name, @PathVariable("pass") String pass)
    {
        bankSystem.loginClient(name, pass);
        return bankSystem.getLOGIN();
    }
}

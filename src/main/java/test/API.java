package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.Models.Application;
import test.Requests.FullApplicationClient;
import test.Requests.FullApplicationLegal;
import test.Requests.Login;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class API {
    private final BankSystem bankSystem;

    @Autowired
    public API(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @RequestMapping(value = "/application/client/{name}/{pass}", method = RequestMethod.GET)
    public List<FullApplicationClient> getApplicationsClient(@PathVariable("name") String name, @PathVariable("pass") String pass)
    {
        bankSystem.getFullApplicationClient(name, pass);
        return bankSystem.getFullApplicationClients();
    }

    @RequestMapping(value = "/application/legal/{id}", method = RequestMethod.GET)
    public List<FullApplicationLegal> getApplicationsLegal(@PathVariable("id") int id)
    {
        bankSystem.getFullApplicationLegal(id);
        return bankSystem.getFullApplicationLegals();
    }

    @RequestMapping(value = "/application/client/enter/{name}/{pass}", method = RequestMethod.GET)
    public Login getLoginClient(@PathVariable("name") String name, @PathVariable("pass") String pass)
    {
        bankSystem.loginClient(name, pass);
        return bankSystem.getLogin();
    }

    @RequestMapping(value = "/application/client/post", method = RequestMethod.POST)
    public void postClientApplication(@RequestBody() FullApplicationClient fullApplicationClient)
    {
        bankSystem.postApplication(fullApplicationClient);
    }
}

package test;

import test.Models.ApplicationForClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class API {
    private final BankSystem bankSystem;

    @Autowired
    public API(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @RequestMapping(value = "/Application/{id}", method = RequestMethod.GET)
    public ApplicationForClient getApplication(@PathVariable("id") int id)
    {
        bankSystem.getApplication(id);
        return bankSystem.getApplication();
    }
}

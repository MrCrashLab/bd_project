package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.Models.Application;
import test.Requests.Example;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class API {
    private final BankSystem bankSystem;

    @Autowired
    public API(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
    public List<Example> getApplication(@PathVariable("id") int id)
    {
        bankSystem.getFullApplicationClient(id);
        return bankSystem.getExamples();
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public Application getApplication_test()
    {
        bankSystem.app_test();
        return bankSystem.application_test;
    }
}

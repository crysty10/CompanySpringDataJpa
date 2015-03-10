package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class CompanyController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
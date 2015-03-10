package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Florin.Cojocaru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method=GET)
    public String home() {
        return "home";
    }
}

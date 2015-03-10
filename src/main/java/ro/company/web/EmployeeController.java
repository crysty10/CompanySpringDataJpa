package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.EmployeeService;
import javax.inject.Inject;

/**
 * Created by Florin.Cojocaru on 3/9/2015.
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {



    private EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getEmployees(Model model) {

        model.addAttribute("employeesList",employeeService.findAllEmployees());

        return "employees";

    }


}

package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.domain.Employee;
import ro.company.service.EmployeeService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Model model) {

        model.addAttribute("employeeList", employeeService.findAllEmployees());
        return "employees";
    }

    /**
     * Edit details about an employee.
     */
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    public String updateEmployee(
            @PathVariable long employeeId, Model model) {

        Employee employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute(employee);
        return "updateEmployee";
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.POST)
    public String processUpdate(Employee employee) {

        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * Create a new entry into the database.
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String showRegistrationForm() {

        return "addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {

        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * Delete an employee.
     * */
    @RequestMapping(value = "/employees", method = RequestMethod.POST, params = {"deleteEmployee"})
    public String deleteEmployee(Employee employee) {

        employeeService.deleteEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * This method handle requests such as /employees/updateEmployee?employeeId=...
     *
     * @param employeeId - the id of the employee selected
     * @param model - the holder of the employee result
     * @return - the string that represents the view
     */
//    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
//    public String updateEmployee(@RequestParam("employeeId") Long employeeId, Model model) {
//
//        model.addAttribute("employee", employeeService.findEmployeeById(employeeId));
//        return "updateEmployee";
//    }
}
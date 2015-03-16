package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.company.domain.Employee;
import ro.company.service.EmployeeService;

import javax.inject.Inject;
import javax.validation.Valid;

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

    /*
    * *
     * Delete an employee from database.
     *
     * @return redirect to all employees page to check if the action executed.*/
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String removeAd(@RequestParam("employee") long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        employeeService.deleteEmployee(employee);

        return "redirect:/employees";
    }

    /**
     * Edit details about an employee.
     *
     * @param employeeId the id of the employee you want to update
     * @param model      used to save the employee details.
     * @return name of the view.
     */
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    public String updateEmployee(
            @PathVariable long employeeId, Model model) {

        Employee employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute(employee);
        return "updateEmployee";
    }

    /**
     * Update an employee from database.
     *
     * @param employee the entity to populate with data.
     * @return redirect to all employees page to check the result.
     */
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.POST)
    public String processUpdate(Employee employee) {
//        if (errors.hasErrors()) {
//            return "registerForm";
//        }

        employeeService.createEmployee(employee);
        return "redirect:/employees" ;
    }

    /**
     * Get the page for adding a new employee.
     *
     * @return the name of the view.
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String showRegistrationFormforEmployee() {

        return "addEmployee";
    }

    /**
     * Save an employee into the database.
     *
     * @param employee the entity to populate with data.
     * @return redirect to all employees page to check the result.
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {

        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }
}

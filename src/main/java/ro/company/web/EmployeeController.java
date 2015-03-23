package ro.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ro.company.domain.Address;
import ro.company.domain.Car;
import ro.company.domain.Department;
import ro.company.domain.Employee;
import ro.company.service.AddressService;
import ro.company.service.CarService;
import ro.company.service.DepartmentService;
import ro.company.service.EmployeeService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired(required = true)
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    private EmployeeService employeeService;

    private DepartmentService departmentService;

    private CarService carService;

    private AddressService addressService;

    @Inject
    @Qualifier("conversionService")
    public ConversionService conversionService;

    @Inject
    public EmployeeController(EmployeeService employeeService, CarService carService,
                              DepartmentService departmentService, AddressService addressService) {

        this.employeeService = employeeService;
        this.carService = carService;
        this.departmentService = departmentService;
        this.addressService = addressService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
        //binder.setConversionService(conversionService);
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
     * @param employeeId the employee you want to update
     * @param model      used to save the employee details.
     * @return name of the view.
     */
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    public String updateEmployee(
            @PathVariable long employeeId, Model model) {

        Employee employee = employeeService.findEmployeeById(employeeId);
        initModelList(model);
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
    public String processUpdate(@ModelAttribute Employee employee,
                                @PathVariable Long employeeId) {

        employee.setEmployee_id(employeeId);
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * Get the page for adding a new employee.
     *
     * @return the name of the view.
     * params = {"employee} --> @RequestParam(value = "employee")
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String showRegistrationFormEmployee( Model model) {

        initModelList(model);
        model.addAttribute("employee",new Employee());
        return "addEmployee";
    }

    /**
     * Save an employee into the database.
     *
     *
     * @return redirect to all employees page to check the result.
     * params = {"employee} --> @RequestParam(value = "employee")
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult,Map<String,String> map,Model model, Errors errors) {

        if (bindingResult.hasErrors()) {
            //create a set of errors and iterate threw it to view the errors
            initModelList(model);
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addEmployee";
        }

        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    public void initModelList(Model model) {
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute(departmentList);

        List<Car> carList = carService.getAllCars();
        model.addAttribute(carList);

        List<Address> addressList = addressService.findAllAddresses();
        model.addAttribute(addressList);
    }
}
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
import ro.company.domain.Address;
import ro.company.domain.Car;
import ro.company.domain.Department;
import ro.company.service.AddressService;
import ro.company.service.CarService;
import ro.company.service.DepartmentService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class DepartmentController {

    @Autowired(required = true)
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    private DepartmentService departmentService;

    private CarService carService;

    private AddressService addressService;

    @Inject
    @Qualifier("conversionService")
    public ConversionService conversionService;

    @Inject
    public DepartmentController(CarService carService,
                              DepartmentService departmentService, AddressService addressService) {

        this.carService = carService;
        this.departmentService = departmentService;
        this.addressService = addressService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
        //binder.setConversionService(conversionService);
    }
    @RequestMapping(value = "/departments",method = RequestMethod.GET)
    public String departments(Model model){

        model.addAttribute("departmentList", departmentService.getAllDepartments());
        return "departments";
    }

    /**
     * Get the page for adding a new department.
     *
     * @return the name of the view.
     * params = {"department} --> @RequestParam(value = "department")
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
    public String showRegistrationFormDepartment(Model model) {


        model.addAttribute("department",new Department());
        return "addDepartment";
    }

    /**
     * Save an department into the database.
     *
     *
     * @return redirect to all departments page to check the result.
     * params = {"department} --> @RequestParam(value = "department")
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public String saveDepartment(@Valid Department department, BindingResult bindingResult, Errors errors) {

        if (bindingResult.hasErrors()) {
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addDepartment";
        }

        departmentService.createDepartment(department);
        return "redirect:/departments";
    }


    /**
     * Edit details about an department.
     *
     * @param deptId the department you want to update
     * @param model      used to save the department details.
     * @return name of the view.
     */
    @RequestMapping(value = "/departments/{deptId}", method = RequestMethod.GET)
    public String updateDepartment(
        @PathVariable long deptId, Model model) {

        Department department = departmentService.getDepartmentById(deptId);
        initModelList(model);
        model.addAttribute(department);
        return "updateDepartment";
    }

    /**
     * Update an employee from database.
     *
     * @param department the entity to populate with data.
     * @return redirect to all employees page to check the result.
     */
    @RequestMapping(value = "/departments/{deptId}", method = RequestMethod.POST)
    public String processUpdate(@ModelAttribute Department department,
                                @PathVariable Long deptId) {

        department.setDepartment_id(deptId);
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }



    /*
   * *
    * Delete an department from database.
    *
    * @return redirect to all departments page to check if the action executed.*/
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public String removeAd(@RequestParam("department") long deptId) {

        Department department = departmentService.getDepartmentById(deptId);
        departmentService.deleteDepartment(department);
        return "redirect:/departments";
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

package ro.company.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ro.company.domain.Department;
import ro.company.service.DepartmentService;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class DepartmentController {

    @Autowired(required = true)
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    private DepartmentService departmentService;

    @Inject
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(this.localValidatorFactoryBean);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String departments(Model model) {

        model.addAttribute("departmentList", departmentService.getAllDepartments());
        return "departments";
    }

    /**
     * Edit details about an employee.
     *
     * @param departmentId the employee you want to update
     * @param model        used to save the employee details.
     * @return name of the view.
     */
    @RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.GET)
    public String updateDepartment(@PathVariable long departmentId, Model model) {

        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute(department);
        return "updateDepartment";
    }

    /**
     * Update an employee from database.
     *
     * @param department the entity to populate with data.
     * @return redirect to all employees page to check the result.
     */
    @RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.POST)
    public String processUpdate(@Valid @ModelAttribute Department department, BindingResult bindingResult,
                                Errors errors, @PathVariable Long departmentId) {

        if (bindingResult.hasErrors()) {
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "updateDepartment";
        }

        department.setDepartment_id(departmentId);
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }

    /**
     * Get the page for adding a new department.
     *
     * @return the name of the view.
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        model.addAttribute("department", new Department());
        return "addDepartment";
    }

    /**
     * Save an department into the database.
     *
     * @param department the entity to populate with data.
     * @return redirect to all departments page to check the result.
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public String saveDepartment(@Valid @ModelAttribute("department") Department department,
                                 BindingResult bindingResult, Errors errors) {

        if (bindingResult.hasErrors()) {
            localValidatorFactoryBean.validate(bindingResult, errors);
            return "addDepartment";
        }

        departmentService.createDepartment(department);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public String removeAd(@RequestParam("department") long deptId) {

        Department dept = departmentService.getDepartmentById(deptId);
        departmentService.deleteDepartment(dept);
        return "redirect:/departments";
    }
}

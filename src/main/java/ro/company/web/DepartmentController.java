package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.company.domain.Department;
import ro.company.service.DepartmentService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/")
public class DepartmentController {

    private DepartmentService departmentService;
//    private Validator validator;

    @Inject
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = (Validator) validatorFactory.getValidator();
    }

    @RequestMapping(value = "/departments",method = RequestMethod.GET)
    public String departments(Model model){

        model.addAttribute("departmentList", departmentService.getAllDepartments());
        return "departments";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Department.class, new DepartmentEditor());
//    }

//    @ModelAttribute("allDepartments")
//    public List<Department> populateDepartments() {
//        ArrayList<Department> departments = new ArrayList<>();
////        departments.add(departmentService.getDepartmentById(1L));
////        departments.add(departmentService.getDepartmentById(2L));
////        departments.add(departmentService.getDepartmentById(3L));
//        return departments;}




    /**
     * Edit details about an employee.
     *
     * @param departmentId the employee you want to update
     * @param model      used to save the employee details.
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
    public String processUpdate(@ModelAttribute Department department, @PathVariable Long deptId) {

        department.setDepartment_id(deptId);
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }

    /**
     * Get the page for adding a new department.
     *
     * @return the name of the view.
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
    public String showRegistrationForm() {

        return "addDepartment";
    }

    /**
     * Save an department into the database.
     *
     * @param department the entity to populate with data.
     * @return redirect to all departments page to check the result.
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public String saveDepartment(Department department) {

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

package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.DepartmentService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/9/2015.
 */
@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Inject
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String department(Model model){

        model.addAttribute("departmentList", departmentService.getAllDepartments());
        return "departments";
    }
}
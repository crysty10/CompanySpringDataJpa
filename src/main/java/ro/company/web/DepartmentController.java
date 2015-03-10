package ro.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.company.service.DepartmentService;

import javax.inject.Inject;
/**
 * Created by Florin.Cojocaru on 3/9/2015.
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
    public String getDepartments(Model model) {

        model.addAttribute("departmentsList",departmentService.getAllDepartments());

        return "departments";

    }
}


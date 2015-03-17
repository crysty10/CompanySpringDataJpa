package ro.company.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ro.company.domain.Employee;

public class EmployeeValidator implements Validator {

    /**
     * This Validator validates *just* Person instances
     */
    public boolean supports(Class clazz) {
        return Employee.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {

        Employee p = (Employee) obj;
        if (p.getFirstname().length() < 2) {
            e.rejectValue("firstname", "too short!");
        } else if (p.getFirstname().length() > 20) {
            e.rejectValue("firstname", "too long!");
        }
        if (p.getFirstname().length() < 2) {
            e.rejectValue("lastname", "too short!");
        } else if (p.getFirstname().length() > 20) {
            e.rejectValue("lastname", "too long!");
        }
        if (p.getFirstname().length() < 0) {
            e.rejectValue("salary", "too small!");
        } else if (p.getFirstname().length() > 100000) {
            e.rejectValue("salary", "too nig!");
        }
    }
}

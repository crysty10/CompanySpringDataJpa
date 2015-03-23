package ro.company.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;
import ro.company.domain.Employee;
import ro.company.service.EmployeeService;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 3/23/2015.
 */
public class StringEmployeeConverter implements Converter<String, Employee> {

    @Inject
    private EmployeeService employeeService;

    @Transactional
    @Override
    public Employee convert(String idStr) {

        if(idStr == "") {
            return null;
        }
        return employeeService.findEmployeeById(Long.valueOf(idStr));
    }
}

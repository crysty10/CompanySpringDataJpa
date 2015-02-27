package ro.company.service;

import ro.company.domain.Employee;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);
}

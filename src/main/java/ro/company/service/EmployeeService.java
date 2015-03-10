package ro.company.service;

import ro.company.domain.Employee;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
public interface EmployeeService {

    //CREATE OR UPDATE
    Employee createEmployee(Employee employee);

    //READ
    Employee findEmployeeById(Long id);
    Employee findEmployeeByFirstnameAndLastname(String firstname, String lastname);
    List<Employee> findAllEmployees();

    //EXIST
    boolean checkEmployeeExist(Long id);

    //DELETE
    void deleteEmployee(Employee e);
}
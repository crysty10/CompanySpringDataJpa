package ro.company.service;

import org.springframework.stereotype.Service;
import ro.company.domain.Employee;
import ro.company.repository.EmployeeRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
}

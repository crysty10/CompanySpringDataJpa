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
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Employee employee) {

        employeeRepository.delete(employee);

    }

}

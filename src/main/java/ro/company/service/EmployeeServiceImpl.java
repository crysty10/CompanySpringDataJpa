package ro.company.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.domain.Employee;
import ro.company.repository.EmployeeRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/25/2015.
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Employee findEmployeeByFirstnameAndLastname(String firstname, String lastname) {

        return employeeRepository.findEmployeeByFirstnameAndLastname(firstname, lastname);
    }

    @Override
    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean checkEmployeeExist(Long id) {

        return employeeRepository.exists(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteEmployee(Employee employee) {

        employeeRepository.delete(employee);
    }
}

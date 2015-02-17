package repository;

import domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByFirstname(String firstname);
    List<Employee> findAllEmployeesByFirstname(String firsname);
}
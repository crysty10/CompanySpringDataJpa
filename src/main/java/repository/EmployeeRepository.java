package repository;

import domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByFirstname(String firstname);

    List<Employee> findAllEmployeesBySalary(double salary);

    @Query("select emp from Employee emp where emp.lastname = :lastname")
    Employee findEmployeeByLastname(@Param("lastname")String lastname);
}
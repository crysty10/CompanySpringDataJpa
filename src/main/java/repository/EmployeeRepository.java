package repository;

import domain.Address;
import domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Repository
public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {

    /*
    * Get one employee by firstname!
    * */
    Employee findEmployeeByFirstname(String firstname);

    /*
    * Get all employees with the same salary!
    * */
    List<Employee> findAllEmployeesBySalary(double salary);

    /*
    * Get one employee by lastname, using a query!
    * */
    @Query("select emp from Employee emp where emp.lastname = :lastname")
    Employee findEmployeeByLastname(@Param("lastname")String lastname);

    /*
    * Get all the addresses of an employee!
    * */
    @Query("select add from Address add, Employee emp, EmployeeAddress empAdd " +
            "where emp.employee_id = empAdd.emp_id and add.address_id = empAdd.add_id and emp.firstname = :firstname")
    List<Address> findEmployeeAddressByFirstname(@Param("firstname")String firstname);

}
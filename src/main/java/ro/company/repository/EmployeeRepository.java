package ro.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.company.domain.Employee;

import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */

public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {

    /*
    * Get one employee by first name!
    * */
    Employee findEmployeeByFirstname(String firstname);

    Employee findEmployeeById(Long id);

    /*
    * Get all employees with the same salary!
    * */
    List<Employee> findAllEmployeesBySalary(double salary);

    Employee findEmployeeByFirstnameAndLastname(String firsname, String lastname);

    /*
    * Get one employee by last name, using a query!
    * */
    @Query("select emp from Employee As emp where emp.lastname = :lastname")
    Employee findEmployeeByLastname(@Param("lastname") String lastname);

    /*
    * Get all the addresses of an employee, employee searched by first name!
    * */
//    @Query("select add from Address add, Employee emp, EmployeeAddress empAdd " +
//            "where emp.employee_id = empAdd.emp_id and add.address_id = empAdd.add_id and emp.firstname = :firstname")
//    List<Address> findEmployeeAddressByFirstname(@Param("firstname") String firstname);

    /*
    * Get all the cars of an employee, employee searched by salary!
    * */
//    @Query("SELECT cars FROM Car cars, Employee emp, Employee_Car empCar " +
//           "WHERE emp.employee_id = empCar.employee_id AND cars.car_id = empCar.car_id AND emp.salary = :salary")
//    List<Car> findEmployeeCarBySalary(@Param("salary") Double salary);
}

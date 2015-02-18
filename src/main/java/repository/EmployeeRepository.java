package repository;

import domain.Car;
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
public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {

    Employee findEmployeeByFirstname(String firstname);

    List<Employee> findAllEmployeesBySalary(double salary);

    @Query("select emp from Employee emp where emp.lastname = :lastname")
    Employee findEmployeeByLastname(@Param("lastname")String lastname);

    /*TODO: */
    /*@Query("select add from Address add, Employee emp, Employee_Address empAdd " +
            "where emp.emp_id = empAdd.emp_id and add.add_id = empAdd.add_id and emp.firstname = :firstname")
    List<Address> findEmployeeAddressByFirstname(@Param("firstname")String firstname);*/

    /*@Query("update Employee emp set emp.department = :department where emp.firstname = :firstname")
    Employee setDepartmentFor(String firstname, Long department);*/

    @Query("SELECT cars FROM Car cars, Employee emp, Employee_Car empCar " +
           "WHERE emp.employee_id = empCar.employee_id AND cars.car_id = empCar.car_id AND emp.salary = :salary")
    List<Car> findEmployeeCarBySalary(@Param("salary") Double salary);
}

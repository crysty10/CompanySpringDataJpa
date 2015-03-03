package ro.company;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.config.CompanyConfig;
import ro.company.domain.Address;
import ro.company.domain.Car;
import ro.company.domain.Department;
import ro.company.domain.Employee;
import ro.company.service.AddressService;
import ro.company.service.CarService;
import ro.company.service.DepartmentService;
import ro.company.service.EmployeeService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class, loader = AnnotationConfigContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CompanyTest {

    @Inject
    private EmployeeService employeeService;

    @Inject
    private CarService carService;

    @Inject
    private DepartmentService departmentService;

    @Inject
    private AddressService addressService;

    @Test
    @Ignore
    public void testACreateWithAuditableAspectWTF(){

        Employee employee = new Employee("John", "B.", (double)5050);
        employeeService.createEmployee(employee);

        Car car = new Car("BMW", "320");
        carService.createCar(car);

        Department department = new Department("IT Solutions");
        departmentService.createDepartment(department);

        Address address = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        addressService.createAddress(address);
    }

    @Test
    @Ignore
    public void testBUpdateWithAuditableAspectWTF(){

        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
        employee.setSalary((double)4000);
        employeeService.createEmployee(employee);

        Car car = carService.getCarByCarName("BMW");
        car.setCarModel("520");
        carService.createCar(car);

        Department department = departmentService.getDepartmentByDeptname("IT Solutions");
        department.setDeptname("IT");
        departmentService.createDepartment(department);

        Address address = addressService.findAddressByLocalityAndStreet("Turnu-Magurele", "Florilor");
        address.setApartment(22);
        addressService.createAddress(address);
    }

    @Test
    @Ignore
    public void testCDeleteWithAuditableAspectWTF(){

        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
        employeeService.deleteEmployee(employee);

        Car car = carService.getCarByCarName("BMW");
        carService.deleteCar(car);

        Department department = departmentService.getDepartmentByDeptname("IT");
        departmentService.deleteDepartment(department);

        Address address = addressService.findAddressByLocalityAndStreet("Turnu-Magurele", "Florilor");
        addressService.deleteAddress(address);
    }

    @Test
    @Ignore
    public void testMultipleFunctionality() {

        Car car = new Car("Audi", "A6");
        carService.createCar(car);

        Department department = new Department("CTI");
        departmentService.createDepartment(department);

        Address address = new Address("Blvd. Unirii", 22,"E1", 10, 45, "Bucuresti", "Romania");
        addressService.createAddress(address);

        Employee employee = new Employee("John", "Travolta", (double)100000);
        employee.setDepartment(department);
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(address);
        employee.setAddressList(addressList);
        List<Car> carList = new ArrayList<Car>();
        carList.add(car);
        employee.setCars(carList);
        employeeService.createEmployee(employee);
    }

    @Test
    public void testUpdateVsSaveCreatedTimeModifiedTime() {

        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "Travolta");
        employee.setSalary((double)15080);
        employeeService.createEmployee(employee);
    }
}
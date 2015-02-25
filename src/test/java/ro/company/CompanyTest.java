package ro.company;

import ro.company.config.CompanyConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ro.company.domain.Auditable;
import ro.company.domain.Employee;
import ro.company.repository.AddressRepository;
import ro.company.repository.CarRepository;
import ro.company.repository.DepartmentRepository;
import ro.company.service.EmployeeService;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class, loader = AnnotationConfigContextLoader.class)
public class CompanyTest {

    @Inject
    private EmployeeService employeeService;

//    @Inject
//    private AddressRepository addressRepo;
//
//    @Inject
//    private DepartmentRepository deptRepo;
//
//    @Inject
//    private CarRepository carRepo;



    @Before
    public void setUp() throws Exception {

        /*Department dept = new Department("IT Solutions");
        deptRepo.save(dept);
        Employee emp = new Employee("Bogdan", "I.", (double)1500);
        emp.setDepartment(dept);
        employeeService.save(emp);*/
        /*Employee emp2 = new Employee("Alex", "C.", (double)1500);
        List<Address> addresses = addressRepo.findAllByCountry("Romania");
        emp2.setAddressList(addresses);
        employeeService.save(emp2);*/

        /*Employee employee = employeeService.findEmployeeByFirstname("Alex");
        Department department = deptRepo.findByDeptname("IT Solutions");
        employee.setDepartment(department);
        employeeService.save(employee);*/

        /*Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        addressRepo.save(adress);
        Department dept = new Department("IT Solutions");
        deptRepo.save(dept);
        Department dept1 = new Department("Human Resource");
        deptRepo.save(dept1);
        Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        employeeService.save(emp);
        addressRepo.save(adress);
        Address address = new Address("Florilor",1,"D12",4,100,"Timisoara","Romania");
        addressRepo.save(address);*/
        /*Car car = new Car("BMW", "X5");
        Car car1 = new Car("Audi", "R8");
        Car car2 = new Car("BMW", "C302");
        carRepo.save(car);
        carRepo.save(car1);
        carRepo.save(car2);*/

        /*Employee emp = new Employee("Cristian", "D.", (double)1500);
        Department department = deptRepo.findByDeptname("IT Solutions");
        emp.setDepartment(department);
        List<Car> carList = carRepo.findAllCarByCarName("BMW");
        List<Address> addressList = addressRepo.findAllByCountry("Romania");
        emp.setCars(carList);
        emp.setAddressList(addressList);
        employeeService.save(emp);*/

        /*Employee emp = employeeService.findEmployeeByFirstname("Cristian");
        emp.setDepartment(department);
        employeeService.save(emp);
        employeeService.setDepartmentFor(emp.getFirstname(), department.getDepartment_id());*/

        /*Address address1 = new Address("Florilor",1,"D12",4,100,"Timisoara","Romania");
        addressRepo.save(address1);
        Address address2 = new Address("Mihai Bravu",12,"C12",4,100,"Bucuresti","Romania");
        addressRepo.save(address2);
        Address address3 = new Address("Foametei",13,"X12",4,100,"Ploiesti","Romania");
        addressRepo.save(address3);*/
    }

//    @Test
//    public void testFindEmployeeBySomething() {
//
//        ro.company.domain.Employee employee = employeeService.findEmployeeByFirstname("Cristian");
//        System.out.println("The employee: " + employee.getFirstname() + " " + employee.getLastname());
//        Assert.assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
//    }
//
//    @Test
//    public void testFindAddressBySomething() {
//
//        ro.company.domain.Address adress = addressRepo.findBylocality("Turnu-Magurele");
//        Assert.assertEquals("Wrong locality", adress.getLocality(), "Turnu-Magurele");
//    }
//
//    @Test
//    public void testFindAllAddressesByStreet() {
//        List<ro.company.domain.Address> address = addressRepo.findByStreet("Florilor");
//        for (ro.company.domain.Address a : address) {
//            Assert.assertEquals("Wrong street", a.getStreet(), "Florilor");
//        }
//    }
//
//    public void testFindEmployeeByLastnameWithQuery() {
//        ro.company.domain.Employee employee = employeeService.findEmployeeByLastname("D.");
//        Assert.assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
//    }
//
//    @Test
//    public void testFindAllEmployeesBySalary() {
//        List<ro.company.domain.Employee> employeeList = employeeService.findAllEmployeesBySalary(1500);
//        for (ro.company.domain.Employee employee : employeeList) {
//            System.out.println("Employee name: " + employee.getFirstname());
//        }
//    }
//
//    @Test
//    public void testFindAllByCountry() {
//        List<ro.company.domain.Address> address = addressRepo.findAllByCountry("Romania");
//        for (ro.company.domain.Address a : address) {
//            Assert.assertEquals("Wrong country", a.getCountry(), "Romania");
//        }
//    }
//
//    @Test
//    public void testFindAddressByApartment() {
//
//        ro.company.domain.Address adress = addressRepo.findByApartment(45);
//        assertEquals("Wrong apartment", (long)adress.getApartment(), 45);
//    }
//
//    @Test
//    public void testFindDepartmentByDeptname() {
//
//        ro.company.domain.Department dept = deptRepo.findByDeptname("IT Solutions");
//        Assert.assertEquals("Wrong department", dept.getDeptname(), "IT Solutions");
//    }
//
//    @Test
//    public void testFindByCarName() {
//
//        ro.company.domain.Car car = carRepo.findByCarName("BMW");
//        Assert.assertEquals("Wrong CarName", car.getCarName(), "BMW");
//    }
//
//    @Test
//    public void testFindAllCarsByCarName() {
//        List<ro.company.domain.Car> carList = carRepo.findAllCarByCarName("BMW");
//        for(ro.company.domain.Car car : carList) {
//            Assert.assertEquals("Wrong car", car.getCarName(), "BMW");
//        }
//    }
//
//    @Test
//    public void testFindEmployeeWithAllAddress() {
//
//        ro.company.domain.Employee employee = employeeService.findEmployeeByFirstname("Cristian");
//        assertTrue("Problems with getAddress()!", employee.getAddressList().size() > 0);
//        assertTrue("Problems with getCars()!", employee.getCars().size() > 0);
//    }
//
////    @Test
////    public void testWithQueryLazy() {
////
////        Employee employee = employeeService.findEmployeeByFirstname("Cristian");
////        List<Address> addresses = employeeService.findEmployeeAddressByFirstname(employee.getFirstname());
////        for(Address address : addresses) {
////            System.out.println(address.getCountry());
////        }
////        assertTrue("Nop!!", addresses.size() > 0);
////    }
////
////    @Test
////    public void testFindEmployeeCarBySalary() {
////
////        List<Employee> employee = employeeService.findAllEmployeesBySalary(1500);
////        for (Employee e : employee) {
////            List<Car> cars = employeeService.findEmployeeCarBySalary(e.getSalary());
////            for (Car car : cars) {
////                //assertEquals("Wrong car", car.getCarName(), "BMW");
////                System.out.println(car.getCarName() + " " + car.getCarModel());
////            }
////        }
////    }
//
//    @Test
//    public void testModifiedTime() {
//
//        //Employee employee = new Employee("Bogdan", "I.", (double)1500);
//        ro.company.domain.Employee employee = new ro.company.domain.Employee("Bogdan", "I.", (double)1500);
//        //Department department = deptRepo.findByDeptname("IT Solutions");
//        //employee.setDepartment(department);
//        employeeService.save(employee);
//        //System.out.println(employee.getCreateDateTime());
//        //System.out.println(employee.getModifiedDateTime());
//    }

    @Test
    public void testSaveUpdateWithAuditableAspectWTF(){

        //Employee employee = employeeService.findEmployeeByFirstname("Daniel");
        //Department department = deptRepo.findByDeptname("IT Solutions");
        //employee.setSalary((double)1350);
        Employee employee = new Employee("Jan", "P.", (double)1500);
        //Auditable auditable = (Auditable) employee;
        employeeService.addEmployee(employee);
        //Car car = new Car("VW", "Golf V");
        //Auditable auditable = (Auditable) car;
        //carRepo.save(car);
    }
}
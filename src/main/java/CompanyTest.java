import config.CompanyConfig;
import domain.Address;
import domain.Car;
import domain.Department;
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.AddressRepository;
import repository.CarRepository;
import repository.DepartmentRepository;
import repository.EmployeeRepository;

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
    private EmployeeRepository empRepo;

    @Inject
    private AddressRepository addressRepo;

    @Inject
    private DepartmentRepository deptRepo;

    @Inject
    private CarRepository carRepo;

    @Before
    public void setUp() throws Exception {



        /*Department dept = new Department("IT Solutions");
        deptRepo.save(dept);
        Employee emp = new Employee("Bogdan", "I.", (double)1500);
        emp.setDepartment(dept);
        empRepo.save(emp);*/
        /*Employee emp2 = new Employee("Alex", "C.", (double)1500);
        List<Address> addresses = addressRepo.findAllByCountry("Romania");
        emp2.setAddressList(addresses);
        empRepo.save(emp2);*/

        /*Employee employee = empRepo.findEmployeeByFirstname("Alex");
        Department department = deptRepo.findByDeptname("IT Solutions");
        employee.setDepartment(department);
        empRepo.save(employee);*/

        /*Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        addressRepo.save(adress);
        Department dept = new Department("IT Solutions");
        deptRepo.save(dept);
        Department dept1 = new Department("Human Resource");
        deptRepo.save(dept1);
        Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        empRepo.save(emp);
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
        empRepo.save(emp);*/

        /*Employee emp = empRepo.findEmployeeByFirstname("Cristian");
        emp.setDepartment(department);
        empRepo.save(emp);
        empRepo.setDepartmentFor(emp.getFirstname(), department.getDepartment_id());*/

        /*Address address1 = new Address("Florilor",1,"D12",4,100,"Timisoara","Romania");
        addressRepo.save(address1);
        Address address2 = new Address("Mihai Bravu",12,"C12",4,100,"Bucuresti","Romania");
        addressRepo.save(address2);
        Address address3 = new Address("Foametei",13,"X12",4,100,"Ploiesti","Romania");
        addressRepo.save(address3);*/
    }

    @Test
    public void testFindEmployeeBySomething() {

        Employee employee = empRepo.findEmployeeByFirstname("Cristian");
        System.out.println("The employee: " + employee.getFirstname() + " " + employee.getLastname());
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
    }

    @Test
    public void testFindAddressBySomething() {

        Address adress = addressRepo.findBylocality("Turnu-Magurele");
        assertEquals("Wrong locality", adress.getLocality(), "Turnu-Magurele");
    }

    @Test
    public void testFindAllAddressesByStreet() {
        List<Address> address = addressRepo.findByStreet("Florilor");
        for (Address a : address) {
            assertEquals("Wrong street", a.getStreet(), "Florilor");
        }
    }

    public void testFindEmployeeByLastnameWithQuery() {
        Employee employee = empRepo.findEmployeeByLastname("D.");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
    }

    @Test
    public void testFindAllEmployeesBySalary() {
        List<Employee> employeeList = empRepo.findAllEmployeesBySalary(1500);
        for (Employee employee : employeeList) {
            System.out.println("Employee name: " + employee.getFirstname());
        }
    }

    @Test
    public void testFindAllByCountry() {
        List<Address> address = addressRepo.findAllByCountry("Romania");
        for (Address a : address) {
            assertEquals("Wrong country", a.getCountry(), "Romania");
        }
    }

    @Test
    public void testFindAddressByApartment() {

        Address adress = addressRepo.findByApartment(45);
        assertEquals("Wrong apartment", (long)adress.getApartment(), 45);
    }

    @Test
    public void testFindDepartmentByDeptname() {

        Department dept = deptRepo.findByDeptname("IT Solutions");
        assertEquals("Wrong department", dept.getDeptname(), "IT Solutions");
    }

    @Test
    public void testFindByCarName() {

        Car car = carRepo.findByCarName("BMW");
        assertEquals("Wrong CarName", car.getCarName(), "BMW");
    }

    @Test
    public void testFindAllCarsByCarName() {
        List<Car> carList = carRepo.findAllCarByCarName("BMW");
        for(Car car : carList) {
            assertEquals("Wrong car", car.getCarName(), "BMW");
        }
    }

    @Test
    public void testFindEmployeeWithAllAddress() {

        Employee employee = empRepo.findEmployeeByFirstname("Cristian");
        assertTrue("Problems with getAddress()!", employee.getAddressList().size() > 0);
        assertTrue("Problems with getCars()!", employee.getCars().size() > 0);
    }

//    @Test
//    public void testWithQueryLazy() {
//
//        Employee employee = empRepo.findEmployeeByFirstname("Cristian");
//        List<Address> addresses = empRepo.findEmployeeAddressByFirstname(employee.getFirstname());
//        for(Address address : addresses) {
//            System.out.println(address.getCountry());
//        }
//        assertTrue("Nop!!", addresses.size() > 0);
//    }
//
//    @Test
//    public void testFindEmployeeCarBySalary() {
//
//        List<Employee> employee = empRepo.findAllEmployeesBySalary(1500);
//        for (Employee e : employee) {
//            List<Car> cars = empRepo.findEmployeeCarBySalary(e.getSalary());
//            for (Car car : cars) {
//                //assertEquals("Wrong car", car.getCarName(), "BMW");
//                System.out.println(car.getCarName() + " " + car.getCarModel());
//            }
//        }
//    }

    @Test
    public void testModifiedTime() {

        //Employee employee = new Employee("Bogdan", "I.", (double)1500);
        Employee employee = new Employee("Bogdan", "I.", (double)1500);
        //Department department = deptRepo.findByDeptname("IT Solutions");
        //employee.setDepartment(department);
        empRepo.save(employee);
        //System.out.println(employee.getCreateDateTime());
        //System.out.println(employee.getModifiedDateTime());
    }

    @Test
    public void testSaveUpdateWithAuditableAspectWTF(){

        /*Employee employee = empRepo.findEmployeeByFirstname("Daniel");
        //Department department = deptRepo.findByDeptname("IT Solutions");
        employee.setSalary((double)1350);
        //Employee employee = new Employee("Daniel", "P.", (double)1500);
        empRepo.save(employee);*/
        Car car = new Car("VW", "Golf V");
        carRepo.save(car);
    }

}

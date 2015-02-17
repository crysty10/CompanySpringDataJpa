import config.CompanyConfig;
import domain.Address;
import domain.Department;
import domain.Car;
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.AddressRepository;
import repository.DepartmentRepository;
import repository.CarRepository;
import repository.EmployeeRepository;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;


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

//        Employee emp = new Employee("Bogdan", "I.", 1500);
//        empRepo.save(emp);
//        Employee emp2 = new Employee("Alex", "C.", 1500);
//        empRepo.save(emp2);
//        Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
//        addressRepo.save(adress);
        Department dept = new Department("IT Solutions");
        deptRepo.save(dept);
        Department dept1 = new Department("Human Resource");
        deptRepo.save(dept1);
        //Employee emp = new Employee("Cristian", "D.", 1500);
       // Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        //empRepo.save(emp);
       // addressRepo.save(adress);
       // Address address = new Address("Florilor",1,"D12",4,100,"Timisoara","Romania");
       // addressRepo.save(address);
//        Car car = new Car("BMW", "X5");
//        Car car1 = new Car("Audi", "R8");
//        carRepo.save(car);
//        carRepo.save(car1);
    }

    @Test
    public void testFindEmployeeBySomething() {

        Employee employee = empRepo.findEmployeeByFirstname("Cristian");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
        //empRepo.delete(employee);
    }

    @Test
    public void testFindAddressBySomething() {

        Address adress = addressRepo.findBylocality("Turnu-Magurele");
        assertEquals("Wrong locality", adress.getLocality(), "Turnu-Magurele");
        //addressRepo.delete(adress);
    }

    @Test
    public void testFindAllAddressesByStreet() {
        List<Address> address = addressRepo.findByStreet("Florilor");
        for(Address a : address) {
            assertEquals("Wrong street", a.getStreet(), "Florilor");
        }
    }

    public void testFindEmployeeByLastnameWithQuery () {
        Employee employee = empRepo.findEmployeeByLastname("D.");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
    }

    @Test
    public void testFindAllEmployeesBySalary() {
        List<Employee> employeeList = empRepo.findAllEmployeesBySalary(1500);
        for(Employee employee : employeeList) {
            System.out.println("Employee name: " + employee.getFirstname());
        }
    }

    @Test
    public void testFindAllByCountry(){
        List<Address> address = addressRepo.findAllByCountry("Romania");
        for(Address a : address) {
            assertEquals("Wrong country", a.getCountry(), "Romania");
        }
    }



    @Test
    public void testFindAddressByApartment() {

        Address adress = addressRepo.findByApartment(45);
        assertEquals("Wrong apartment", adress.getApartment(), Integer.valueOf(45));
        //addressRepo.delete(adress);
    }

    @Test
    public void testFindDepartmentByDeptname() {

        Department dept = deptRepo.findByDeptname("IT Solutions");
        assertEquals("Wrong department", dept.getDeptname(), "IT Solutions");
        //deptRepo.delete(dept);
    }

    @Test
    public void testFindByCarName() {

        Car car = carRepo.findByCarName("BMW");
        assertEquals("Wrong CarName", car.getCarName(), "BMW");
    }
}

import config.CompanyConfig;

import domain.Address;
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.AddressRepository;
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

    @Before
    public void setUp() throws Exception {

        /*Employee emp = new Employee("Bogdan", "I.", 1500);
        empRepo.save(emp);
        Employee emp2 = new Employee("Alex", "C.", 1500);
        empRepo.save(emp2);
        Address adress = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        addressRepo.save(adress);*/
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
    public void testFindAllEmployeesBySalary() {
        List<Employee> employeeList = empRepo.findAllEmployeesBySalary(1500);
        for(Employee employee : employeeList) {
            System.out.println("Employee name: " + employee.getFirstname());
        }
    }

    @Test
    public void testFindEmployeeByLastnameWithQuery() {
        Employee employee = empRepo.findEmployeeByLastname("D.");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
    }
}

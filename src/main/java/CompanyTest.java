import config.CompanyConfig;
import domain.Adress;
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.AdressRepository;
import repository.EmployeeRepository;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class, loader = AnnotationConfigContextLoader.class)
public class CompanyTest {

    @Inject
    private EmployeeRepository empRepo;
    private AdressRepository adressRepo;

    @Before
    public void setUp() throws Exception {

        Employee emp = new Employee("Cristian", "D.", 1500);
        Adress adress = new Adress("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        empRepo.save(emp);
        adressRepo.save(adress);

    }

    @Test
    public void testConnectionWithDatabase() {
        Employee employee = empRepo.findByFirstname("Cristian");
        Adress adress = adressRepo.findBylocality("Turnu-Magurele");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
        assertEquals("Wrong locality", adress.getLocality(), "Turnu-Magurele");
    }
}

import config.CompanyConfig;
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.EmployeeRepository;
import static org.junit.Assert.*;

import javax.inject.Inject;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class, loader = AnnotationConfigContextLoader.class)
public class CompanyTest {

    @Inject
    private EmployeeRepository empRepo;

    @Before
    public void setUp() throws Exception {

        Employee emp = new Employee("Cristian", "D.", 1500);
        empRepo.save(emp);
    }

    @Test
    public void testConnectionWithDatabase() {
        Employee employee = empRepo.findByFirstname("Cristian");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
    }
}

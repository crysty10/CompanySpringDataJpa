import config.CompanyConfig;
<<<<<<< HEAD
import domain.Adress;
=======
>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633
import domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
<<<<<<< HEAD
import repository.AdressRepository;
import repository.EmployeeRepository;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

=======
import repository.EmployeeRepository;
import static org.junit.Assert.*;

import javax.inject.Inject;

>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633
/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CompanyConfig.class, loader = AnnotationConfigContextLoader.class)
public class CompanyTest {

    @Inject
    private EmployeeRepository empRepo;
<<<<<<< HEAD
    private AdressRepository adressRepo;
=======
>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633

    @Before
    public void setUp() throws Exception {

        Employee emp = new Employee("Cristian", "D.", 1500);
<<<<<<< HEAD
        Adress adress = new Adress("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
        empRepo.save(emp);
        adressRepo.save(adress);

=======
        empRepo.save(emp);
>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633
    }

    @Test
    public void testConnectionWithDatabase() {
        Employee employee = empRepo.findByFirstname("Cristian");
<<<<<<< HEAD
        Adress adress = adressRepo.findBylocality("Turnu-Magurele");
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
        assertEquals("Wrong locality", adress.getLocality(), "Turnu-Magurele");
=======
        assertEquals("You didn't get the wright employee!", employee.getFirstname(), "Cristian");
>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633
    }
}

package ro.company;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.config.CompanyConfig;
import ro.company.domain.Department;
import ro.company.domain.Employee;
import ro.company.service.DepartmentService;
import ro.company.service.EmployeeService;

import javax.inject.Inject;


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

//    @Before
//    public void setUp() throws Exception {
//    }

    @Test
    public void testACreateWithAuditableAspectWTF(){

        Employee employee = new Employee("John", "B.", (double)5050);
        employeeService.createEmployee(employee);
    }

    @Test
    public void testBUpdateWithAuditableAspectWTF(){

        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
        employee.setSalary((double)4000);
        employeeService.createEmployee(employee);
    }

    @Test
//    @Ignore
    public void testCDeleteWithAuditableAspectWTF(){

        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
        employeeService.deleteEmployee(employee);
    }
}
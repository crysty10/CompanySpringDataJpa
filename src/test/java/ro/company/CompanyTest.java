package ro.company;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.InternalResourceView;
import ro.company.config.CompanyConfig;
import ro.company.domain.*;
import ro.company.service.*;
import ro.company.web.CompanyController;
import ro.company.web.EmployeeController;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

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

    @Inject
    private AuditService auditService;

//    @Test
//    @Ignore
//    public void testACreateWithAuditableAspect(){
//
//        Employee employee = new Employee("John", "B.", (double)5050);
//        employeeService.createEmployee(employee);
//
//        Car car = new Car("BMW", "320");
//        carService.createCar(car);
//
//        Department department = new Department("IT Solutions");
//        departmentService.createDepartment(department);
//
//        Address address = new Address("Florilor",2,"D12",1,45,"Turnu-Magurele","Romania");
//        addressService.createAddress(address);
//    }
//
//    @Test
//    @Ignore
//    public void testBUpdateWithAuditableAspect(){
//
//        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
//        employee.setSalary((double)4000);
//        employeeService.createEmployee(employee);
//
//        Car car = carService.getCarByCarName("BMW");
//        car.setCarModel("520");
//        carService.createCar(car);
//
//        Department department = departmentService.getDepartmentByDeptname("IT Solutions");
//        department.setDeptname("IT");
//        departmentService.createDepartment(department);
//
//        Address address = addressService.findAddressByLocalityAndStreet("Turnu-Magurele", "Florilor");
//        address.setApartment(22);
//        addressService.createAddress(address);
//    }
//
//    @Test
//    @Ignore
//    public void testCDeleteWithAuditableAspect(){
//
//        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "B.");
//        employeeService.deleteEmployee(employee);
//
//        Car car = carService.getCarByCarName("BMW");
//        carService.deleteCar(car);
//
//        Department department = departmentService.getDepartmentByDeptname("IT");
//        departmentService.deleteDepartment(department);
//
//        Address address = addressService.findAddressByLocalityAndStreet("Turnu-Magurele", "Florilor");
//        addressService.deleteAddress(address);
//    }
//
//    @Test
//    @Ignore
//    public void testMultipleFunctionality() {
//
//        Car car = new Car("Kia", "Cee'd");
//        carService.createCar(car);
//
//        Department department = new Department("ACS");
//        departmentService.createDepartment(department);
//
//        Address address = new Address("Blvd. Mihai Bravu", 5,"C14", 9, 4, "Bucuresti", "Romania");
//        addressService.createAddress(address);
//
//        Employee employee = new Employee("Jason", "J.", (double)100000);
//        employee.setDepartment(department);
//        List<Address> addressList = new ArrayList<Address>();
//        addressList.add(address);
//        employee.setAddressList(addressList);
//        List<Car> carList = new ArrayList<Car>();
//        carList.add(car);
//        employee.setCars(carList);
//        employeeService.createEmployee(employee);
//    }
//
//    @Test
//    @Ignore
//    public void testUpdateVsSaveCreatedTimeModifiedTime() {
//
//        Employee employee = employeeService.findEmployeeByFirstnameAndLastname("John", "Travolta");
//        employee.setSalary((double)15085);
//        employeeService.createEmployee(employee);
//    }
//
//    @Test
//    @Ignore
//    public void testSaveUpdateDeleteWithSerializable() {
//        Employee employee = new Employee("Liam", "N.", (double)1605);
//        employeeService.createEmployee(employee);
//    }
//
//    @Test
//    @Ignore
//    public void testIfSerializableObjectWork() {
//        Audit audit = auditService.findFirstByObjectIdAndObjectType(7L, "ro.company.domain.Employee");
//        ByteArrayInputStream bis = new ByteArrayInputStream(audit.getObjectSerializable());
//        ObjectInput in = null;
//
//        try {
//            in = new ObjectInputStream(bis);
//            Employee employee = (Employee)in.readObject();
//            System.out.println("Merge?: " + employee);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    @Ignore
//    public void testHomePage() throws Exception {
//        CompanyController controller = new CompanyController();
//        MockMvc mockMvc =
//                standaloneSetup(controller).build();
//        mockMvc.perform(get("/"))
//                .andExpect(view().name("home"));
//    }
//
//    @Test
//    @Ignore
//    public void shouldShowRecentSpittles() throws Exception {
//        List<Employee> expectedEmployees = createEmployeeList();
//        EmployeeService mockRepository = mock(EmployeeService.class);
//        EmployeeController controller = new EmployeeController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller)
//                .setSingleView(
//                        new InternalResourceView("/WEB-INF/views/employees.jsp"))
//                .build();
//        when(mockRepository.findAllEmployees()).thenReturn(expectedEmployees);
//        mockMvc.perform(get("/employees")).andExpect(view().name("employees"))
//                .andExpect(model().attributeExists("employeeList"))
//                .andExpect(model().attribute("employeeList",
//                        hasItems(expectedEmployees.toArray())));
//    }
//
//    private List<Employee> createEmployeeList() {
//        List<Employee> employeeList = employeeService.findAllEmployees();
//        for(Employee emp : employeeList) {
//            System.out.println(emp.getFirstname());
//        }
//        return employeeList;
//    }
}
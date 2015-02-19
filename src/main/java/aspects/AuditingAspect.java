package aspects;

import domain.DateRegistration;
import domain.Employee;
import exceptions.AuditingException;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import repository.DateRegistrationRepository;
import repository.EmployeeRepository;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
@Aspect
@Component
public class AuditingAspect {

    /*
    * false -> Save
    * true  -> Update
    * */
    private boolean checkSaveOrUpdate = false;

    /*
    *
    * */
    @Inject
    private AuditingInterface auditingInterface;

    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private DateRegistrationRepository dateRegistrationRepository;

    /*
    *
    * */
    /*@Pointcut("execution(Object repository.*.save(Object)) && args(object)")
    public void pointcutGetDate(Object object){}

    @Before("pointcutGetDate(object)")
    public void beforePointcutGetDate(Object object) {
        if(object instanceof Employee) {
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {

                //nu e in baza de date
                System.out.println("Obiectul nu sa inregistrat getDate!");
            } else {

                //e in baza de date
                System.out.println("Obiectul " + emp.getFirstname() + " a fost creat " + auditingInterface.getCreatedDateTime() +
                        " si modificat " + auditingInterface.getModifiedDateTime());
            }
        }
    }*/

    /*@After("pointcutGetDate(object)")
    public void afterPointcutGetDate(Object object) {
        if(object instanceof Employee) {
            DateRegistration dateRegistration = null;
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {

                //nu e in baza de date
                System.out.println("Obiectul nu sa inregistrat!");
            } else {

                //e in baza de date
                dateRegistration = dateRegistrationRepository.findOne(emp.getEmployee_id());
                System.out.println(dateRegistration.getObject_createdDate() + " " +
                    dateRegistration.getObject_modifiedDate());
            }
        }
    }*/

    /*
    *
    * */
    @Pointcut("execution(Object repository.*.save(Object)) && args(object)")
    public void pointcutSetDate(Object object){}

    @Before("pointcutSetDate(object)")
    public void beforePointcutSetDate(Object object) {
        if(object instanceof Employee) {
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {

                //nu e in baza de date
                System.out.println("Obiectul nu sa inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setCreatedDateTime(timestamp);
                auditingInterface.setModifiedDateTime(timestamp);
            } else {

                //e in baza de date
                System.out.println("Obiectul se gaseste inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setModifiedDateTime(timestamp);
                checkSaveOrUpdate = true;
            }
        }
    }

    @After("pointcutSetDate(object)")
    public void afterPointcutSetDate(Object object) {
        if(object instanceof Employee) {
            DateRegistration dateRegistration = null;
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {
                //nu e in baza de date
                try {
                    throw new AuditingException("Something went wrong when you saved the entity!");
                } catch (AuditingException e) {
                    e.printStackTrace();
                }
            } else {
                //e in baza de date
                //auditingInterface.setModifiedDateTime(Timestamp.valueOf(LocalDateTime.now()));

                if(checkSaveOrUpdate == true) {
                    //update
                    dateRegistration = dateRegistrationRepository.findByObjectId(emp.getEmployee_id());
                    dateRegistration.setObject_modifiedDate(auditingInterface.getModifiedDateTime());
                    dateRegistrationRepository.save(dateRegistration);

                    checkSaveOrUpdate = false;
                } else {
                    //save
                    dateRegistration = new DateRegistration();
                    dateRegistration.setObjectId(emp.getEmployee_id());
                    dateRegistration.setObject_type(emp.getClass().getTypeName());
                    dateRegistration.setObject_createdDate(auditingInterface.getCreatedDateTime());
                    dateRegistration.setObject_modifiedDate(auditingInterface.getModifiedDateTime());

                    dateRegistrationRepository.save(dateRegistration);
                }
            }
        }
    }
}

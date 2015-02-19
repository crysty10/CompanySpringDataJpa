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
    * When you want to make a save/update entity in database!
    * */
    @Pointcut("execution(Object repository.*.save(Object)) && args(object)")
    public void pointcutSetDate(Object object){}

    /*
    * Check if the entity is in database
    *   if so:
    *     only update the time modified, cause is about an update
    *   else:
    *     set the create time and modified time
    * */
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

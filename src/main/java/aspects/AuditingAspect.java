package aspects;

import domain.DateRegistration;
import domain.Employee;
import exceptions.AuditingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    * This property help us to distinguish between save and update:
    *   false -> Save,
    *   true  -> Update.
    * */
    /**
     *
     */
     private boolean checkSaveOrUpdate = false;

    /*
    * Get the methods that helps you to manage the timestamp of an object.
    * */
    @Inject
    private AuditingInterface auditingInterface;

    /*
    * Get the methods that helps you to manage an object of type Employee.
    * */
    @Inject
    private EmployeeRepository employeeRepository;

    /*
    * Get the methods that helps you to save, update the timestamps of an object.
    * */
    @Inject
    private DateRegistrationRepository dateRegistrationRepository;

    /*
    * To save/update an entity in database, you must call save method! So we need a
    * pointcut here.
    * */
    /*@Pointcut("execution(Object repository.*.save(Object)) && args(object)")
    public void pointcutSetDate(Object object){}*/


    /*@Around("pointcutSetDate(object)")
    public Object aroundPointcutTimestamp(ProceedingJoinPoint pjp, Object object) throws Throwable{

        Object objectProceed = null;

        if(object instanceof Employee) {
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {
                //it's not in the database, SAVE

                System.out.println("Obiectul nu sa inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setCreatedDateTime(timestamp);
                auditingInterface.setModifiedDateTime(timestamp);
            } else {
                //it's in the database, UPDATE

                System.out.println("Obiectul se gaseste inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setModifiedDateTime(timestamp);
                checkSaveOrUpdate = true;
            }


            objectProceed = pjp.proceed();


            if(objectProceed == null) {
                //error saving in database

                try {
                    throw new AuditingException("Something went wrong when you saved the entity!");
                } catch (AuditingException e) {
                    e.printStackTrace();
                }
            } else {
                //it's in the database

                if(checkSaveOrUpdate == true) {
                    //UPDATE
                    System.out.println("Sunt in update!");
                    updateDateRegistration(objectProceed);
                    checkSaveOrUpdate = false;
                } else {
                    //SAVE
                    System.out.println("Sunt in save!");
                    saveDateRegistration(objectProceed);
                }
            }
        }

        return objectProceed;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void saveDateRegistration(Object object) {

        Employee employeeProceed = (Employee) object;

        DateRegistration dateRegistration = new DateRegistration();
        dateRegistration.setObjectId(employeeProceed.getEmployee_id());
        dateRegistration.setObject_type(employeeProceed.getClass().getTypeName());
        dateRegistration.setObject_createdDate(auditingInterface.getCreatedDateTime());
        dateRegistration.setObject_modifiedDate(auditingInterface.getModifiedDateTime());

        DateRegistration dt = dateRegistrationRepository.save(dateRegistration);
    }

    private void updateDateRegistration(Object object) {

        Employee employeeProceed = (Employee) object;

        DateRegistration dateRegistration = dateRegistrationRepository.findByObjectId(employeeProceed.getEmployee_id());
        dateRegistration.setObject_modifiedDate(auditingInterface.getModifiedDateTime());
        dateRegistrationRepository.save(dateRegistration);
    }*/

    /*
    * Check if the object is persistent in the database
    *   if so:
    *     only update the time modified, cause is about an update
    *   else:
    *     set the create time and modified time
    * */
    /*@Before("pointcutSetDate(object)")
    public void beforePointcutSetDate(Object object) {
        if(object instanceof Employee) {
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {
                //it's not in the database

                System.out.println("Obiectul nu sa inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setCreatedDateTime(timestamp);
                auditingInterface.setModifiedDateTime(timestamp);
            } else {
                //it's in the database

                System.out.println("Obiectul se gaseste inregistrat in BD, setDateBefore!");
                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                auditingInterface.setModifiedDateTime(timestamp);
                checkSaveOrUpdate = true;
            }
        }
        //same for the rest of the objects
    }*/

    @AfterReturning(pointcut = "execution(Object repository.*.save(Object))", returning = "object")
    public void afterReturningPointcutSetDate(Object object) {
        if(object instanceof Employee) {
            DateRegistration dateRegistration = null;
            Employee emp = (Employee) object;
            if(emp == null) {
                //it's not in the database

                try {
                    throw new AuditingException("Something went wrong when you saved the entity!");
                } catch (AuditingException e) {
                    e.printStackTrace();
                }
            } else {
                //it's in the database

                if(checkSaveOrUpdate == true) {
                    //update
                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setModifiedDateTime(timestamp);

                    dateRegistration = dateRegistrationRepository.findByObjectId(emp.getEmployee_id());
                    dateRegistration.setObject_modifiedDate(auditingInterface.getModifiedDateTime());
                    dateRegistrationRepository.save(dateRegistration);

                    checkSaveOrUpdate = false;
                } else {
                    //save
                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setCreatedDateTime(timestamp);
                    auditingInterface.setModifiedDateTime(timestamp);

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

    /*@After("pointcutSetDate(object)")
    public void afterPointcutSetDate(Object object) {
        if(object instanceof Employee) {
            DateRegistration dateRegistration = null;
            Employee employee = (Employee) object;
            Employee emp = employeeRepository.findEmployeeByFirstname(employee.getFirstname());
            if(emp == null) {
                //it's not in the database

                try {
                    throw new AuditingException("Something went wrong when you saved the entity!");
                } catch (AuditingException e) {
                    e.printStackTrace();
                }
            } else {
                //it's in the database

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
    }*/
}
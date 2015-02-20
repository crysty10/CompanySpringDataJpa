package aspects;

import domain.Audit;
import domain.Car;
import domain.Employee;
import exceptions.AuditingException;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import repository.AuditRepository;
import repository.EmployeeRepository;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/19/2015.
 */
@Aspect
@Component
public class AuditingAspect {

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
    private AuditRepository auditRepository;


    @AfterReturning(pointcut = "execution(Object repository.*.save(Object))", returning = "object")
    public void afterReturningPointcutSetDate(Object object) {

        if(object == null) {

            try {
                throw new AuditingException("Something went wrong when you saved the entity!");
            } catch (AuditingException e) {
                e.printStackTrace();
            }
        } else {

            if (object instanceof Employee) {

                Employee employee = (Employee) object;
                Audit audit = auditRepository.findByObjectId(employee.getEmployee_id());
                if (audit == null) {
                    //SAVE

                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setCreatedDateTime(timestamp);
                    auditingInterface.setModifiedDateTime(timestamp);

                    audit = new Audit();
                    audit.setObjectId(employee.getEmployee_id());
                    audit.setObjectType(employee.getClass().getTypeName());
                    //audit.setObject_createdDate(auditingInterface.getCreatedDateTime());
                    audit.setAction("SAVE");
                    audit.setModifiedDate(auditingInterface.getModifiedDateTime());

                    auditRepository.save(audit);
                } else {
                    //UPDATE

                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setModifiedDateTime(timestamp);

                    audit.setModifiedDate(auditingInterface.getModifiedDateTime());
                    audit.setAction("UPDATE");
                    auditRepository.save(audit);
                }
            } else if (object instanceof Car) {

                Car car = (Car) object;
                Audit audit = auditRepository.findByObjectId(car.getCar_id());
                if (audit == null) {
                    //SAVE

                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setCreatedDateTime(timestamp);
                    auditingInterface.setModifiedDateTime(timestamp);

                    audit = new Audit();
                    audit.setObjectId(car.getCar_id());
                    audit.setObjectType(car.getClass().getTypeName());
                    //audit.setObject_createdDate(auditingInterface.getCreatedDateTime());
                    audit.setAction("SAVE");
                    audit.setModifiedDate(auditingInterface.getModifiedDateTime());

                    auditRepository.save(audit);
                } else {
                    //UPDATE

                    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
                    auditingInterface.setModifiedDateTime(timestamp);

                    audit.setModifiedDate(auditingInterface.getModifiedDateTime());
                    audit.setAction("UPDATE");
                    auditRepository.save(audit);
                }
            }
            //same to the others
        }
    }
}

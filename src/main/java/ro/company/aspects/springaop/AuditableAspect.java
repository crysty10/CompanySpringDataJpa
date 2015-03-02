//package ro.company.aspects.springaop;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import ro.company.domain.*;
//import ro.company.exceptions.AuditingException;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import ro.company.service.AuditService;
//
//import javax.inject.Inject;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
///**
//* Created by Cristian.Dumitru on 2/24/2015.
//*/
//@Aspect
//@Configurable(preConstruction = true, dependencyCheck = true)
//public class AuditableAspect {
//
//    private AuditService auditService;
//
//    @Inject
//    public void setAuditService(AuditService auditService) {
//        this.auditService = auditService;
//    }
//
//    public AuditableAspect() {
//    }
//
//    /**
//     * Factory method for aspect!
//     * */
//    public static AuditableAspect aspectOf(){
//        return new AuditableAspect();
//    }
//
//    @Pointcut("execution(* *.create*(..)) && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object)")
//    public void anyDatabasePersist(Object object) {}
//
//    @Before("anyDatabasePersist(persistableObject)")
//    public void beforeSaving(Object persistableObject) {
//        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//        Auditable auditableObject = (Auditable) persistableObject;
//        auditableObject.setModifiedDateTime(timestamp);
//        auditableObject.setCreatedDateTime(timestamp);
//    }
//
//    @AfterReturning(value = "anyDatabasePersist(Object)", returning = "persistedObject")
//    public void afterReturningPointcutSetDate(Object persistedObject) {
//        if (persistedObject == null) {
//            try {
//                throw new AuditingException("Something went wrong when you saved the entity!");
//            } catch (AuditingException e) {
//                e.printStackTrace();
//            }
//        } else {
//            @SuppressWarnings("unchecked")
//            Identifiable<Long> obj = (Identifiable<Long>) persistedObject;
//            Audit audit = auditService.findAuditById(obj.getId());
//
//            if (audit == null) {
//                //SAVE
//                Auditable auditableObject = (Auditable) persistedObject;
//                audit = new Audit();
//                audit.setObjectId(obj.getId());
//                audit.setObjectType(obj.getClass().getTypeName());
//                audit.setAction("CREATE");
//                audit.setModifiedDate(auditableObject.getModifiedDateTime());
//            } else {
//                //UPDATE
//                Auditable auditableObject = (Auditable) persistedObject;
//                audit.setModifiedDate(auditableObject.getModifiedDateTime());
//                audit.setAction("UPDATE");
//
//            }
//            auditService.createAudit(audit);
//        }
//    }
//
//
//
//    @Pointcut("execution(* *.delete*(..)) && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object)")
//    public void anyDelete(Object object) {}
//
//    @Before("anyDelete(persistableObject)")
//    public void beforeDeleting(Object persistableObject) {Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//
//        @SuppressWarnings("unchecked")
//        Identifiable<Long> obj1 = (Identifiable<Long>) persistableObject;
//        Audit audit = auditService.findAuditById(obj1.getId());
//        if (audit.getId() == null){
//            System.out.println("Object doesn't exist!");
//        }
//        else{
//
//            System.out.println("Prepare entity " + audit.getObjectType().substring(18) + " for deleting!");
//        }
//        //DELETE
//        Auditable auditableObject1 = (Auditable) persistableObject;
//        audit.setModifiedDate(auditableObject1.getModifiedDateTime());
//        audit.setAction("DELETE");
//        auditService.createAudit(audit);
//
//
//    }
//
//}
//

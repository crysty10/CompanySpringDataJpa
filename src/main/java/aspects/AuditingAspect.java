//package aspects;
//
//import domain.Audit;
//import domain.Auditable;
//import domain.Identifiable;
//import exceptions.AuditingException;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import repository.AuditRepository;
//
//import javax.inject.Inject;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
///**
// * Created by Cristian.Dumitru on 2/19/2015.
// */
////@Aspect
////@Component
//public class AuditingAspect {
//
//    /*
//    * Get the methods that helps you to save, update the timestamps of an object.
//    * */
//    @Inject
//    private AuditRepository auditRepository;
//
//    @Pointcut("execution(* repository.*.save(Object)) && args(object)")
//    public Object anyDatabasePersist(Object object) {
//        return object;
//    }
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
//
//
//        if (persistedObject == null) {
//
//            try {
//                throw new AuditingException("Something went wrong when you saved the entity!");
//            } catch (AuditingException e) {
//                e.printStackTrace();
//            }
//        } else {
//            @SuppressWarnings("unchecked")
//            Identifiable<Long> o = (Identifiable<Long>) persistedObject;
//            Audit audit = auditRepository.findByObjectId(o.getId());
//            if (audit == null) {
//                //SAVE
//
//                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//                Auditable auditableObject = (Auditable) persistedObject;
//                auditableObject.setCreatedDateTime(timestamp);
//                auditableObject.setModifiedDateTime(timestamp);
//
//                audit = new Audit();
//                audit.setObjectId(o.getId());
//                audit.setObjectType(o.getClass().getTypeName());
//                //audit.setObject_createdDate(auditable.getCreatedDateTime());
//                audit.setAction("SAVE");
//                audit.setModifiedDate(auditableObject.getModifiedDateTime());
//
//                auditRepository.save(audit);
//            } else {
//                //UPDATE
//
//                Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
//                Auditable auditableObject = (Auditable) persistedObject;
//                auditableObject.setModifiedDateTime(timestamp);
//
//                audit.setModifiedDate(auditableObject.getModifiedDateTime());
//                audit.setAction("UPDATE");
//                auditRepository.save(audit);
//            }
//        }
//    }
//}

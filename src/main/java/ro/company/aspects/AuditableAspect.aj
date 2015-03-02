package ro.company.aspects;

import org.springframework.beans.factory.annotation.Configurable;
import ro.company.domain.Audit;
import ro.company.domain.Auditable;
import ro.company.domain.Identifiable;
import ro.company.exceptions.AuditingException;
import ro.company.service.AuditService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
* Created by Cristian.Dumitru on 2/23/2015.
*/
@Configurable(preConstruction = true, dependencyCheck = true)
public aspect AuditableAspect {

    private AuditService auditService;


    @Inject
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }
//    @Inject
//    public AuditService auditService;

    public AuditableAspect() {
    }

    pointcut anyDatabasePersist(Object object):execution(* *.create*(..)) && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object);

    before(Object persistableObject): anyDatabasePersist(persistableObject) {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Auditable auditableObject = (Auditable) persistableObject;
        auditableObject.setModifiedDateTime(timestamp);
        auditableObject.setCreatedDateTime(timestamp);
    }

    after(Object object) returning(Object persistedObject): anyDatabasePersist(object) {
        if (persistedObject == null) {
            try {
                throw new AuditingException("Something went wrong when you saved the entity!");
            } catch (AuditingException e) {
               throw new RuntimeException(e.getCause());
            }
        } else {
            @SuppressWarnings("unchecked")
            Identifiable<Long> obj = (Identifiable<Long>) persistedObject;
            Audit audit = auditService.findAuditById(obj.getId());


            if (audit == null) {
                //CREATE
                Auditable auditableObject = (Auditable) persistedObject;
                audit = new Audit();
                audit.setObjectId(obj.getId());
                audit.setObjectType(obj.getClass().getTypeName());
                audit.setAction("CREATE");
                audit.setModifiedDate(auditableObject.getModifiedDateTime());
            } else {
                //UPDATE
                Auditable auditableObject = (Auditable) persistedObject;
                audit.setModifiedDate(auditableObject.getModifiedDateTime());
                audit.setAction("UPDATE");

            }
            auditService.createAudit(audit);

        }

    }

    pointcut anyDelete(Object object):execution(* *.delete*(..)) && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object);

    before(Object persistableObject): anyDelete(persistableObject) {

        @SuppressWarnings("unchecked")
        Identifiable<Long> obj1 = (Identifiable<Long>) persistableObject;
        Audit audit = auditService.findAuditById(obj1.getId());
        if (audit.getId() == null){
            System.out.println("Object doesn't exist!");
        }
        else{

            System.out.println("Prepare entity " + audit.getObjectType().substring(18) + " for deleting!");
        }
        //DELETE
        Auditable auditableObject1 = (Auditable) persistableObject;
        audit.setModifiedDate(auditableObject1.getModifiedDateTime());
        audit.setAction("DELETE");
        auditService.createAudit(audit);


    }
}


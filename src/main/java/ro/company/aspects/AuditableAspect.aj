package ro.company.aspects;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.beans.factory.annotation.Configurable;
import ro.company.domain.Audit;
import ro.company.domain.Auditable;
import ro.company.domain.Identifiable;
import ro.company.domain.util.ObjectSerializer;
import ro.company.exceptions.AuditingException;
import ro.company.service.AuditService;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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

    public AuditableAspect() {
    }

    /**
     * Aspect for CREATE / UPDATE!
     * */
    pointcut anyDatabasePersist(Object object) : execution(* *.create*(..))
            && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object);

    before(Object persistableObject): anyDatabasePersist(persistableObject) {

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Auditable auditableObject = (Auditable) persistableObject;
        if(auditableObject.getCreatedDateTime() != null) {
            //UPDATE
            auditableObject.setModifiedDateTime(timestamp);
        } else {
            //CREATE
            auditableObject.setModifiedDateTime(timestamp);
            auditableObject.setCreatedDateTime(timestamp);
        }
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
            Audit audit = auditService.findFirstByObjectIdAndObjectType(obj.getId(), obj.getClass().getTypeName());
            Auditable auditableObject = (Auditable) persistedObject;

            byte[] objectSerializable = ObjectSerializer.objectToByteStream(obj);

            if (audit == null) {
                //CREATE
                audit = new Audit();
                audit.setObjectId(obj.getId());
                audit.setObjectType(obj.getClass().getTypeName());
                audit.setAction("CREATE");
                audit.setObjectSerializable(objectSerializable);
                audit.setModifiedDate(auditableObject.getModifiedDateTime());
            } else {
                //UPDATE
                audit = new Audit();
                audit.setObjectId(obj.getId());
                audit.setObjectType(obj.getClass().getTypeName());
                audit.setAction("UPDATE");
                audit.setObjectSerializable(objectSerializable);
                audit.setModifiedDate(auditableObject.getModifiedDateTime());
            }
            auditService.createAudit(audit);
        }
    }

    /**
     * Aspect for DELETE!
     * */
    pointcut anyDelete(Object object): execution(* *.delete*(..))
            && within(ro.company.service.*) && !within(ro.company.service.AuditService+) && args(object);

    before(Object persistableObject): anyDelete(persistableObject) {

        System.out.println("I'm in before delete");

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        @SuppressWarnings("unchecked")
        Identifiable<Long> object = (Identifiable<Long>) persistableObject;
        byte[] objectSerializable = ObjectSerializer.objectToByteStream(object);
        //DELETE
        Audit audit = new Audit();
        audit.setObjectId(object.getId());
        audit.setObjectType(object.getClass().getTypeName());
        audit.setAction("DELETE");
        audit.setObjectSerializable(objectSerializable);
        audit.setModifiedDate(timestamp);
        auditService.createAudit(audit);
    }
}
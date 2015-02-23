package aspects;

import domain.Auditable;
import repository.AuditRepository;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/23/2015.
 */
public aspect AuditableAspect {

    //@Inject
    //private AuditRepository auditRepository;

    public AuditableAspect(){}

    pointcut anyMethod(Object object):
            execution(Object repository.*.save(Object)) && args(object);

    before(Object persistableObject): anyMethod(persistableObject) {

        System.out.println("I'm in before!!!");
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Auditable auditableObject = (Auditable) persistableObject;
        auditableObject.setModifiedDateTime(timestamp);
        auditableObject.setCreatedDateTime(timestamp);
    }

    /*after(Object object) returning(Object persistedObject): anyMethod(object) {

    System.out.println("I'm in after!!!");
    if (persistedObject == null) {

        try {
            throw new AuditingException("Something went wrong when you saved the entity!");
        } catch (AuditingException e) {
            e.printStackTrace();
        }
    } else {
        @SuppressWarnings("unchecked")
        Identifiable<Long> o = (Identifiable<Long>) persistedObject;
        Audit audit = auditRepository.findByObjectId(o.getId());
        if (audit == null) {
            //SAVE

            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            Auditable auditableObject = (Auditable) persistedObject;
            auditableObject.setCreatedDateTime(timestamp);
            auditableObject.setModifiedDateTime(timestamp);

            audit = new Audit();
            audit.setObjectId(o.getId());
            audit.setObjectType(o.getClass().getTypeName());
            //audit.setObject_createdDate(auditable.getCreatedDateTime());
            audit.setAction("SAVE");
            audit.setModifiedDate(auditableObject.getModifiedDateTime());

            auditRepository.save(audit);
        } else {
            //UPDATE

            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            Auditable auditableObject = (Auditable) persistedObject;
            auditableObject.setModifiedDateTime(timestamp);

            audit.setModifiedDate(auditableObject.getModifiedDateTime());
            audit.setAction("UPDATE");
            auditRepository.save(audit);
        }
    }
}*/
}

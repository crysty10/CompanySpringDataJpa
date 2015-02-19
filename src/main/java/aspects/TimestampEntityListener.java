package aspects;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
public class TimestampEntityListener {

        /*@PrePersist
        void onCreate(Object entity) {
            if(entity instanceof AuditingInterfaceImpl) {
                AuditingInterfaceImpl eact = (AuditingInterfaceImpl)entity;
                if(eact.getModifiedDateTime() == null) {
                    eact.setModifiedDateTime(ZonedDateTime.now());
                }
                eact.getModifiedDateTime();
            }
        }

        @PreUpdate
        void onPersist(Object entity) {
            if(entity instanceof AuditingInterfaceImpl) {
                AuditingInterfaceImpl eact = (AuditingInterfaceImpl)entity;
                if(eact.getModifiedDateTime() == null) {
                    eact.setCreateDateTime(ZonedDateTime.now());
                }
                eact.getModifiedDateTime();
            }
        }*/
}

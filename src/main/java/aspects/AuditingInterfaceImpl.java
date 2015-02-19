package aspects;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
@Component
public class AuditingInterfaceImpl implements AuditingInterface {

    private Timestamp createDateTime;
    private Timestamp modifiedDateTime;

    @Override
    public Timestamp getModifiedDateTime() {

        return modifiedDateTime;
    }

    @Override
    public void setModifiedDateTime(Timestamp localDateTime) {

        this.modifiedDateTime = localDateTime;
    }

    @Override
    public Timestamp getCreatedDateTime() {

        return createDateTime;
    }

    @Override
    public void setCreatedDateTime(Timestamp localDateTime) {

        this.createDateTime = localDateTime;
    }
}
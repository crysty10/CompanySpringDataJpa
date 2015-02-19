package aspects;

import domain.Employee;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
public interface AuditingInterface {

    public Timestamp getModifiedDateTime();
    public void setModifiedDateTime(Timestamp localDateTime);

    public Timestamp getCreatedDateTime();
    public void setCreatedDateTime(Timestamp localDateTime);
}
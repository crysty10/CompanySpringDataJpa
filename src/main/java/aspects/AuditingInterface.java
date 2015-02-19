package aspects;

import domain.Employee;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
public interface AuditingInterface {

    public LocalDateTime getModifiedDateTime();
    public void setModifiedDateTime(LocalDateTime localDateTime);

    public LocalDateTime getCreatedDateTime();
    public void setCreatedDateTime(LocalDateTime localDateTime);
}
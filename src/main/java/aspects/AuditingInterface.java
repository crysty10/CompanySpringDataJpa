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

/*
* This interface offers you the functionality to set and get
* the timestamp of an object.
* */
public interface AuditingInterface {

    /*
    * Methods that gives you the created time or modified time,
    * helpful to save those object properties into the database
    * table DateRegistration.
    * */
    public Timestamp getModifiedDateTime();
    public Timestamp getCreatedDateTime();

    /*
    * Methods used to set the timestamp of an object.
    * */
    public void setModifiedDateTime(Timestamp localDateTime);
    public void setCreatedDateTime(Timestamp localDateTime);
}
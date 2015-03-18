package ro.company.domain;

import java.sql.Timestamp;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */

/*
* This interface offers you the functionality to set and get
* the timestamp of an object.
* */
public interface Auditable {

    /*
    * Methods that gives you the created time or modified time,
    * helpful to save those object properties into the database
    * table DateRegistration.
    * */
    public Timestamp getModifiedDateTime();

    /*
    * Methods used to set the timestamp of an object.
    * */
    public void setModifiedDateTime(Timestamp localDateTime);

    public Timestamp getCreatedDateTime();

    public void setCreatedDateTime(Timestamp localDateTime);
}
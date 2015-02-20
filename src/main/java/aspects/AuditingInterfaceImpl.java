package aspects;

import org.springframework.stereotype.Component;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
@Component
@MappedSuperclass
public class AuditingInterfaceImpl implements AuditingInterface {
    /*
    * Class that store the timestamp of an object when it's saved or
    * updated in the database; and implements the methods that help
    * you to get or set the values.
    * */

    //create date property
    private Timestamp createDateTime;
    //modified date property
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
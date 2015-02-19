package domain;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Florin.Cojocaru on 2/19/2015.
 */

@Entity
@Table(name = "dateRegistration")
public class DateRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "date_seq")
    @SequenceGenerator(name = "date_seq", sequenceName = "dateregistration_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id", unique = true)
    private Long date_id;
    @Column(name = "object_id")
    private Long objectId;
    private String object_type;
    private Timestamp object_createdDate;
    private Timestamp object_modifiedDate;

    public DateRegistration() {};
    

    public DateRegistration(Long objectId, String object_type, Timestamp object_createdDate, Timestamp object_modifiedDate) {
        this.objectId = objectId;
        this.object_type = object_type;
        this.object_createdDate = object_createdDate;
        this.object_modifiedDate = object_modifiedDate;
    }

    public Long getDate_id() {
        return date_id;
    }

    public void setDate_id(Long date_id) {
        this.date_id = date_id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObject_type() {
        return object_type;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public Timestamp getObject_createdDate() {
        return object_createdDate;
    }

    public void setObject_createdDate(Timestamp object_createdDate) {
        this.object_createdDate = object_createdDate;
    }

    public Timestamp getObject_modifiedDate() {
        return object_modifiedDate;
    }

    public void setObject_modifiedDate(Timestamp object_modifiedDate) {
        this.object_modifiedDate = object_modifiedDate;
    }
}
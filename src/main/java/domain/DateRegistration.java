package domain;

import org.joda.time.DateTime;

import javax.persistence.*;

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
    private Long object_id;
    private String object_type;
    private DateTime object_createdDate;
    private DateTime object_modifiedDate;

    public DateRegistration() {};

    public DateRegistration(Long object_id, String object_type, DateTime object_createdDate, DateTime object_modifiedDate) {
        this.object_id = object_id;
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

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public String getObject_type() {
        return object_type;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public DateTime getObject_createdDate() {
        return object_createdDate;
    }

    public void setObject_createdDate(DateTime object_createdDate) {
        this.object_createdDate = object_createdDate;
    }

    public DateTime getObject_modifiedDate() {
        return object_modifiedDate;
    }

    public void setObject_modifiedDate(DateTime object_modifiedDate) {
        this.object_modifiedDate = object_modifiedDate;
    }

    //object_ID , object_type, object_CreatedDate, object_ModifiedDate

}

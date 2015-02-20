package domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cristian.Dumitru on 2/20/2015.
 */
@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "audit_seq")
    @SequenceGenerator(name = "audit_seq", sequenceName = "audit_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(nullable = false)
    private Long objectId;

    @Column(nullable = false)
    private String objectType;

    @Column(nullable = false)
    private String action;

    private Timestamp modifiedDate;

    public Audit() {};


    public Audit(Long objectId, String objectType, String action, Timestamp modifiedDate) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.action = action;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

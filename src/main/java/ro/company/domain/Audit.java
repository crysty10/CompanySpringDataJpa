package ro.company.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Cristian.Dumitru on 2/20/2015.
 */
@Entity
@Table(name = "audit")
public class Audit implements Identifiable<Long> {

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

//    @Column(nullable = false)
//    private byte[] objectSerializable;

    private Timestamp modifiedDate;

    public Audit() {
    }

    ;

//    public byte[] getObjectSerializable() {
//        return objectSerializable;
//    }
//
//    public void setObjectSerializable(byte[] objectSerializable) {
//        this.objectSerializable = objectSerializable;
//    }

    public Audit(Long objectId, String objectType, String action,/* byte[] objectSerializable,*/ Timestamp modifiedDate) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.action = action;
        // this.objectSerializable = objectSerializable;
        this.modifiedDate = modifiedDate;
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

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

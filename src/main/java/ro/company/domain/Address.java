package ro.company.domain;

import ro.company.annotation.AuditableAnnotation;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */
@Entity
@Table(name = "Address")
@AuditableAnnotation
public class Address implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "add_seq")
    @SequenceGenerator(name = "add_seq", sequenceName = "address_add_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "add_id")
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column
    private Integer street_nr;

    @Column(length = 10)
    private String building;

    @Column
    private Integer floor;

    @Column
    private Integer apartment;

    @Column(nullable = false)
    private String locality;

    @Column(nullable = false)
    private String country;

    public Address() {}

    public Address(String street, Integer street_nr, String building, Integer floor, Integer apartment, String locality, String country) {

        this.street = street;
        this.street_nr = street_nr;
        this.building = building;
        this.floor = floor;
        this.apartment = apartment;
        this.locality = locality;
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreet_nr() {
        return street_nr;
    }

    public void setStreet_nr(Integer street_nr) {
        this.street_nr = street_nr;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", street_nr=" + street_nr +
                ", building='" + building + '\'' +
                ", floor=" + floor +
                ", apartment=" + apartment +
                ", locality='" + locality + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public Long getId() {
        return this.id;
    }
}

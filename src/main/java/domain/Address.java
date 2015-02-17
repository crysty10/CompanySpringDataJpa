package domain;

import javax.persistence.*;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(generator = "add_seq")
    @SequenceGenerator(name = "add_seq", sequenceName = "address_id_seq")
    @Column(name = "id")
    private int address_id;

    @Column(nullable = false)
    private String street;

    @Column
    private int street_nr;

    @Column(length = 10)
    private String building;

    @Column
    private int floor;

    @Column
    private int apartment;

    @Column(nullable = false)
    private String locality;

    @Column(nullable = false)
    private String country;

    public Address() {}

    public Address(String street, int street_nr, String building, int floor, int apartment, String locality, String country) {

        this.street = street;
        this.street_nr = street_nr;
        this.building = building;
        this.floor = floor;
        this.apartment = apartment;
        this.locality = locality;
        this.country = country;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreet_nr() {
        return street_nr;
    }

    public void setStreet_nr(int street_nr) {
        this.street_nr = street_nr;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
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
}

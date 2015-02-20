package domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_car_id_seq", allocationSize = 1)
    @Column(name = "car_id", nullable = false)
    private Long car_id;

    @Column(nullable = false, name = "car_name")
    private String carName;

    @Column(nullable = false, name = "car_model")
    private String carModel;

    @Column(nullable = false)
    private Timestamp carCreatedDate;

    @Column(nullable = false)
    private Timestamp carModifiedDate;

    @ManyToMany(mappedBy = "cars")
    private List<Employee> employees = new ArrayList<Employee>();

    public Car() {
    }

    public Car(String carName, String carModel) {
        this.carName = carName;
        this.carModel = carModel;

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getCar_id() {

        return car_id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public Timestamp getCarCreatedDate() {
        return carCreatedDate;
    }

    public void setCarCreatedDate(Timestamp carCreatedDate) {
        this.carCreatedDate = carCreatedDate;
    }

    public Timestamp getCarModifiedDate() {
        return carModifiedDate;
    }

    public void setCarModifiedDate(Timestamp carModifiedDate) {
        this.carModifiedDate = carModifiedDate;
    }
}

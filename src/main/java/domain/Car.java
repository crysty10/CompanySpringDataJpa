package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq")
    @Column(name = "id", nullable = false)
    private Long car_id;

    @Column(nullable = false, name = "car_name")
    private String carName;

    @Column(nullable = false, name = "car_model")
    private String carModel;

    @ManyToMany(mappedBy = "cars")
    private Set<Employee> employees = new HashSet<Employee>();

    public Car() {
    }

    public Car(String carName, String carModel) {
        this.carName = carName;
        this.carModel = carModel;

    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
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

}

package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Entity
@Table(name = "Car")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Car implements Identifiable<Long> {

    @Id
    @GeneratedValue(generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_car_id_seq", allocationSize = 1)
    @Column(name = "car_id", nullable = false)
    private Long id;

    @Column(nullable = false, name = "car_name")
    private String carName;

    @Column(nullable = false, name = "car_model")
    private String carModel;

    @ManyToMany(mappedBy = "cars")
    private List<Employee> employees = new ArrayList<Employee>();

    public Car() {
    }

    public Car(String carName, String carModel) {
        this.carName = carName;
        this.carModel = carModel;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

    public void setId(long id) {
        this.id = id;
    }
}

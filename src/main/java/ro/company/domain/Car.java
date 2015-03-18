package ro.company.domain;

import org.hibernate.validator.constraints.NotEmpty;
import ro.company.annotation.AuditableAnnotation;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/17/2015.
 */

@Entity
@Table(name = "Car")
@AuditableAnnotation
public class Car implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_car_id_seq", allocationSize = 1)
    @Column(name = "car_id", nullable = false)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    @Column(nullable = false, name = "car_name")
    private String carName;

    @NotEmpty
    @Size(min = 2, max = 30)
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", employees=" + employees +
                '}';
    }
}

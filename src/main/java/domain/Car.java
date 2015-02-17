package domain;

import javax.persistence.*;

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
    private int car_id;

    @Column(nullable = false)
    private String car_name;

    @Column(nullable = false)
    private String car_model;

    public Car(){}

    public Car(String car_name, String car_model) {
        this.car_name = car_name;
        this.car_model = car_model;

    }

    public int getCar_id() {

        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }
}

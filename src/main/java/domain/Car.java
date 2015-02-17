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

    @Column(nullable = false, name = "car_name")
    private String carName;

    @Column(nullable = false, name = "car_model")
    private String carModel;

    public Car() {
    }

    public Car(String carName, String carModel) {
        this.carName = carName;
        this.carModel = carModel;

    }

    public int getCar_id() {

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

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

}

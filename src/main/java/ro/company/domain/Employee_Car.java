package ro.company.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Florin.Cojocaru on 2/18/2015.
 */

@Entity
@Table(name = "employee_car")
public class Employee_Car implements Serializable {

    @Id
    @Column(name = "emp_id")
    private Long employee_id;

    @Id
    @Column(name = "car_id")
    private Long car_id;

    public Employee_Car() {}

    public Employee_Car(Long employee_id, Long car_id) {
        this.employee_id = employee_id;
        this.car_id = car_id;
    }
}

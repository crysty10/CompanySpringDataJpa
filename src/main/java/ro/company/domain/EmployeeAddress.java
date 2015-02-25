package ro.company.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
@Entity
@Table(name = "Employee_Address")
public class EmployeeAddress implements Serializable {

    @Id
    @Column(name = "emp_id")
    private Long emp_id;

    @Id
    @Column(name = "add_id")
    private Long add_id;

    public EmployeeAddress() {}

    public EmployeeAddress(Long emp_id, Long add_id) {
        this.emp_id = emp_id;
        this.add_id = add_id;
    }
}

package domain;

import javax.persistence.*;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "employee_id_seq")
    @Column(name = "id")
    private Long employee_id;
    private String firstname;
    private String lastname;
    private Double salary;

    public Employee(){}

    public Employee(String firstname, String lastname, Double salary) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

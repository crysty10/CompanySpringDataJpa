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
    private long employee_id;
    private String firstname;
    private String lastname;
    private double salary;

    public Employee(){}

    public Employee(String firstname, String lastname, double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
}

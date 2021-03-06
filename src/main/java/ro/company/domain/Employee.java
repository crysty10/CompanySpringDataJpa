package ro.company.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import ro.company.annotation.AuditableAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Employee")
@AuditableAnnotation
public class Employee implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "employee_emp_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "emp_id", unique = true, nullable = false)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastname;

    @NotNull
    @Range(min = 1, max = 100000)
    private Double salary;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Department.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "Employee_Address",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "add_id"))
    private List<Address> addressList = new ArrayList<Address>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "Employee_Car",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars = new ArrayList<Car>();

    public Employee() {
    }

    public Employee(String firstname, String lastname, Double salary) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void setEmployee_id(Long employee_id) {
        this.id = employee_id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}

package ro.company.domain;

import ro.company.annotation.AuditableAnnotation;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max=30)
    private String lastname;

    @NotNull
    @Min(value = 1)
    @Max(value = 100000)
    private Double salary;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Department.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Address",
                joinColumns = @JoinColumn(name = "emp_id"),
                inverseJoinColumns = @JoinColumn(name = "add_id"))
    private List<Address> addressList = new ArrayList<Address>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Car",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars = new ArrayList<Car>();

    public Employee(){}

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
        return "Employee{" +
                "employee_id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", addressList=" + addressList +
                ", cars=" + cars +
                '}';
    }

    @Override
    public Long getId() {
        return this.id;
    }
}

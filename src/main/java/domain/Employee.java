package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "employee_emp_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "emp_id", unique = true)
    private Long employee_id;
    private String firstname;
    private String lastname;
    private Double salary;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Employee_Address",
                joinColumns = @JoinColumn(name = "emp_id"),
                inverseJoinColumns = @JoinColumn(name = "add_id"))
    private List<Address> addressList = new ArrayList<Address>();

    @ManyToMany(fetch = FetchType.EAGER)
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", addressList=" + addressList +
                ", cars=" + cars +
                '}';
    }
}

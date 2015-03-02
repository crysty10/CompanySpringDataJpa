package ro.company.domain;

import javax.persistence.*;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Department")
public class Department implements Identifiable<Long> {


    @Id
    @GeneratedValue(generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq", sequenceName = "department_dep_id_seq", allocationSize = 1)
    @Column(name = "dep_id")
    private Long id;
    private String deptname;

    public Department() {}

    public Department(String deptname) {
        this.deptname = deptname;
    }

    public void setDepartment_id(Long department_id) {
        this.id = department_id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
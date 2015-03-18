package ro.company.domain;

import org.hibernate.validator.constraints.NotEmpty;
import ro.company.annotation.AuditableAnnotation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Department")
@AuditableAnnotation
public class Department implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq", sequenceName = "department_dep_id_seq", allocationSize = 1)
    @Column(name = "dep_id")
    private Long id;

    @NotEmpty
    @Size(min=2, max=20)
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}

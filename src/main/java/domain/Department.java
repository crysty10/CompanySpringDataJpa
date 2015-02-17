package domain;

import javax.persistence.*;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq", sequenceName = "department_id_seq")
    private Integer id;
    private String deptname;

    public Department() {}

    public Department(String deptname) {
        this.deptname = deptname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}

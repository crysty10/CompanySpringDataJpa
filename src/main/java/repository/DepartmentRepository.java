package repository;

import domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDeptname(String deptname);
}

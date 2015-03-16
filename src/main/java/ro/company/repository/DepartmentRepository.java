package ro.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.company.domain.Department;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /*
    * Get department by department name!
    * */
    Department findByDeptname(String deptname);
}

package ro.company.repository;

import ro.company.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cristian.Dumitru on 2/17/2015.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /*
    * Get department by department name!
    * */
    Department findByDeptname(String deptname);
}

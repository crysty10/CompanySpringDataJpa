package ro.company.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.company.domain.Department;
import ro.company.repository.DepartmentRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {

        //return em.merge(department);
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findOne(id);
    }

    @Override
    public Department getDepartmentByDeptname(String deptname) {

        return departmentRepository.findByDeptname(deptname);
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteDepartment(Department department) {

        departmentRepository.delete(department);
    }
}

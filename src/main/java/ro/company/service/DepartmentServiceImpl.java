package ro.company.service;

import ro.company.domain.Department;
import ro.company.repository.DepartmentRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findOne(id);
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {

        departmentRepository.delete(id);

    }
}

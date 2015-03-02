package ro.company.service;

import ro.company.domain.Department;

import java.util.List;

/**
 * Created by Florin.Cojocaru on 2/27/2015.
 */
public interface DepartmentService {

    //CREATE OR UPDATE
    Department createDepartment(Department department);

    //READ
    Department getDepartmentById(Long id);
    Department getDepartmentByDeptname(String deptname);
    List<Department> getAllDepartments();

    //DELETE
    void deleteDepartment(Department department);
}

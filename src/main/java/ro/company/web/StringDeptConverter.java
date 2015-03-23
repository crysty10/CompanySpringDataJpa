package ro.company.web;

import org.springframework.core.convert.converter.Converter;
import ro.company.domain.Department;
import ro.company.service.DepartmentService;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by Florin.Cojocaru on 3/19/2015.
 */
public class StringDeptConverter implements Converter<String, Department> {

    @Inject
    private DepartmentService departmentService;


    @Transactional
    @Override
    public Department convert(final String deptIdStr) {
        return departmentService.getDepartmentById(Long.valueOf(deptIdStr));
    }
}

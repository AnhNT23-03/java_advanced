package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable, DepartmentFilterForm form);
    Department findById(int id);
    void create(DepartmentCreateForm form);
    void update(DepartmentUpateForm form);
    void deleteById(int id);
}

package com.vti.controller;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpateForm;
import com.vti.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    // tạo 1 đối tượng Mapper
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IDepartmentService service;

    @GetMapping
    public Page<DepartmentDto> findAll(Pageable pageable, DepartmentFilterForm form) {
        Page<Department> page = service.findAll(pageable, form);
        return page.map(department -> {
            DepartmentDto dto = mapper.map(department, DepartmentDto.class);
            dto.add(linkTo(methodOn(DepartmentController.class)
                    .findById(department.getId())).withSelfRel());
            return dto;
        });
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") int id) {
        Department department = service.findById(id); // tìm phòng ban
        DepartmentDto dto = mapper.map(department, DepartmentDto.class); // Use ModelMapper -> map phòng ban đó sang dto
        dto.add(linkTo(methodOn(DepartmentController.class)
                .findById(id)).withSelfRel());
        return dto; // trả về dto đó
    }

    @PostMapping
    public void create(@RequestBody DepartmentCreateForm form) {
        service.create(form);
    }

    @PutMapping
    public void update(@RequestBody DepartmentUpateForm form) {
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}

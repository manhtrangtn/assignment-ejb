package com.t1809e.g4.assignmentejb.controller;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "get-department", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartment(String id) {
        return ResponseEntity.ok(departmentService.findOne(id));
    }

    @RequestMapping(value = "get-departments", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartments(String keyword) {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createDepartment(Department department) {
        departmentService.save(department);
        return ResponseEntity.ok("Save success!");
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDepartment(Department department) {
        departmentService.save(department);
        return ResponseEntity.ok("Update success!");
    }

    @RequestMapping(value = "delete-department", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDepartment(String id) {
        departmentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}

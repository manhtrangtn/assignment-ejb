package com.t1809e.g4.assignmentejb.controller;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("api/v1/department")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "get-department", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartment(@RequestParam String id) {
        return ResponseEntity.ok(departmentService.findOne(id));
    }

    @RequestMapping(value = "get-departments", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartments(@RequestParam String keyword) {
        return ResponseEntity.ok(departmentService.findAll(keyword));
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        department.setCreatedAt(LocalDateTime.now());
        departmentService.save(department);
        return ResponseEntity.ok("Save success!");
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
        department.setUpdatedAt(LocalDateTime.now());
        departmentService.save(department);
        return ResponseEntity.ok("Update success!");
    }

    @RequestMapping(value = "delete-department", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDepartment(@RequestParam String id) {
        departmentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}

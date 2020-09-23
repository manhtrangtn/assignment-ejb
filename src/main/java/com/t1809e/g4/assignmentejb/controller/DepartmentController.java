package com.t1809e.g4.assignmentejb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.service.DepartmentService;


/**
 *
 * @author oishi
 */
@RestController
//@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    //list all Departments
    @GetMapping("/getall")
    public List<Department> getAll(){
        return (List<Department>) departmentService.findAll();
    }
    
    //query by ID
    @RequestMapping("/{id}")
    public Department getById(@PathVariable("id") String id){
    	Department dpt = departmentService.findOne(id);
        if (dpt == null){
            System.out.println("Department Not found");
        }
        return dpt;
    }
    
    //add new Department
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Department dpt){
    	departmentService.save(dpt);
        return ResponseEntity.ok(null);
    }
    
    //delete Department
    public void deleteById(@PathVariable String id){
    	Department dpt= departmentService.findOne(id);
        if(dpt == null){
            System.out.println("Department Not found");
            return;
        }
        departmentService.delete(id);
        System.out.println("deleted successful");
    }
    
    //update Department
    @PutMapping("/update")
    public Department update(@RequestBody Department dpt){
    	Department updtDpt = departmentService.findOne(dpt.getId());
        if (updtDpt != null){
        	departmentService.save(dpt);
            System.out.println("saved");
            return dpt;
        }
        System.out.println("Department Not found");
        return updtDpt;
    }
    
}
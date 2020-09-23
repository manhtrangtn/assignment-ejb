package com.t1809e.g4.assignmentejb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.repository.DepartmentRepository;

@Component
public class DepartmentService {
	@Autowired
    private DepartmentRepository departmentRepository;
    
    public Iterable<Department> findAll(){
        return departmentRepository.findAll();
    }
    
    public Department findOne(String id){
        return departmentRepository.findById(id).orElse(null);
    }
    
    public void save(Department newDepartment){
    	departmentRepository.save(newDepartment);
    }
    
    public void delete(String id){
    	departmentRepository.deleteById(id);
    }
}

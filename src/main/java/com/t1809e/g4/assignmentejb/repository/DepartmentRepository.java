package com.t1809e.g4.assignmentejb.repository;

import com.t1809e.g4.assignmentejb.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}

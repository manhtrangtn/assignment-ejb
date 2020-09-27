package com.t1809e.g4.assignmentejb.repository;

import com.t1809e.g4.assignmentejb.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findAllByNameLike(String keywords);
}

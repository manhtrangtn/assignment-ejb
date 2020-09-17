package com.t1809e.g4.assignmentejb.repository;

import com.t1809e.g4.assignmentejb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

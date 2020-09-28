package com.t1809e.g4.assignmentejb.repository;

import com.t1809e.g4.assignmentejb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.firstName like :keyword or u.lastName like :keyword")
    List<User> fullTextSearchh(String keyword);
}

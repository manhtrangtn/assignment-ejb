package com.t1809e.g4.assignmentejb.repository;

import com.t1809e.g4.assignmentejb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.firstName like :keyword or u.lastName like :keyword")
    List<User> findAllByFirstNameOrLastNameLike(@Param("keyword") String keyword);
}

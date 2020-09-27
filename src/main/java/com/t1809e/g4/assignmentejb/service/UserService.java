package com.t1809e.g4.assignmentejb.service;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.entity.User;
import com.t1809e.g4.assignmentejb.repository.DepartmentRepository;
import com.t1809e.g4.assignmentejb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public User getUser(String id){
        return userRepository.findById(id).get();
    }

    public List<User> getUsers(String keyword){
        keyword = "%" + keyword + "%";
        return userRepository.findAllByFirstNameOrLastNameLike(keyword);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public void addUserToDepartment(String userId, String departmentId){
        Department department = departmentRepository.findById(departmentId).get();
        User user = userRepository.findById(userId).get();

        user.setDepartment(department);
        userRepository.save(user);
    }

    public void deleteUserFromDepartment(String userId, String departmentId){
        User user = userRepository.findById(userId).get();

        user.setDepartment(null);
        userRepository.save(user);
    }
}

package com.t1809e.g4.assignmentejb.controller;

import com.t1809e.g4.assignmentejb.entity.User;
import com.t1809e.g4.assignmentejb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
@Component
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "get-user", method = RequestMethod.GET)
    ResponseEntity<?> getUser(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @RequestMapping(value = "get-users", method = RequestMethod.GET)
    ResponseEntity<?> getUsers(@RequestParam String keyword) {
        keyword = ObjectUtils.isEmpty(keyword)? "":keyword;
        return ResponseEntity.ok(userService.getUsers(keyword));
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody User user) {
        user.setCreatedAt(LocalDateTime.now());
        userService.saveUser(user);
        return ResponseEntity.ok("Created successfully!");
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    ResponseEntity<?> updateUser(@RequestBody User user) {
        user.setUpdatedAt(LocalDateTime.now());
        userService.saveUser(user);
        return ResponseEntity.ok("Updated successfully!");
    }

    @RequestMapping(value = "delete-user", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted successfully!");
    }

    @RequestMapping(value = "add-to-department", method = RequestMethod.GET)
    ResponseEntity<?> addToDepartment(@RequestParam String userId, @RequestParam String departmentId) {
        userService.addUserToDepartment(userId, departmentId);
        return ResponseEntity.ok("Updated successfully!");
    }

    @RequestMapping(value = "remove-from-department", method = RequestMethod.GET)
    ResponseEntity<?> removeFromDepartment(@RequestParam String userId, @RequestParam String departmentId) {
        userService.deleteUserFromDepartment(userId, departmentId);
        return ResponseEntity.ok("Updated successfully!");
    }
}

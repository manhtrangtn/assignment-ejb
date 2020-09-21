package com.t1809e.g4.assignmentejb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
public interface DepartmentApi {

    @RequestMapping(value = "get-department")
    ResponseEntity<?> getDepartment(@RequestParam String id);

    @RequestMapping(value = "get-departments/{sortBy}")
    ResponseEntity<?> getDepartments(@PathVariable("sortBy") String sortBy, @RequestParam String keyword);


}

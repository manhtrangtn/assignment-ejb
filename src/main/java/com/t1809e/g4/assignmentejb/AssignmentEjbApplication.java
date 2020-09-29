package com.t1809e.g4.assignmentejb;

import com.t1809e.g4.assignmentejb.entity.Department;
import com.t1809e.g4.assignmentejb.entity.User;
import com.t1809e.g4.assignmentejb.repository.DepartmentRepository;
import com.t1809e.g4.assignmentejb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
//@ComponentScan({"com.t1809e.g4.assignmentejb.*.*"})
public class AssignmentEjbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentEjbApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		Department department = new Department();
		department.setId(UUID.randomUUID().toString());
		department.setName("Head Office");
		department.setStatus("Active");
		department.setCreatedAt(LocalDateTime.now());
		departmentRepository.save(department);

		User user = new User();
		user.setFirstName("System");
		user.setLastName("Administrator");
		user.setBirthDay(LocalDate.now());
		user.setGender("Male");
		user.setRole("ROLE_ADMIN");
		user.setCreatedAt(LocalDateTime.now());
		user.setStatus("Active");
		user.setUsername("admin");
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode("admin"));
		user.setDepartment(department.getId());

		userRepository.save(user);
		System.out.println(user);
	}
}

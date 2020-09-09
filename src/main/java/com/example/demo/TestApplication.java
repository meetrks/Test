package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class TestApplication {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepository emprep;

	@PostConstruct
	public void initUsers() {

		Role role = new Role("ADMIN");
		roleRepo.save(role);

		role = roleRepo.getRoleByName("ADMIN");

		User user = new User("meetsatya", "edp123", true);
		String encryptPwd = passwordEncoder.encode("edp123");
		user.setPassword(encryptPwd);
		user.getRoles().add(role);
		repository.save(user);

		Employee emp = new Employee();
		emp.setFirstName("SATYENDRA");
		emp.setLastName("KUMAR");
		emp.setEmailId("kumarsatyend@gmail.com");
		emprep.save(emp);

	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/*").allowedOrigins("http://localhost:8084");
	         }
	      };
	   }

}

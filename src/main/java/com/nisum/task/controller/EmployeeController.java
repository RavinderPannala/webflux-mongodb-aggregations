package com.nisum.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.task.entity.Employee;
import com.nisum.task.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public Mono<Employee> saveEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/findById/{empId}")
	public Mono<Employee> getEmployee(@PathVariable String empId) {
		return employeeService.findById(Long.valueOf(empId));
	}

	@GetMapping("/findAllEmployees")
	public Flux<Employee> findAllEmployee() {
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/findAllEmployeesBySalary")
	public Flux<Employee> findAllEmployees() {
		return employeeService.fetchEmployessBySalary();
	}
	
	

}

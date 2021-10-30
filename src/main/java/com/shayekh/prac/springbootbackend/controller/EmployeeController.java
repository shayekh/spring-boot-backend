package com.shayekh.prac.springbootbackend.controller;

import com.shayekh.prac.springbootbackend.entity.Employee;
import com.shayekh.prac.springbootbackend.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(
      EmployeeService employeeService) {
    super();
    this.employeeService = employeeService;
  }

  @PostMapping("v1/employees")
  public ResponseEntity<Employee> saveEmpolyee(@RequestBody Employee employee) {
    return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
  }

  @GetMapping("v1/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("v1/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
  }

  @PutMapping("v1/employees/{id}")
  public ResponseEntity<Employee> updateEmpolyee(@PathVariable long id,
      @RequestBody Employee employee) {
    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),
        HttpStatus.CREATED);
  }
}

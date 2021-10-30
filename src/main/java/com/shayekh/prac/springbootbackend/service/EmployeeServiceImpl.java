package com.shayekh.prac.springbootbackend.service;

import com.shayekh.prac.springbootbackend.entity.Employee;
import com.shayekh.prac.springbootbackend.exception.ResourceNotFoundException;
import com.shayekh.prac.springbootbackend.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(
      EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee getEmployeeById(long id) {
//    Optional<Employee> employee = employeeRepository.findById(id);
//    if (employee.isPresent()) {
//      return employee.get();
//    } else {
//      throw new ResourceNotFoundException("Employee", "Id", id);
//    }

    return employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
  }

  @Override
  public Employee updateEmployee(Employee employee, long id) {
    // given id exists or not
    Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());

    employeeRepository.save(existingEmployee);
    return existingEmployee;

  }
}

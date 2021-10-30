package com.shayekh.prac.springbootbackend.repository;

import com.shayekh.prac.springbootbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

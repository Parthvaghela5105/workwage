package com.tailorshop.workwage.repository;

import com.tailorshop.workwage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

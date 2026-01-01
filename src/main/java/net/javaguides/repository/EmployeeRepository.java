package net.javaguides.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
}


package com.example.demospringboot.repository;

import com.example.demospringboot.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Optional<Department> findByEmail(String email);
}

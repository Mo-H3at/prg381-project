package com.moagi.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moagi.project3.entity.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {
    Students findByEmail(String email);
}

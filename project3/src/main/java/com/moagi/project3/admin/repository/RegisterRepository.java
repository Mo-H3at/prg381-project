package com.moagi.project3.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moagi.project3.admin.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
    
}

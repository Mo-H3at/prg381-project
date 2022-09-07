package com.moagi.project3.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.moagi.project3.dto.StudentRegistrationDto;
import com.moagi.project3.entity.Students;

public interface StudentService extends UserDetailsService {
    Students save(StudentRegistrationDto registrationDto);
}

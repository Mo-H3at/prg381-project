package com.moagi.project3.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moagi.project3.dto.StudentRegistrationDto;
import com.moagi.project3.entity.Role;
import com.moagi.project3.entity.Students;
import com.moagi.project3.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Students save(StudentRegistrationDto registrationDto) {
       Students students = new Students(registrationDto.getStudentName(), registrationDto.getStudentAddress(), registrationDto.getEmail(), 
       passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

       return studentRepository.save(students);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Students students = studentRepository.findByEmail(username);
        if(students == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

      return new org.springframework.security.core.userdetails.User(students.getEmail(), students.getPassword(), mapRolesToAuthorities(students.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    
    

    
}

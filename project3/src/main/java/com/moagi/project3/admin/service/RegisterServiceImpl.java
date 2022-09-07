package com.moagi.project3.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moagi.project3.admin.entity.Register;
import com.moagi.project3.admin.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository registerRepository;
    @Override
    public List<Register> getAllRegister() {
        
        return registerRepository.findAll();
    }

    @Override
    public void saveRegister(Register register) {
        this.registerRepository.save(register);
    }

    @Override
    public Register getRegisterById(Long id) {
        Optional<Register> optional = registerRepository.findById(id);
        Register register = null;
        if(optional.isPresent()) {
            register = optional.get();
        }
        else {
            throw new RuntimeException("Student not found for id :: "+id);
        }

        return register;
    }

    @Override
    public void deleteRegisterById(Long id) {
      this.registerRepository.deleteById(id);
    }

    
}

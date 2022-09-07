package com.moagi.project3.admin.service;

import java.util.List;

import com.moagi.project3.admin.entity.Register;

public interface RegisterService {
    List<Register> getAllRegister();
    void saveRegister(Register register);
    Register getRegisterById(Long id);
    void deleteRegisterById(Long id);
}

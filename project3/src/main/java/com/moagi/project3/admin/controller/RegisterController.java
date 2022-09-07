package com.moagi.project3.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.moagi.project3.admin.entity.Register;
import com.moagi.project3.admin.service.RegisterService;

@Controller
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;

    @GetMapping("/admin")
    public String ViewAdminPage(Model model) {
        model.addAttribute("listRegister", registerService.getAllRegister());
        return "admin";
    }

    @GetMapping("/showNewRegisterForm")
    public String showNewRegisterForm(Model model) {
     Register register = new Register();
     model.addAttribute("register", register);
     return "newLearner";
 }

 @PostMapping("/saveRegister")
 public String saveRegister(@ModelAttribute("register") Register register) {
     registerService.saveRegister(register);
     return "redirect:/admin";
 }

 @GetMapping("/showFormForUpdate/{id}")
public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
 
 Register register = registerService.getRegisterById(id);
 
 model.addAttribute("register", register);
 return "updateLearner";
}

@GetMapping("/deleteRegister/{id}")
public String deleteRegister(@PathVariable (value = "id") long id) {
 
 this.registerService.deleteRegisterById(id);
 return "redirect:/admin";
}

}

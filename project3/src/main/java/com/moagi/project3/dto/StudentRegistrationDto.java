package com.moagi.project3.dto;

public class StudentRegistrationDto {
    private String studentName;
    private String studentAddress;
    private String email;
    private String password;

    public StudentRegistrationDto() {

    }
    
    public StudentRegistrationDto(String studentName, String studentAddress, String email, String password) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.email = email;
        this.password = password;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

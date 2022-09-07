package com.moagi.project3.entity;

import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name =  "student", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Students {
    @Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "studentName")
	private String studentName;
	
	public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Column(name = "studentAddress")
	private String studentAddress;
	
    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    private String email;
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_roles",
			joinColumns = @JoinColumn(
		            name = "student_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	

    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Students(String studentName, String studentAddress, String email, String password,
            Collection<Role> roles) {
        super();
        
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Students() {
    }

    
}

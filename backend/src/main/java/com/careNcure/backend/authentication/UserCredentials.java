package com.careNcure.backend.authentication;

import com.careNcure.backend.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserCredentials{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(unique=true)
    private String email;
    @Column(unique=true,nullable=false)
    private long mobile;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private Role role;
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public long getMobile(){
        return this.mobile;
    }
    public void setMobile(long mobile){
        this.mobile=mobile;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public Role getRole(){
        return this.role;
    }
    public void setRole(Role role){
        this.role=role;
    }
}
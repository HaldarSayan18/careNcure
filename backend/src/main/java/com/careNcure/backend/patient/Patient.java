package com.careNcure.backend.patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private long mobile;
    private String email;
    private  long aadhar;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public long getMobile(){
        return this.mobile;
    }
    public void setMobile(long mobile){
        this.mobile=mobile;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public long getAadhar(){
        return this.aadhar;
    }
    public void setAadhar(long aadhar){
        this.aadhar=aadhar;
    }
}
package com.careNcure.backend.payLoads;

public class PatientDTO{
    private String firstName;
    private String lastName;
    private long mobile;
    private String email;
    private  long aadhar;

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
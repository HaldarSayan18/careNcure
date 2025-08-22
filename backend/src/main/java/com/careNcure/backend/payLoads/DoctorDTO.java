package com.careNcure.backend.payLoads;

public class DoctorDTO {
	private String name;
	private long mobile;
	private String email;
	private int fees;
	private int hospital;
	private String speciality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getmobile() {
		return mobile;
	}
	public void setmobile(long mobile) {
		this.mobile = mobile;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getHospital() {
		return hospital;
	}
	public void setHospital(int hospital) {
		this.hospital = hospital;
	}
	
	
}

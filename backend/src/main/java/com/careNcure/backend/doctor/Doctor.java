package com.careNcure.backend.doctor;

import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.speciality.Speciality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor {
	@Id
	@Column(nullable = false,unique = true)
	private String id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private long mobileNo;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = true)
	private int fees;
	@ManyToOne
	@JoinColumn(name = "hospitalId")
	private Hospital hospital;
	@ManyToOne
	@JoinColumn(name = "speciality")
	private Speciality speciality;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
	
}

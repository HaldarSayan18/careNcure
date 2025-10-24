package com.careNcure.backend.appoinment;

import java.sql.Date;

import com.careNcure.backend.doctor.Doctor;
import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.speciality.Speciality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appoinment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int bookedBy;
	@Column(nullable = false)
	private String patientName;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private long mobileNo;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Speciality speciality;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Hospital hospital;
	@Column(nullable = false)
	private Date date;
	private String purpose;
	public Appoinment( int bookedBy, String patientName, int age, String address, long mobileNo,
			Speciality speciality, Doctor doctor, Hospital hospital, Date date, String purpose) {
		super();
		this.bookedBy = bookedBy;
		this.patientName = patientName;
		this.age = age;
		this.address = address;
		this.mobileNo = mobileNo;
		this.speciality = speciality;
		this.doctor = doctor;
		this.hospital = hospital;
		this.date = date;
		this.purpose = purpose;
	}
	public Appoinment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getbookedBy() {
		return bookedBy;
	}
	public void setbookedBy(int bookedBy) {
		this.bookedBy = bookedBy;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getDate() {
		return date;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}

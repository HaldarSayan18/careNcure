package com.careNcure.backend.speciality;

import com.careNcure.backend.hospital.Hospital;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Speciality {
	@Id
	@Column(nullable = false)
	private String speciality;
	@ManyToOne
	@JoinColumn(name = "hospitalId",nullable = false)
	private Hospital hospital;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}

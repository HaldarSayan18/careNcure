package com.careNcure.backend.entities;

import java.time.LocalDate;

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
	private int ID;
	private String NAME;
	private int AGE;
	private long MOBILE_NO;
	private long AADHAAR_NO;
	private String ADDRESS;
	private LocalDate DATE;
	private String PURPOSE;
	
	public LocalDate getDATE() {
		return DATE;
	}

	public void setDATE(LocalDate dATE) {
		DATE = dATE;
	}

	public String getPURPOSE() {
		return PURPOSE;
	}

	public void setPURPOSE(String pURPOSE) {
		PURPOSE = pURPOSE;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	@ManyToOne
	@JoinColumn(name="DOCTOR_ID")
	private Doctor DOCTOR_ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public long getMOBILE_NO() {
		return MOBILE_NO;
	}

	public void setMOBILE_NO(long mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}

	public long getAADHAAR_NO() {
		return AADHAAR_NO;
	}

	public void setAADHAAR_NO(long aADHAAR_NO) {
		AADHAAR_NO = aADHAAR_NO;
	}

	public Doctor getDOCTOR_ID() {
		return DOCTOR_ID;
	}

	public void setDOCTOR_ID(Doctor dOCTOR_ID) {
		DOCTOR_ID = dOCTOR_ID;
	}
}

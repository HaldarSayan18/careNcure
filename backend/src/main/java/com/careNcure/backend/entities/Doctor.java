package com.careNcure.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String NAME;
	private long MOBILE_NO;
	private String EMAIL_ID;
	private int FEES;
	@ManyToOne
	@JoinColumn(name = "SPECIALITY_ID")
	private Speciality SPECIALITY_ID;
	@Lob
	private byte[] IMAGE;

	public byte[] getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(byte[] iMAGE) {
		IMAGE = iMAGE;
	}

	public int getFEES() {
		return FEES;
	}

	public void setFEES(int fEES) {
		FEES = fEES;
	}

	public Speciality getSPECIALITY_ID() {
		return SPECIALITY_ID;
	}

	public void setSPECIALITY_ID(Speciality sPECIALITY_ID) {
		SPECIALITY_ID = sPECIALITY_ID;
	}

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

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

}

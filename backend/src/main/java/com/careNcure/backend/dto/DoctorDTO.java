package com.careNcure.backend.dto;

import com.careNcure.backend.entities.Speciality;

public class DoctorDTO {
	private String NAME;
    private long MOBILE_NO;
    private String EMAIL_ID;
    private int FEES;
    private int SPECIALITY_ID;
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
	public int getFEES() {
		return FEES;
	}
	public void setFEES(int fEES) {
		FEES = fEES;
	}
	public int getSPECIALITY_ID() {
		return SPECIALITY_ID;
	}
	public void setSPECIALITY_ID(int sPECIALITY_ID) {
		SPECIALITY_ID = sPECIALITY_ID;
	}
}

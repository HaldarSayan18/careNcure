package com.careNcure.backend.dto;

public class DoctorDTO {
	private String NAME;
    private long MOBILE_NO;
    private String EMAIL_ID;
    private int FEES;
    private String SPECIALITY_TYPE;
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
	public String getSPECIALITY_TYPE() {
		return SPECIALITY_TYPE;
	}
	public void setSPECIALITY_TYPE(String SPECIALITY_TYPE) {
		this.SPECIALITY_TYPE = SPECIALITY_TYPE;
	}
}

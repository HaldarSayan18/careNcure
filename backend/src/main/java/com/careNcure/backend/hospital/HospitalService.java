package com.careNcure.backend.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.enums.IndianState;
import com.careNcure.backend.payLoads.HospitalDTO;

@Service
public class HospitalService {
	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Hospital addHospital(HospitalDTO hospitalDTO) {
		Hospital hospital=new Hospital();
		hospital.setName(hospitalDTO.getName());
		hospital.setEmail(hospitalDTO.getEmail());
		hospital.setMobile(hospitalDTO.getMobile());
		hospital.setPin(hospitalDTO.getPin());
		hospital.setState(IndianState.valueOf(hospitalDTO.getState()));
		return hospitalRepo.save(hospital);
	}
	public List<Hospital> getHospitalList(){
		return hospitalRepo.findAll();
	}
}

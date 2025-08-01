package com.careNcure.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careNcure.backend.entities.Speciality;

@Repository
public interface SpecialityRepo extends JpaRepository<Speciality, Integer> {
	public List<Speciality> findByTYPE(String type);
}

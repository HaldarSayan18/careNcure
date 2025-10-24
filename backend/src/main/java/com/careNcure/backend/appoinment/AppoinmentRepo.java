package com.careNcure.backend.appoinment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AppoinmentRepo extends JpaRepository<Appoinment, Integer>{
	List<Appoinment> findByBookedBy(int bookedBy);
}

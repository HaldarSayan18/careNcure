package com.careNcure.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String TYPE;

	// Getters and setters
	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getType() {
		return TYPE;
	}

	public void setType(String type) {
		this.TYPE = type;
	}
}

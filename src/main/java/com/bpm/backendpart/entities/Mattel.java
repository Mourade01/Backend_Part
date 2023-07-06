package com.bpm.backendpart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mattel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ID ;
	float num;
	
}

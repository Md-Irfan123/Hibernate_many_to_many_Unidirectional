package com.jpa.Hibernate_Many_To_Many_Unidirectional.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	
	@Id
	private int id;
	private String name;
	private String address;
	private String ifscCode;
	private int branchCode;
	




	

	
	}

	
	


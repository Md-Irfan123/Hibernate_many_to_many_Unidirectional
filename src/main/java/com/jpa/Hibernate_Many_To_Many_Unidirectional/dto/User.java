package com.jpa.Hibernate_Many_To_Many_Unidirectional.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private long phone;
	private long userAccount;
	
	private LocalDate userDob;
	
	@CreationTimestamp
	private LocalDateTime userCreationDate;
	
	@Transient
	private String userPassword;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Bank> banks;



	public User(String userName, long phone, long userAccount, LocalDate userDob, 
			String userPassword, List<Bank> banks) {
	
		this.userName = userName;
		this.phone = phone;
		this.userAccount = userAccount;
		this.userDob = userDob;
		
		this.userPassword = userPassword;
		this.banks = banks;
	}
	
}

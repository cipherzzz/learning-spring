package com.cipherz.lil.learningspring.data.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


//   FIRST_NAME VARCHAR(64),
//   LAST_NAME VARCHAR(64),
//   EMAIL_ADDRESS VARCHAR(64),
//   ADDRESS VARCHAR(64),
//   COUNTRY VARCHAR(32),
//   STATE VARCHAR(12),
//   PHONE_NUMBER VARCHAR(24)

@Entity
@Table(name="GUEST")
public class Guest {
	
	@Id
	@Column(name="GUEST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private long guestId;

	@Getter @Setter
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Getter @Setter
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Getter @Setter
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Getter @Setter
	@Column(name="COUNTRY")
	private String country;
	
	@Getter @Setter
	@Column(name="STATE")
	private String state;
	
	@Getter @Setter
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
}
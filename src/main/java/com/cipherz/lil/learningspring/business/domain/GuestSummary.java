package com.cipherz.lil.learningspring.business.domain;

import lombok.Getter;
import lombok.Setter;

public class GuestSummary {

	@Getter @Setter
	private long guestId;
	
	@Getter @Setter
	private String firstName;
	
	@Getter @Setter
	private String lastName;
	
	@Getter @Setter
	private String emailAddress;
}
package com.cipherz.lil.learningspring.data.entity;

import javax.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

// CREATE TABLE RESERVATION(
//   RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
//   ROOM_ID BIGINT NOT NULL,
//   GUEST_ID BIGINT NOT NULL,
//   RES_DATE DATE
// );

@Entity
@Table(name="RESERVATION")
public class Reservation {
	
	@Id
	@Column(name="RESERVATION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private long reservationId;
	
	@Getter @Setter
	@Column(name="ROOM_ID")
	private long roomId;
	
	@Getter @Setter
	@Column(name="GUEST_ID")
	private long guestId;
	
	@Getter @Setter
	@Column(name="RES_DATE")
	private Date reservationDate;
}
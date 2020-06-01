package com.cipherz.lil.learningspring.data.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Class Room
 */
 @Entity
 @Table(name="ROOM")
public class Room {
	
	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private long roomId;
	
	@Getter @Setter
	@Column(name="NAME")
	private String roomName;
	
	@Getter @Setter
	@Column(name="ROOM_NUMBER")
	private String roomNumber;
	
	@Getter @Setter
	@Column(name="BED_INFO")
	private String bedInfo;
	
}
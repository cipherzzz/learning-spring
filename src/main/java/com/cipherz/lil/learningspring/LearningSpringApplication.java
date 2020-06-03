package com.cipherz.lil.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.cipherz.lil.learningspring.data.repository.RoomRepository;
import com.cipherz.lil.learningspring.data.entity.Room;

import com.cipherz.lil.learningspring.data.repository.GuestRepository;
import com.cipherz.lil.learningspring.data.entity.Guest;

import com.cipherz.lil.learningspring.data.repository.ReservationRepository;
import com.cipherz.lil.learningspring.data.entity.Reservation;


@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringApplication.class, args);
	}

}

package com.cipherz.lil.learningspring.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

import com.cipherz.lil.learningspring.business.service.ReservationService;
import com.cipherz.lil.learningspring.business.domain.RoomReservation;

@RestController
@RequestMapping("/api/reservation")
public class RoomReservationWebServiceController {
	
	private final ReservationService reservationService;
	
	@Autowired
	public RoomReservationWebServiceController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString) {
		Date date = DateUtil.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
	}
}
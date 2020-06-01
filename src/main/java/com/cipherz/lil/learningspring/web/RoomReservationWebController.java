package com.cipherz.lil.learningspring.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

import com.cipherz.lil.learningspring.business.service.ReservationService;
import com.cipherz.lil.learningspring.business.domain.RoomReservation;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
	
	private final ReservationService reservationService;
	
	@Autowired
	public RoomReservationWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {
		Date date = DateUtil.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "reservations";
	}
}
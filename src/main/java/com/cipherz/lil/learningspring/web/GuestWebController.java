package com.cipherz.lil.learningspring.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

import com.cipherz.lil.learningspring.business.service.GuestService;
import com.cipherz.lil.learningspring.business.domain.GuestSummary;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
	
	private final GuestService guestService;
	
	@Autowired
	public GuestWebController(GuestService guestService) {
		this.guestService = guestService;
	}
	
	@GetMapping
	public String getGuests(Model model) {
		List<GuestSummary> guests = guestService.getGuests();
		model.addAttribute("guests", guests);
		return "guests";
	}
}
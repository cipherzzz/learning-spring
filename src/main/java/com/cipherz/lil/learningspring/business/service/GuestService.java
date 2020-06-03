package com.cipherz.lil.learningspring.business.service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cipherz.lil.learningspring.data.repository.*;
import com.cipherz.lil.learningspring.data.entity.*;
import com.cipherz.lil.learningspring.business.domain.GuestSummary;

@Service
public class GuestService {

	private final GuestRepository guestRepository;
	
	@Autowired
	public GuestService(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	public List<GuestSummary> getGuests() {
		Iterable<Guest> guests = this.guestRepository.findAll();
		List<GuestSummary> guestSummaries = new ArrayList<GuestSummary>();
		guests.forEach(guest -> {
			GuestSummary guestSummary = new GuestSummary();
			guestSummary.setGuestId(guest.getGuestId());
			guestSummary.setFirstName(guest.getFirstName());
			guestSummary.setLastName(guest.getLastName());
			guestSummary.setEmailAddress(guest.getEmailAddress());
			guestSummaries.add(guestSummary);
		});
		
		
		guestSummaries.sort(new Comparator<GuestSummary>() {
            @Override
            public int compare(GuestSummary o1, GuestSummary o2) {
                if (o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
		
		return guestSummaries;
	}
	
}
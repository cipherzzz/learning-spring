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
import com.cipherz.lil.learningspring.business.domain.RoomReservation;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService( RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(Date date) {
		Map<Long, RoomReservation> roomReservationMap = new HashMap();
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getRoomId(), roomReservation);
		});
		
		Iterable<Reservation> reservations = reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getFirstName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		for(Long id: roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		
		roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName() == o2.getRoomName()){
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
		
		return roomReservations;
	}
	
}
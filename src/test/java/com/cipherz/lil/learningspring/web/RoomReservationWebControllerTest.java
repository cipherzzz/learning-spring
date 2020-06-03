package com.cipherz.lil.learningspring.web;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cipherz.lil.learningspring.business.service.ReservationService;
import com.cipherz.lil.learningspring.business.domain.RoomReservation;
import com.cipherz.lil.learningspring.web.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTest {
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getReservations() throws Exception {
		String dateString = "2020-01-01";
		Date date = DateUtil.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		
		RoomReservation roomReservation = new RoomReservation();
		roomReservation.setLastName("Unit");
		roomReservation.setFirstName("Jay");
		roomReservation.setDate(date);
		roomReservation.setGuestId(1);
		roomReservation.setRoomId(100);
		roomReservation.setRoomName("JUnit Name");
		roomReservation.setRoomNumber("J1");
		
		roomReservations.add(roomReservation);
		
		given(reservationService.getRoomReservationsForDate(date)).willReturn(roomReservations);
		
		this.mockMvc.perform(get("/reservations?date=2020-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Unit, Jay")));
	}
}
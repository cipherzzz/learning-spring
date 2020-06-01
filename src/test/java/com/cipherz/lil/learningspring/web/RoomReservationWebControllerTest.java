package com.cipherz.lil.learningspring.web;

import java.util.Date;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junity4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cipherz.learningspring.lil.business.service.ReservationService;
import com.cipherz.learningspring.lil.business.domain.RoomReservation;
import com.cipherz.learningspring.lil.web.DateUtil;

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
		List<RoomReservation> roomReservations = new ArrayList<>();
		
		RoomReservation roomReservation = new RoomReservation();
		roomReservation.setLastName("Unit");
		roomReservation.setFirstName("Jay");
		roomReservation.setDate(date);
	}
}
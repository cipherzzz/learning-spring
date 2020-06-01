package com.cipherz.lil.learningspring.data.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cipherz.lil.learningspring.data.entity.Reservation;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
    
}
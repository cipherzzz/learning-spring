package com.cipherz.lil.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cipherz.lil.learningspring.data.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {
    
}
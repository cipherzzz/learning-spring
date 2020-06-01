package com.cipherz.lil.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cipherz.lil.learningspring.data.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
    
}
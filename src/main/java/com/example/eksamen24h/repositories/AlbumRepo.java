package com.example.eksamen24h.repositories;
import com.example.eksamen24h.model.Album;
import com.example.eksamen24h.model.Availability;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepo extends JpaRepository<Album, Integer> {

    List<Album> findAllByAvailability(Availability availability);


}

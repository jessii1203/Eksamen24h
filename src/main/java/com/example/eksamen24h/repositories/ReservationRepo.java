package com.example.eksamen24h.repositories;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {


}



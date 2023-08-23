package com.example.eksamen24h.service;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.model.ReservationStatus;
import com.example.eksamen24h.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    public Reservation postData(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.TILMELDT);
        return reservationRepo.save(reservation);
    }



    public List<Reservation> allData() {
        return reservationRepo.findAll();
    }

    public ResponseEntity<Reservation> updateData(int id, Reservation reservation){
        Optional<Reservation> modelOptional = reservationRepo.findById(id);

        if (modelOptional.isPresent()) {
            reservationRepo.save(reservation);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Reservation> deleteData(int id){
        Optional<Reservation> modelOptional = reservationRepo.findById(id);

        if (modelOptional.isPresent()) {
            reservationRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

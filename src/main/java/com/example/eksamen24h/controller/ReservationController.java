package com.example.eksamen24h.controller;

import com.example.eksamen24h.model.Album;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.model.ReservationStatus;
import com.example.eksamen24h.service.AlbumService;
import com.example.eksamen24h.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //for at vi kan sende requets hertil med javascript
public class ReservationController {

    @Autowired
    ReservationService service;


    @PostMapping("reservation/postData")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation postData(@RequestBody Reservation reservation) {
        return service.postData(reservation);
    }

    @GetMapping("reservation/getAllData")
    public List<Reservation> allData() {
        return service.allData();
    }

    @PutMapping("reservation/updateData/{id}")
    public ResponseEntity<Reservation> updateData(@PathVariable int id, @RequestBody Reservation reservation) {
        return service.updateData(id, reservation);
    }



    @DeleteMapping("reservation/deleteData/{id}")
    public ResponseEntity<Reservation> deleteData(@PathVariable int id) {
        return service.deleteData(id);
    }


}

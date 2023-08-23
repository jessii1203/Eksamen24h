package com.example.eksamen24h.service;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Album;
import com.example.eksamen24h.model.Availability;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.model.ReservationStatus;
import com.example.eksamen24h.repositories.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepo albumRepo;

    public Album postData(Album album) {
        return albumRepo.save(album);
    }


    public List<Album> allData() {
        return albumRepo.findAll();
    }

    public ResponseEntity<Album> updateData(int id, Album album){
        Optional<Album> modelOptional = albumRepo.findById(id);

        if (modelOptional.isPresent()) {
            albumRepo.save(album);
            return new ResponseEntity<>(album, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Album> deleteData(int id){
        Optional<Album> modelOptional = albumRepo.findById(id);

        if (modelOptional.isPresent()) {
            albumRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Album> getByAvailability(Availability availability) {
        return albumRepo.findAllByAvailability(availability);
    }
}

package com.example.eksamen24h.controller;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Album;
import com.example.eksamen24h.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //for at vi kan sende requets hertil med javascript
public class AlbumController {

    @Autowired
    AlbumService service;

    @PostMapping("album/postData")
    @ResponseStatus(HttpStatus.CREATED)
    public Album postData(@RequestBody Album album) {
        return service.postData(album);
    }

    @GetMapping("album/getAllData")
    public List<Album> allData() {
        return service.allData();
    }

    @PutMapping("album/updateData/{id}")
    public ResponseEntity<Album> updateData(@PathVariable int id, @RequestBody Album album) {
        return service.updateData(id, album);
    }

    @DeleteMapping("album/deleteData/{id}")
    public ResponseEntity<Album> deleteData(@PathVariable int id) {
        return service.deleteData(id);
    }

}

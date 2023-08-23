package com.example.eksamen24h.config;

import com.example.eksamen24h.model.*;
import com.example.eksamen24h.repositories.AlbumRepo;
import com.example.eksamen24h.repositories.CustomerRepo;
import com.example.eksamen24h.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    AlbumRepo albumRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public void run(String... args) throws Exception {

        Album album = new Album();
        album.setArtist("Britney Spears");
        album.setTitle("One more time");
        album.setGenre("Pop");
        album.setAvailability(Availability.AVAILABLE);
        albumRepo.save(album);

        Customer customer = new Customer();
        customer.setName("Jessica Meyer");
        customer.setEmail("Jess@gmail.com");
        customer.setPhoneNumber("000000");
        customerRepo.save(customer);

        Reservation reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.TILMELDT);
        reservation.setCustomer(customer);
        reservation.setAlbum(album);
        reservationRepo.save(reservation);

        Album album2 = new Album();
        album2.setArtist("Taylor Swift");
        album2.setTitle("Blank space");
        album2.setGenre("Pop");
        album2.setAvailability(Availability.UNAVAILABLE);
        albumRepo.save(album2);

        Customer customer2 = new Customer();
        customer2.setName("James Bond");
        customer2.setEmail("Bond@gmail.com");
        customer2.setPhoneNumber("000221");
        customerRepo.save(customer2);

        Reservation reservation2 = new Reservation();
        reservation2.setReservationStatus(ReservationStatus.TILMELDT);
        reservation2.setCustomer(customer2);
        reservation2.setAlbum(album2);
        reservationRepo.save(reservation);


    }
}

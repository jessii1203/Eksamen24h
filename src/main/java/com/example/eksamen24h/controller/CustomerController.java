package com.example.eksamen24h.controller;

import com.example.eksamen24h.model.Customer;
import com.example.eksamen24h.model.Reservation;
import com.example.eksamen24h.repositories.CustomerRepo;
import com.example.eksamen24h.service.CustomerService;
import com.example.eksamen24h.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //for at vi kan sende requets hertil med javascript
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("customer/postData")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postData(@RequestBody Customer customer) {
        return service.postData(customer);
    }

    @GetMapping("customer/getAllData")
    public List<Customer> allData() {
        return service.allData();
    }

    @PutMapping("customer/updateData/{id}")
    public ResponseEntity<Customer> updateData(@PathVariable int id, @RequestBody Customer customer) {
        return service.updateData(id, customer);
    }
    @DeleteMapping("customer/deleteData/{id}")
    public ResponseEntity<Customer> deleteData(@PathVariable int id) {
        return service.deleteData(id);
    }

}

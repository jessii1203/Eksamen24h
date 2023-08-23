package com.example.eksamen24h.service;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Customer;
import com.example.eksamen24h.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    public Customer postData(Customer customer) {
        return customerRepo.save(customer);
    }


    public List<Customer> allData() {
        return customerRepo.findAll();
    }

    public ResponseEntity<Customer> updateData(int id, Customer customer){
        Optional<Customer> modelOptional = customerRepo.findById(id);

        if (modelOptional.isPresent()) {
            customerRepo.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Customer> deleteData(int id){

        Optional<Customer> modelOptional = customerRepo.findById(id);

        if (modelOptional.isPresent()) {
            customerRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

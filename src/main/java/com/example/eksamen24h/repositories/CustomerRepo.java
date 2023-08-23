package com.example.eksamen24h.repositories;

import ch.qos.logback.core.model.Model;
import com.example.eksamen24h.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}

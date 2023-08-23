package com.example.eksamen24h.repositories;
import com.example.eksamen24h.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album, Integer> {
}

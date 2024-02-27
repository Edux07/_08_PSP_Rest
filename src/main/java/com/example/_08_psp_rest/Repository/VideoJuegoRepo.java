package com.example._08_psp_rest.Repository;

import com.example._08_psp_rest.Entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoJuegoRepo extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByCompania(String compania);
}


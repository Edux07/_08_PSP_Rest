package com.example._08_psp_rest.Repository;

import com.example._08_psp_rest.Entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoJuegoRepo extends JpaRepository<Videojuego, Long> {
    Videojuego findByNombre(String nombre);
}


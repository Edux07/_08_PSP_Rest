package com.example._08_psp_rest.Controlador;

import com.example._08_psp_rest.Entity.Videojuego;
import com.example._08_psp_rest.Repository.VideoJuegoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api")
public class Controlador {
    @Autowired
    private VideoJuegoRepo repoVideojuegos;

    @PostMapping("/videojuego")
    public ResponseEntity<String> crearVideojuego(@RequestBody Videojuego videojuego) {
        repoVideojuegos.save(videojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body("El videojuego se ha creado");
    }

    @DeleteMapping("/videojuego/{id}")
    public ResponseEntity<String> borrarVideojuego(@PathVariable Long id) {
        repoVideojuegos.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("El videojuego se ha borrado ");
    }

    @PutMapping("/videojuego/{id}")
    public ResponseEntity<String> modificarVideojuego(@PathVariable Long id, @RequestBody Videojuego videojuego) {
        videojuego.setId(id);
        repoVideojuegos.save(videojuego);
        return ResponseEntity.status(HttpStatus.OK).body("El videojuego se ha modificado");
    }

    @GetMapping("/videojuego/{id}")
    public ResponseEntity<Videojuego> obtenerVideojuego(@PathVariable Long id) {
        Optional<Videojuego> videojuego = repoVideojuegos.findById(id);
        return videojuego.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/videojuegos/{id}")
    public ResponseEntity<Object> listarVideojuegos() {
        List<Videojuego> videojuegos = repoVideojuegos.findAll();
        return ResponseEntity.ok(videojuegos);
    }

    @GetMapping("/porCompania/{compania}")
    public ResponseEntity<Object> listarVideojuegosPorCompania(@PathVariable String compania) {
        List<Videojuego> videojuegos = repoVideojuegos.findByCompania(compania);
        return ResponseEntity.ok(videojuegos);
    }
}


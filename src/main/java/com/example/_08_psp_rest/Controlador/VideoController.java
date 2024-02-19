package com.example._08_psp_rest.Controlador;

import com.example._08_psp_rest.Entity.Videojuego;
import com.example._08_psp_rest.Repository.VideoJuegoRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videojuegos")
public class VideoController {
    @Autowired
    private VideoJuegoRepo videojuegoRepository;

    @PostMapping
    public ResponseEntity<Videojuego> crearVideojuego(@RequestBody Videojuego videojuego) {
        if (videojuego.getNombre() == null || videojuego.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (videojuegoRepository.findByNombre(videojuego.getNombre()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Videojuego nuevoVideojuego = videojuegoRepository.save(videojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVideojuego);
    }
        @GetMapping
        public List<Videojuego> ListarVideojuegos() {
        return videojuegoRepository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Videojuego> getVideojuego(@PathVariable long id) {
            Videojuego videojuego = videojuegoRepository.findById(id).orElse(null);
            if (videojuego == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(videojuego);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Videojuego> actualizarVideojuego(@PathVariable long id, @RequestBody Videojuego videojuego) {
            Videojuego videojuegoEncontrado = videojuegoRepository.findById(id).orElse(null);
            if (videojuegoEncontrado == null) {
                return ResponseEntity.notFound().build();
            }
            videojuegoEncontrado.setNombre(videojuego.getNombre());
            videojuegoEncontrado.setCompañía(videojuego.getCompañía());
            videojuegoEncontrado.setNota(videojuego.getNota());
            videojuegoRepository.save(videojuegoEncontrado);
            return ResponseEntity.ok(videojuegoEncontrado);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable long id) {
            Videojuego videojuego = videojuegoRepository.findById(id).orElse(null);
            if (videojuego == null) {
                return ResponseEntity.notFound().build();
            }
            videojuegoRepository.delete(videojuego);
            return ResponseEntity.noContent().build();
        }
        @GetMapping("/buscar")
        public ResponseEntity<List<Videojuego>> buscarVideojuego(@RequestParam String nombre) {
List<Videojuego> videojuegos = (List<Videojuego>) videojuegoRepository.findByNombre(nombre);
            if (videojuegos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(videojuegos);
        }


}

package com.example._08_psp_rest.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuego")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( unique = true , name = "nombre")
    private String nombre;
    @Column(name = "compañía")
    private String compañía;
    @Column(name = "nota")
    private int nota;

    public Videojuego() {
    }

    public Videojuego(String nombre, String compañía, int nota) {
        this.nombre = nombre;
        this.compañía = compañía;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompañía() {
        return compañía;
    }

    public void setCompañía(String compañía) {
        this.compañía = compañía;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compañía='" + compañía + '\'' +
                ", nota=" + nota +
                '}';
    }
}

package com.veterinaria.proyecto_veterinaria.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Debes el nombre de la categoria")
    @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(@NotEmpty String nombre) {
        this.nombre = nombre;
    }

    public Categoria() {
    }
    
} 

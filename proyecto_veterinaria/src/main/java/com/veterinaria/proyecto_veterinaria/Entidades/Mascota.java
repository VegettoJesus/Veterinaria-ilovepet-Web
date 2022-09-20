package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String especie;

    @NotEmpty
    private String raza;

    @NotNull
    private Integer edad;

    @NotNull
    private float estatura;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_Registro;

    @NotEmpty
    private String Sexo;

    @NotEmpty
    private String color;

    @NotNull
    private float peso;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public Date getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(Date fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Mascota(Long id, @NotEmpty String nombre, @NotEmpty String especie, @NotEmpty String raza,
            @NotNull Integer edad, @NotNull float estatura, @NotNull Date fecha_Registro, @NotEmpty String sexo,
            @NotEmpty String color, @NotNull float peso, Propietario propietario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estatura = estatura;
        this.fecha_Registro = fecha_Registro;
        Sexo = sexo;
        this.color = color;
        this.peso = peso;
        this.propietario = propietario;
    }

    public Mascota(@NotEmpty String nombre, @NotEmpty String especie, @NotEmpty String raza, @NotNull Integer edad,
            @NotNull float estatura, @NotNull Date fecha_Registro, @NotEmpty String sexo, @NotEmpty String color,
            @NotNull float peso, Propietario propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estatura = estatura;
        this.fecha_Registro = fecha_Registro;
        Sexo = sexo;
        this.color = color;
        this.peso = peso;
        this.propietario = propietario;
    }

    public Mascota() {
    }

    

}

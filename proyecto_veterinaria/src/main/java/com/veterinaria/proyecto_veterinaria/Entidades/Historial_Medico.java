package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "historial_medico")
public class Historial_Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_registro;

    @NotEmpty
    private String observaciones;
    
    @OneToMany
    @JoinColumn(name = "id_Historial_Medico")
    private List<Mascota> mascota;
   
    @OneToMany
    @JoinColumn(name = "id_Historial_Medico")
    private List<Citas> citas;
}

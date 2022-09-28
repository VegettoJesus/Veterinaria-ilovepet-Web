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
    @JoinColumn(name = "id_HistorialMedico")
    private List<Mascota> mascota;
   
    @OneToMany
    @JoinColumn(name = "id_HistorialMedico")
    private List<Citas> citas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Mascota> getMascota() {
        return mascota;
    }

    public void setMascota(List<Mascota> mascota) {
        this.mascota = mascota;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }

    public Historial_Medico(Long id, @NotNull Date fecha_registro, @NotEmpty String observaciones,
            List<Mascota> mascota, List<Citas> citas) {
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.observaciones = observaciones;
        this.mascota = mascota;
        this.citas = citas;
    }

    public Historial_Medico(@NotNull Date fecha_registro, @NotEmpty String observaciones, List<Mascota> mascota,
            List<Citas> citas) {
        this.fecha_registro = fecha_registro;
        this.observaciones = observaciones;
        this.mascota = mascota;
        this.citas = citas;
    }

    public Historial_Medico() {
    }
}

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

import com.veterinaria.proyecto_veterinaria.Entidad_usuario.Empleado_Login;

@Entity
@Table(name = "cita")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado_Login empleado;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_registro;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_cita;

    @NotEmpty
    private String hora_cita_Inicia;

    @NotEmpty
    private String hora_cita_Finaliza;

    @NotEmpty
    private String Estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado_Login getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado_Login empleado) {
        this.empleado = empleado;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora_cita_Inicia() {
        return hora_cita_Inicia;
    }

    public void setHora_cita_Inicia(String hora_cita_Inicia) {
        this.hora_cita_Inicia = hora_cita_Inicia;
    }

    public String getHora_cita_Finaliza() {
        return hora_cita_Finaliza;
    }

    public void setHora_cita_Finaliza(String hora_cita_Finaliza) {
        this.hora_cita_Finaliza = hora_cita_Finaliza;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }


    public Citas(Long id, Empleado_Login empleado, Mascota mascota, Servicio servicio, @NotNull Date fecha_registro,
            @NotNull Date fecha_cita, @NotEmpty String hora_cita_Inicia, @NotEmpty String hora_cita_Finaliza,
            @NotEmpty String estado) {
        this.id = id;
        this.empleado = empleado;
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha_registro = fecha_registro;
        this.fecha_cita = fecha_cita;
        this.hora_cita_Inicia = hora_cita_Inicia;
        this.hora_cita_Finaliza = hora_cita_Finaliza;
        Estado = estado;
    }

    public Citas(Empleado_Login empleado, Mascota mascota, Servicio servicio, @NotNull Date fecha_registro,
            @NotNull Date fecha_cita, @NotEmpty String hora_cita_Inicia, @NotEmpty String hora_cita_Finaliza,
            @NotEmpty String estado) {
        this.empleado = empleado;
        this.mascota = mascota;
        this.servicio = servicio;
        this.fecha_registro = fecha_registro;
        this.fecha_cita = fecha_cita;
        this.hora_cita_Inicia = hora_cita_Inicia;
        this.hora_cita_Finaliza = hora_cita_Finaliza;
        Estado = estado;
    }

    public Citas() {
    }

    @Override
    public String toString() {
        return "" + servicio + "";
    }

}

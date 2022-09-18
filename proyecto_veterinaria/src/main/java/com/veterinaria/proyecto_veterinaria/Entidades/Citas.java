package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "reporte",
        joinColumns = @JoinColumn(name="id_cita",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_historial_medico",referencedColumnName = "id")
    )
    private Collection<Historial_Medico> fecha_registro;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_cita;

    @NotEmpty
    private String hora_cita;

    @NotEmpty
    private String Estado;

    @NotEmpty
    private String descripcion;

}

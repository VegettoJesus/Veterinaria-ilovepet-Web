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
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotEmpty
    private String precio;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_Vencimiento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_Registro;

    @NotEmpty
    private String marca;

    @NotEmpty
    private String nombre_Proveedor;

    @NotNull
    private Long ruc_proveedor;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado_Login empleado;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    

}

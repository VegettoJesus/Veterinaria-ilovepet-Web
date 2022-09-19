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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Debes especificar el código")
    @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50")
    private String codigo;

    @NotEmpty(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String nombre;

    @NotEmpty
    private String descripcion;
    
    @NotEmpty(message = "Debes especificar el precio")
    @Min(value = 0, message = "El precio mínimo es 0")
    private Float precio;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_Vencimiento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @NotNull
    private Date fecha_Registro;

    @NotEmpty(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String marca;

    @NotEmpty(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
    private String nombre_Proveedor;

    @NotNull(message = "Debes especificar tu numero RUC")
    @Size(min = 11, max = 11, message = "Ingrese rumero RUC de 11 digitos")
    private Long ruc_proveedor;

    @NotNull(message = "Debes especificar el stock")
    @Min(value = 0, message = "La existencia mínima es 0")
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getFecha_Vencimiento() {
        return fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(Date fecha_Vencimiento) {
        this.fecha_Vencimiento = fecha_Vencimiento;
    }

    public Date getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(Date fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre_Proveedor() {
        return nombre_Proveedor;
    }

    public void setNombre_Proveedor(String nombre_Proveedor) {
        this.nombre_Proveedor = nombre_Proveedor;
    }

    public Long getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(Long ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto(Long id, @NotEmpty String codigo, @NotEmpty String nombre, @NotEmpty String descripcion,
            @NotEmpty Float precio, @NotNull Date fecha_Vencimiento, @NotNull Date fecha_Registro,
            @NotEmpty String marca, @NotEmpty String nombre_Proveedor, @NotNull Long ruc_proveedor, @NotNull Long stock,
            Categoria categoria) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.fecha_Registro = fecha_Registro;
        this.marca = marca;
        this.nombre_Proveedor = nombre_Proveedor;
        this.ruc_proveedor = ruc_proveedor;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(@NotEmpty String codigo, @NotEmpty String nombre, @NotEmpty String descripcion,
            @NotEmpty Float precio, @NotNull Date fecha_Vencimiento, @NotNull Date fecha_Registro,
            @NotEmpty String marca, @NotEmpty String nombre_Proveedor, @NotNull Long ruc_proveedor, @NotNull Long stock,
            Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_Vencimiento = fecha_Vencimiento;
        this.fecha_Registro = fecha_Registro;
        this.marca = marca;
        this.nombre_Proveedor = nombre_Proveedor;
        this.ruc_proveedor = ruc_proveedor;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(@NotEmpty(message = "Debes especificar el código") @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50") String codigo) {
        this.codigo = codigo;
    }

    public Producto() {
    }
    
    public boolean sinStock(){
        return this.stock <= 0;
    }
}

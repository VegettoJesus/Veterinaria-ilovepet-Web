package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicioService {
    public List<Servicio> findAll();
    public Page<Servicio> findAll(Pageable pageable);
    public void save(Servicio servicio);
    public Servicio findOne(long id);
    public void delete(Long id);
}

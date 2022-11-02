package com.veterinaria.proyecto_veterinaria.Entidades;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CitasService {
    public List<Citas> findAll();
    public Page<Citas> findAll(Pageable pageable);
    public void save(Citas citas);
    public Citas findOne(long id);
    public void delete(Long id);
}

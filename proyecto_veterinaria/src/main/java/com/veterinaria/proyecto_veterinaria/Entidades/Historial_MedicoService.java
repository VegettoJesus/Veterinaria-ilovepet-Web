package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Historial_MedicoService {
    public List<Historial_Medico> findAll();
    public Page<Historial_Medico> findAll(Pageable pageable);
    public void save(Historial_Medico historial_Medico);
    public Historial_Medico findOne(long id);
}

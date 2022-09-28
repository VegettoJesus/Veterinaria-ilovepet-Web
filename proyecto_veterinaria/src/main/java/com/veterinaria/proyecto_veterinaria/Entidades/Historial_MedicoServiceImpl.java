package com.veterinaria.proyecto_veterinaria.Entidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Historial_MedicoServiceImpl implements Historial_MedicoService{

    @Autowired
    private Historial_MedicoRepository historial_MedicoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Historial_Medico> findAll() {
        return (List<Historial_Medico>) historial_MedicoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Historial_Medico> findAll(Pageable pageable) {
        return historial_MedicoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Historial_Medico historial_Medico) {
        historial_MedicoRepository.save(historial_Medico);
        
    }

    @Override
    @Transactional
    public Historial_Medico findOne(long id) {
        return historial_MedicoRepository.findById(id).orElse(null);
    }
    
}

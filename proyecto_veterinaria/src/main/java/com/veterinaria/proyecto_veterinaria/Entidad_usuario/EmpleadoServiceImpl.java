package com.veterinaria.proyecto_veterinaria.Entidad_usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements Empleado_Service{

    @Autowired
    private Empleado_Repositoriy empleado_Repositoriy;


    @Override
    @Transactional(readOnly = true)
    public List<Empleado_Login> findAll() {
        return (List<Empleado_Login>) empleado_Repositoriy.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Empleado_Login> findAll(Pageable pageable) {
        return empleado_Repositoriy.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Empleado_Login empleado_Login) {
        empleado_Repositoriy.save(empleado_Login);
        
    }

    @Override
    @Transactional
    public Empleado_Login findOne(long id) {
        return empleado_Repositoriy.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        empleado_Repositoriy.deleteById(id);
        
    }
    
}

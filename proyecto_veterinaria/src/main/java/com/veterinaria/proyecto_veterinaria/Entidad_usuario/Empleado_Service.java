package com.veterinaria.proyecto_veterinaria.Entidad_usuario;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Empleado_Service {
    public List<Empleado_Login> findAll();
    public Page<Empleado_Login> findAll(Pageable pageable);
    public void save(Empleado_Login empleado_Login);
    public Empleado_Login findOne(long id);
    public void delete(Long id);
}

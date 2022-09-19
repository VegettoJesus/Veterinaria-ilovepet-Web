package com.veterinaria.proyecto_veterinaria.Entidad_usuario;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.veterinaria.proyecto_veterinaria.Entidades.Rol;
import com.veterinaria.proyecto_veterinaria.Entidades.RolService;
import com.veterinaria.proyecto_veterinaria.paginacion.PageRender;


@Controller
public class EmpleadoController {
     
    @Autowired
    private Empleado_Service empleado_Service;

    @Autowired
    private RolService rolservice;

    @GetMapping("/detalleEmpleado/{id}")
    public String verDetallesDelEmpleado(@PathVariable(value = "id") Long id, Map<String, Object> modelo,RedirectAttributes flash){
        Empleado_Login empleado = empleado_Service.findOne(id);
        if(empleado == null){
            flash.addFlashAttribute("error","El empleado no existe en la base de datos");
            return "redirect:/gestionAdmin";
        }
        List<Rol> listaRol = rolservice.findAll();
        modelo.put("listaRol",listaRol);
        modelo.put("empleado", empleado);
        modelo.put("titulo","Detalles del empleado " + empleado.getNombre()+ " " + empleado.getApellido());
        return "detalleEmpleado";
    }

    @GetMapping({"/","/gestionAdmin",""})
    public String listarEmpleados(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,7);
        Page<Empleado_Login> empleados = empleado_Service.findAll(pageRequest);
        PageRender<Empleado_Login> pageRender = new PageRender<>("/gestionAdmin",empleados);
        model.addAttribute("empleados",empleados);
        model.addAttribute("page",pageRender);
        return "gestionAdmin";
        
    }
 
    @GetMapping("/formularioEmpleado")
    public String RegistrarEmpleado(Map<String,Object> modelo){
        Empleado_Login empleado = new Empleado_Login();
        modelo.put("rol",rolservice.findAll());
        modelo.put("empleado", empleado);
        modelo.put("titulo","Registrar Empleado");
        return "formularioEmpleado";
    }

    @PostMapping("/formularioEmpleado")
    public String guardarEmpleado(@Valid Empleado_Login empleado,BindingResult result,Model modelo, RedirectAttributes flash, SessionStatus status){  
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registrar Empleado");
            return "formularioEmpleado";
        }
        String mensaje = (empleado.getId() != null) ? "El empleado ha sido editado con exito" : "El empleado ha sido registrado con exito";
        empleado_Service.save(empleado);
        status.setComplete();
        flash.addFlashAttribute("success",mensaje);
        return "redirect:/gestionAdmin";
    }

    @GetMapping("/formularioEmpleado/{id}")
    public String editarEmpleado(@PathVariable(value = "id") Long id, Map<String,Object> modelo, RedirectAttributes flash){
        Empleado_Login empleado = null;
        if(id > 0){
            empleado = empleado_Service.findOne(id);
            if(empleado == null){
                flash.addFlashAttribute("error","El ID del empleado no existe en la base de datos");
                return "redirect:/gestionAdmin";
            }
        }else{
            flash.addFlashAttribute("error","El ID del empleado no puede ser cero");
            return "redirect:/gestionAdmin";
        }
        modelo.put("rol",rolservice.findAll());
        modelo.put("empleado",empleado);
        modelo.put("titulo","Modificar Empleado");
        return "formularioEmpleado";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            empleado_Service.delete(id);
            flash.addFlashAttribute("success","Cliente eliminado con exito");
        }
        return "redirect:/gestionAdmin";
    }

}

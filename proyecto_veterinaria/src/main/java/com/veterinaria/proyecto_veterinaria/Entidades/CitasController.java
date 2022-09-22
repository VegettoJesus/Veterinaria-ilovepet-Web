package com.veterinaria.proyecto_veterinaria.Entidades;

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

import com.veterinaria.proyecto_veterinaria.Entidad_usuario.Empleado_Service;
import com.veterinaria.proyecto_veterinaria.paginacion.PageRender;

@Controller
public class CitasController {
    
    @Autowired
    private CitasService citasService;

    @Autowired
    private Empleado_Service empleado_Service;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("gestionCitas")
    public String listarCitas(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,7);
        Page<Citas> citas = citasService.findAll(pageRequest);
        PageRender<Citas> pageRender = new PageRender<>("/gestionCitas",citas);
        model.addAttribute("citas",citas);
        model.addAttribute("page",pageRender);
        return "gestionCitas";
    }

    @GetMapping("/formularioCitas")
    public String RegistrarCitas(Map<String,Object> modelo){
        Citas citas = new Citas();
        modelo.put("empleado",empleado_Service.findAll());
        modelo.put("mascota",mascotaService.findAll());
        modelo.put("servicio",servicioService.findAll());
        modelo.put("citas", citas);
        modelo.put("titulo","Registrar Cita");
        return "formularioCitas";
    }

    @PostMapping("/formularioCitas")
    public String guardarCitas(@Valid Citas citas,BindingResult result,Model modelo, RedirectAttributes flash, SessionStatus status){  
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registrar Cita");
            return "formularioCitas";
        }
        String mensaje = (citas.getId() != null) ? "La cita ha sido editado con exito" : "La cita ha sido registrado con exito";
        citasService.save(citas);
        status.setComplete();
        flash.addFlashAttribute("success",mensaje);
        return "redirect:/gestionCitas";
    }

    @GetMapping("/formularioCitas/{id}")
    public String editarCitas(@PathVariable(value = "id") Long id, Map<String,Object> modelo, RedirectAttributes flash){
        Citas citas = null;
        if(id > 0){
            citas = citasService.findOne(id);
            if(citas == null){
                flash.addFlashAttribute("error","El ID de la cita no existe en la base de datos");
                return "redirect:/gestionCitas";
            }
        }else{
            flash.addFlashAttribute("error","El ID de la cita no puede ser cero");
            return "redirect:/gestionCitas";
        }
        modelo.put("empleado",empleado_Service.findAll());
        modelo.put("mascota",mascotaService.findAll());
        modelo.put("servicio",servicioService.findAll());
        modelo.put("citas", citas);
        modelo.put("titulo","Modificar Cita");
        return "formularioCitas";
    }

    @GetMapping("/eliminarCitas/{id}")
    public String eliminarCitas(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            citasService.delete(id);
            flash.addFlashAttribute("success","Cita eliminado con exito");
        }
        return "redirect:/gestionCitas";
    }
}

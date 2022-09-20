package com.veterinaria.proyecto_veterinaria.Entidades;

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

import com.veterinaria.proyecto_veterinaria.paginacion.PageRender;

@Controller
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/detalleMascota/{id}")
    public String verDetallesMascota(@PathVariable(value = "id") Long id, Map<String, Object> modelo,RedirectAttributes flash){
        Mascota mascota = mascotaService.findOne(id);
        if(mascota == null){
            flash.addFlashAttribute("error","La mascota no existe en la base de datos");
            return "redirect:/gestionMascota";
        }
        List<Propietario> listaPropietario = propietarioService.findAll();
        modelo.put("listaPropietario",listaPropietario);
        modelo.put("mascota", mascota);
        modelo.put("titulo",mascota.getNombre());
        return "detalleMascota";
    }

    @GetMapping("/gestionMascota")
    public String listarMascota(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,7);
        Page<Mascota> mascota = mascotaService.findAll(pageRequest);
        PageRender<Mascota> pageRender = new PageRender<>("/gestionMascota",mascota);
        model.addAttribute("mascota",mascota);
        model.addAttribute("page",pageRender);
        return "gestionMascota";
    }

    @GetMapping("/formularioMascota")
    public String RegistrarMascota(Map<String,Object> modelo){
        Mascota mascota = new Mascota();
        modelo.put("listaPropietario",propietarioService.findAll());
        modelo.put("mascota", mascota);
        modelo.put("titulo","Registrar Mascota");
        return "formularioMascota";
    }

    @PostMapping("/formularioMascota")
    public String guardarMascota(@Valid Mascota mascota,BindingResult result,Model modelo, RedirectAttributes flash, SessionStatus status){  
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registrar Mascota");
            return "formularioMascota";
        }
        String mensaje = (mascota.getId() != null) ? "La mascota ha sido editado con exito" : "La mascota ha sido registrado con exito";
        mascotaService.save(mascota);
        status.setComplete();
        flash.addFlashAttribute("success",mensaje);
        return "redirect:/gestionMascota";
    }
    @GetMapping("/formularioMascota/{id}")
    public String editarMascota(@PathVariable(value = "id") Long id, Map<String,Object> modelo, RedirectAttributes flash){
        Mascota mascota = null;
        if(id > 0){
            mascota = mascotaService.findOne(id);
            if(mascota == null){
                flash.addFlashAttribute("error","El ID de la mascota no existe en la base de datos");
                return "redirect:/gestionMascota";
            }
        }else{
            flash.addFlashAttribute("error","El ID de la mascota no puede ser cero");
            return "redirect:/gestionMascota";
        }
        modelo.put("listaPropietario",propietarioService.findAll());
        modelo.put("mascota",mascota);
        modelo.put("titulo","Modificar Mascota");
        return "formularioMascota";
    }

    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            mascotaService.delete(id);
            flash.addFlashAttribute("success","Mascota eliminado con exito");
        }
        return "redirect:/gestionMascota";
    }
    
}

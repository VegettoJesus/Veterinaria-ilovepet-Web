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

import com.veterinaria.proyecto_veterinaria.paginacion.PageRender;

@Controller
public class Historial_MedicoController {
    
    @Autowired
    private Historial_MedicoService historial_MedicoService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private CitasService citasService;

    @GetMapping("/gestionHistorialM")
    public String listarHistorialMedico(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page,7);
        Page<Historial_Medico> historial_medico = historial_MedicoService.findAll(pageRequest);
        PageRender<Historial_Medico> pageRender = new PageRender<>("/gestionHistorialM",historial_medico);
        model.addAttribute("historial_medico",historial_medico);
        model.addAttribute("page",pageRender);
        return "gestionHistorialM";
        
    }

    @GetMapping("/formularioHistorialM")
    public String RegistrarHistorialMedico(Map<String,Object> modelo){
        Historial_Medico historial_medico = new Historial_Medico();
        modelo.put("mascota",mascotaService.findAll());
        modelo.put("citas",citasService.findAll());
        modelo.put("historial_medico", historial_medico);
        modelo.put("titulo","Registrar Historial Medico");
        return "formularioHistorialM";
    }

    @PostMapping("/formularioHistorialM")
    public String guardarHistorialMedico(@Valid Historial_Medico historial_medico,BindingResult result,Model modelo, RedirectAttributes flash, SessionStatus status){  
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registrar Historial Medico");
            return "formularioHistorialM";
        }
        String mensaje = (historial_medico.getId() != null) ? "El empleado ha sido editado con exito" : "El empleado ha sido registrado con exito";
        historial_MedicoService.save(historial_medico);
        status.setComplete();
        flash.addFlashAttribute("success",mensaje);
        return "redirect:/gestionHistorialM";
    }

    @GetMapping("/formularioHistorialM/{id}")
    public String editarHistorialMedico(@PathVariable(value = "id") Long id, Map<String,Object> modelo, RedirectAttributes flash){
        Historial_Medico historial_medico = null;
        if(id > 0){
            historial_medico = historial_MedicoService.findOne(id);
            if(historial_medico == null){
                flash.addFlashAttribute("error","El ID del Historial Medico no existe en la base de datos");
                return "redirect:/gestionHistorialM";
            }
        }else{
            flash.addFlashAttribute("error","El ID del Historial Medico no puede ser cero");
            return "redirect:/gestionHistorialM";
        }
        modelo.put("mascota",mascotaService.findAll());
        modelo.put("citas",citasService.findAll());
        modelo.put("historial_medico", historial_medico);
        modelo.put("titulo","Modificar Historial Medico");
        return "formularioHistorialM";
    }
}

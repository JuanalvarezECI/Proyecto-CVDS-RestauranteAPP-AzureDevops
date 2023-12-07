package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Preferencias;
import co.edu.escuelaing.cvds.lab7.service.PreferenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class PreferenciasController {
    private final PreferenciasService preferenciasService;
    @Autowired
    public PreferenciasController(PreferenciasService preferenciasService) {
        this.preferenciasService = preferenciasService;
    }

    @GetMapping("/formularioP")
    public String mostrarFormulario() {
        return "formularioPreferencias";
    }
    @PostMapping("/guardar-preferencia")
    public String guardarPreferencia(Preferencias preferencias) {
        preferenciasService.guardarPreferencia(preferencias);
        return "redirect:/prueba";
    }
}

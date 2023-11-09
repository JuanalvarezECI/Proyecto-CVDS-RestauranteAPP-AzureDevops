package co.edu.escuelaing.cvds.lab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedidoController {

    @GetMapping("/confirmacion")
    public String mostrarConfirmacion(@RequestParam("plato") String plato, Model model) {
        // Genera un número de ticket aleatorio
        int numeroTicket = (int) (Math.random() * 1000) + 1;

        // Agrega datos al modelo
        model.addAttribute("plato", plato);
        model.addAttribute("numeroTicket", numeroTicket);

        // Devuelve la vista de confirmación
        return "confirmacion";
    }
}

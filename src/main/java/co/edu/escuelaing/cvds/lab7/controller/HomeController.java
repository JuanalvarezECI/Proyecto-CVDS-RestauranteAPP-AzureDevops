package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PlatoService platoService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Menu> platos = platoService.obtenerTodosLosPlatos();
        model.addAttribute("platos", platos);
        return "home";
    }
}

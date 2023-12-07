package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import co.edu.escuelaing.cvds.lab7.service.PreferenciasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CocinaController {
    private final MenuService menuService;
    private final PreferenciasService preferenciasService;

    @Autowired
    public CocinaController(MenuService menuService , PreferenciasService preferenciasService) {

        this.menuService = menuService;
        this.preferenciasService = preferenciasService;
    }
    @GetMapping("/cocina")
    public String mostrarCocina(Model model) {
        List<Menu> menuItems = menuService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "cocina"; // Ajusta el nombre según tu estructura de carpetas y archivos
    }
    @GetMapping("/formulario")
    public String mostrarFormulario(@RequestParam Integer id, Model model) {
        Menu menu = menuService.getMenuById(id);
        model.addAttribute("menuForm", menu);
        return "formulario";
    }

    @PostMapping("/modificar")
    public String modificarMenu(@ModelAttribute("menuForm") @Valid Menu menuForm,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, recargar la página con un mensaje de error
            model.addAttribute("error", "Revise los campos ingresados");
            return "formulario";
        }
        menuService.agregarPlatillo(menuForm);
        return "redirect:/cocina";
    }
    @GetMapping("/nuevo-platillo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("menuForm", new Menu());
        return "formularioCrear";
    }

    @PostMapping("/agregar-platillo")
    public String agregarPlatillo(@ModelAttribute("menuForm") @Valid Menu menuForm,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, recargar la página con un mensaje de error
            model.addAttribute("error", "Revise los campos ingresados");
            return "formularioCrear";
        }
        menuService.agregarPlatillo(menuForm);
        return "redirect:/cocina";
    }
    @GetMapping("/preferencias")
    public String mostrarPreferencias(Model model) {
        model.addAttribute("preferencias", preferenciasService.obtenerTodasLasPreferencias());
        return "preferencias";
    }

}


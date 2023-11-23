package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.Ticket;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import co.edu.escuelaing.cvds.lab7.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;
    private final TicketService ticketService;

    @Autowired
    public MenuController(MenuService menuService, TicketService ticketService) {
        this.menuService = menuService;
        this.ticketService = ticketService;
    }

    @GetMapping("/prueba")
    public String showMenu(Model model) {
        List<Menu> menuItems = menuService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "prueba";
    }

    @PostMapping("/realizar-pedido")
    public String realizarPedido(@RequestParam String nombrePlato, Model model) {
        menuService.realizarPedido(nombrePlato);
        ticketService.realizarPedido(nombrePlato);
        return "redirect:/prueba";
    }
}


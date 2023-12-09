package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import co.edu.escuelaing.cvds.lab7.service.TicketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @Mock
    private MenuService menuService;

    @Mock
    private TicketService ticketService;

    @Mock
    private Model model;

    @InjectMocks
    private MenuController menuController;

    @Test
    void testShowMenu() {
        List<Menu> mockMenuItems = new ArrayList<>();
        when(menuService.getAllMenuItems()).thenReturn(mockMenuItems);

        String result = menuController.showMenu(model);

        assertEquals("prueba", result);
        verify(model).addAttribute("menuItems", mockMenuItems);
    }

    @Test
    void testRealizarPedido() {
        String nombrePlato = "SomePlato";

        String result = menuController.realizarPedido(nombrePlato, model);

        assertEquals("redirect:/prueba", result);
        verify(menuService).realizarPedido(nombrePlato);
        verify(ticketService).realizarPedido(nombrePlato);
    }

    // Puedes agregar más pruebas según tus necesidades

}

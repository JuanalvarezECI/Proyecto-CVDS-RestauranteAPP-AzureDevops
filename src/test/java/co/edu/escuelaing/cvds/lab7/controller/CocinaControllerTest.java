package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.model.Preferencias;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import co.edu.escuelaing.cvds.lab7.service.PreferenciasService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CocinaControllerTest {

    @Mock
    private MenuService menuService;

    @Mock
    private PreferenciasService preferenciasService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private CocinaController cocinaController;

    @Test
    void testMostrarCocina() {
        List<Menu> menuItems = new ArrayList<>();
        when(menuService.getAllMenuItems()).thenReturn(menuItems);

        String result = cocinaController.mostrarCocina(model);

        assertEquals("cocina", result);
        verify(model).addAttribute("menuItems", menuItems);
    }

    @Test
    void testMostrarFormulario() {
        Integer id = 1;
        Menu menu = new Menu();
        when(menuService.getMenuById(id)).thenReturn(menu);

        String result = cocinaController.mostrarFormulario(id, model);

        assertEquals("formulario", result);
        verify(model).addAttribute("menuForm", menu);
    }

    @Test
    void testModificarMenuSuccess() {
        Menu menuForm = new Menu();
        String result = cocinaController.modificarMenu(menuForm, bindingResult, model);

        assertEquals("redirect:/cocina", result);
        verify(menuService).agregarPlatillo(menuForm);
    }

    @Test
    void testModificarMenuValidationError() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String result = cocinaController.modificarMenu(new Menu(), bindingResult, model);

        assertEquals("formulario", result);
        verify(model).addAttribute("error", "Revise los campos ingresados");
    }

    @Test
    void testAgregarPlatilloSuccess() {
        Menu menuForm = new Menu();
        String result = cocinaController.agregarPlatillo(menuForm, bindingResult, model);

        assertEquals("redirect:/cocina", result);
        verify(menuService).agregarPlatillo(menuForm);
    }

    @Test
    void testAgregarPlatilloValidationError() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String result = cocinaController.agregarPlatillo(new Menu(), bindingResult, model);

        assertEquals("formularioCrear", result);
        verify(model).addAttribute("error", "Revise los campos ingresados");
    }

    @Test
    void testMostrarPreferencias() {
        List<Preferencias> preferenciasList = new ArrayList<>();
        when(preferenciasService.obtenerTodasLasPreferencias()).thenReturn(preferenciasList);

        String result = cocinaController.mostrarPreferencias(model);

        assertEquals("preferencias", result);
        verify(model).addAttribute("preferencias", preferenciasList);
    }

    // Puedes agregar más pruebas según tus necesidades

}

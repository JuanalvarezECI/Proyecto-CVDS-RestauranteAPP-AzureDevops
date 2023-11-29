package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {

    @InjectMocks
    private MenuService menuService;

    @Mock
    private MenuRepository menuRepository;

    @Test
    public void testRealizarPedido() {
        // Simulamos un menú con unidades disponibles
        Menu menu = new Menu("Prueba", 100, "2023-12-31", 5);
        when(menuRepository.findByPlato("Prueba")).thenReturn(menu);

        // Realizamos un pedido
        menuService.realizarPedido("Prueba");

        // Verificamos que se haya reducido una unidad
        assertEquals(4, menu.getUnidades());
        verify(menuRepository, times(1)).save(menu);
    }

    @Test
    public void testRealizarPedido_UnidadesAgotadas() {
        // Simulamos un menú con unidades agotadas
        Menu menu = new Menu("Prueba", 100, "2023-12-31", 0);
        when(menuRepository.findByPlato("Prueba")).thenReturn(menu);

        // Intentamos realizar un pedido
        menuService.realizarPedido("Prueba");

        // Verificamos que no se haya modificado el menú (unidades siguen en 0)
        assertEquals(0, menu.getUnidades());
        verify(menuRepository, never()).save(any(Menu.class));
    }
    @Test
    public void testAplicarDescuento() {
        // Simulamos dos menús con diferentes fechas de caducidad
        Menu menu1 = new Menu("Plato1", 100, "2023-11-10", 10);
        // Simulamos que ambos menús están en la base de datos
        when(menuRepository.findAll()).thenReturn(Arrays.asList(menu1));

        // Ejecutamos el método que aplica descuento
        menuService.aplicarDescuento();

        // Verificamos que el descuento se haya aplicado correctamente
        // El precio de menu1 debe haber cambiado, pero no el de menu2
        assertEquals(70, menu1.getPrecio());

        // Verificamos que ambos menús se hayan guardado en la base de datos
        verify(menuRepository, times(1)).save(menu1);
    }
}

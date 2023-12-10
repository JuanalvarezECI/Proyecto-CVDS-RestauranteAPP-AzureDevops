package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Menu;
import co.edu.escuelaing.cvds.lab7.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @Test
    void testRealizarPedido() {
        Menu mockMenu = new Menu();
        mockMenu.setUnidades(2);

        when(menuRepository.findByPlato(anyString())).thenReturn(mockMenu);

        menuService.realizarPedido("lomo de cerdo");

        assertEquals(1, mockMenu.getUnidades());
        verify(menuRepository, times(1)).save(mockMenu);
    }

    @Test
    void testGuardarMenus() {
        menuService.guardarMenus();

        // Verificar que se hayan llamado a los métodos de save con los menús específicos
        verify(menuRepository, times(4)).save(any(Menu.class));
    }
    @Test
    void testRealizarPedidoUnidadesAgotadas() {
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
    void testAplicarDescuento() throws ParseException {
        List<Menu> mockMenuItems = new ArrayList<>();
        Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-15");
        mockMenuItems.add(new Menu("lomo de cerdo", 20000, "2023-11-30", 20));

        when(menuRepository.findAll()).thenReturn(mockMenuItems);

        menuService.aplicarDescuento();

        // Verificar que se haya aplicado el descuento
        assertEquals(14000, mockMenuItems.get(0).getPrecio().intValue());
        verify(menuRepository, times(1)).save(any(Menu.class));
    }

    @Test
    void testAgregarPlatilloWithDescuento() throws ParseException {
        Menu mockMenu = new Menu("lomo de cerdo", 20000, "2023-11-20", 20);

        menuService.agregarPlatillo(mockMenu);

        // Verificar que se haya aplicado el descuento
        assertEquals(14000, mockMenu.getPrecio().intValue());
        verify(menuRepository, times(1)).save(mockMenu);
    }

    @Test
    void testAgregarPlatilloWithoutDescuento() throws ParseException {
        Menu mockMenu = new Menu("lomo de cerdo", 20000, "2023-11-30", 20);

        menuService.agregarPlatillo(mockMenu);

        // Verificar que no se haya aplicado el descuento
        assertEquals(14000, mockMenu.getPrecio().intValue());
        verify(menuRepository, times(1)).save(mockMenu);
    }
}

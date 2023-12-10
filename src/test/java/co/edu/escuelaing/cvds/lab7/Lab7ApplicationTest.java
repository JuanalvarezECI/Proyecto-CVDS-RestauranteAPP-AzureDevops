package co.edu.escuelaing.cvds.lab7;
import co.edu.escuelaing.cvds.lab7.service.MenuService;
import co.edu.escuelaing.cvds.lab7.service.PreferenciasService;
import co.edu.escuelaing.cvds.lab7.service.TicketService;
import co.edu.escuelaing.cvds.lab7.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.CommandLineRunner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Lab7ApplicationTest {

    @Mock
    private UserService userService;

    @Mock
    private MenuService menuService;

    @Mock
    private TicketService ticketService;

    @Mock
    private PreferenciasService preferenciasService;

    @InjectMocks
    private Lab7Application lab7Application;

    @Test
    void testRun() throws Exception {
        CommandLineRunner commandLineRunner = lab7Application.run();

        // Llamamos al método run
        commandLineRunner.run("arg1", "arg2");
        // Verificamos que los métodos correspondientes hayan sido llamados
        verify(userService, times(1)).guardarUsuarios();
        verify(menuService, times(1)).guardarMenus();
        verify(menuService, times(1)).aplicarDescuento();
        verify(preferenciasService, times(1)).preferenciasprueba();
    }
}


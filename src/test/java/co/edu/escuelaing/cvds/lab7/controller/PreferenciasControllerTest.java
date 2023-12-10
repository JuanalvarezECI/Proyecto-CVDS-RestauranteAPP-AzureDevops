package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Preferencias;
import co.edu.escuelaing.cvds.lab7.service.PreferenciasService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PreferenciasControllerTest {

    @Mock
    private PreferenciasService preferenciasService;

    @InjectMocks
    private PreferenciasController preferenciasController;

    @Test
    void testMostrarFormulario() {
        String result = preferenciasController.mostrarFormulario();

        assertEquals("formularioPreferencias", result);
    }

    @Test
    void testGuardarPreferencia() {
        Preferencias mockPreferencias = new Preferencias();

        String result = preferenciasController.guardarPreferencia(mockPreferencias);

        assertEquals("redirect:/prueba", result);
        verify(preferenciasService).guardarPreferencia(mockPreferencias);
    }
}

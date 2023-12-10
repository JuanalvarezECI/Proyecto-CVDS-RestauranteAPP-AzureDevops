package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Preferencias;
import co.edu.escuelaing.cvds.lab7.repository.PreferenciasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PreferenciasServiceTest {

    @Mock
    private PreferenciasRepository preferenciasRepository;

    @InjectMocks
    private PreferenciasService preferenciasService;

    @Test
    void testGuardarPreferencia() {
        Preferencias mockPreferencia = new Preferencias("Ajiaco", "Es una sopa espesa colombiana hecha con papas, pollo, maíz y guascas.");

        preferenciasService.guardarPreferencia(mockPreferencia);

        // Verificar que se haya llamado al método de save con la preferencia específica
        verify(preferenciasRepository, times(1)).save(mockPreferencia);
    }

    @Test
    void testObtenerTodasLasPreferencias() {
        List<Preferencias> mockPreferencias = new ArrayList<>();
        mockPreferencias.add(new Preferencias("Bandeja Paisa", "Es un plato típico de la región paisa en Colombia."));
        mockPreferencias.add(new Preferencias("Arepas", "Son una especie de torta redonda hecha de masa de maíz o harina de trigo."));

        when(preferenciasRepository.findAll()).thenReturn(mockPreferencias);

        List<Preferencias> result = preferenciasService.obtenerTodasLasPreferencias();

        assertEquals(mockPreferencias, result);
    }

    @Test
    void testPreferenciasPrueba() {
        preferenciasService.preferenciasprueba();

        // Verificar que se haya llamado al método de save con las preferencias específicas
        verify(preferenciasRepository, times(3)).save(any(Preferencias.class));
    }
}

package co.edu.escuelaing.cvds.lab7.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PreferenciasModelTest {

    @Test
    void testConstructorAndGetters() {
        Preferencias preferencias = new Preferencias("Plato1", "Descripción 1");

        assertThat(preferencias.getId()).isNull(); // No se debe establecer el ID manualmente
        assertThat(preferencias.getPlato()).isEqualTo("Plato1");
        assertThat(preferencias.getDescripcion()).isEqualTo("Descripción 1");
    }

    @Test
    void testSetters() {
        Preferencias preferencias = new Preferencias();
        preferencias.setPlato("Plato2");
        preferencias.setDescripcion("Descripción 2");

        assertThat(preferencias.getPlato()).isEqualTo("Plato2");
        assertThat(preferencias.getDescripcion()).isEqualTo("Descripción 2");
    }

    @Test
    void testEmptyConstructor() {
        Preferencias preferencias = new Preferencias();

        assertThat(preferencias.getId()).isNull();
        assertThat(preferencias.getPlato()).isNull();
        assertThat(preferencias.getDescripcion()).isNull();
    }
}

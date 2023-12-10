package co.edu.escuelaing.cvds.lab7.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MenuModelTest {

    @Test
    void testConstructorAndGetters() {
        Menu menu = new Menu("Plato1", 10000, "2023-12-31", 10);

        assertThat(menu.getId()).isNull(); // No se debe establecer el ID manualmente
        assertThat(menu.getPlato()).isEqualTo("Plato1");
        assertThat(menu.getPrecio()).isEqualTo(10000);
        assertThat(menu.getCaducidad()).isEqualTo("2023-12-31");
        assertThat(menu.getUnidades()).isEqualTo(10);
    }

    @Test
    void testSetters() {
        Menu menu = new Menu();
        menu.setPlato("Plato2");
        menu.setPrecio(15000);
        menu.setCaducidad("2024-01-15");
        menu.setUnidades(5);

        assertThat(menu.getPlato()).isEqualTo("Plato2");
        assertThat(menu.getPrecio()).isEqualTo(15000);
        assertThat(menu.getCaducidad()).isEqualTo("2024-01-15");
        assertThat(menu.getUnidades()).isEqualTo(5);
    }

    @Test
    void testEmptyConstructor() {
        Menu menu = new Menu();

        assertThat(menu.getId()).isNull();
        assertThat(menu.getPlato()).isNull();
        assertThat(menu.getPrecio()).isNull();
        assertThat(menu.getCaducidad()).isNull();
        assertThat(menu.getUnidades()).isNull();
    }
}

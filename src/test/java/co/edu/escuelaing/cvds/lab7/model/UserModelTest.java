package co.edu.escuelaing.cvds.lab7.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserModelTest {
    @Test
    void testConstructorAndGetters() {
        User user = new User("usuario1", "contrasena1", "correo1@example.com");

        assertThat(user.getUsername()).isEqualTo("usuario1");
        assertThat(user.getPassword()).isEqualTo("contrasena1");
        assertThat(user.getEmail()).isEqualTo("correo1@example.com");
    }

    @Test
    void testEmptyConstructor() {
        User user = new User();

        assertThat(user.getUsername()).isNull();
        assertThat(user.getPassword()).isNull();
        assertThat(user.getEmail()).isNull();
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setUsername("usuario2");
        user.setPassword("contrasena2");
        user.setEmail("correo2@example.com");

        assertThat(user.getUsername()).isEqualTo("usuario2");
        assertThat(user.getPassword()).isEqualTo("contrasena2");
        assertThat(user.getEmail()).isEqualTo("correo2@example.com");
    }
}

package co.edu.escuelaing.cvds.lab7.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class TicketModelTest {

    @Test
    void testConstructorAndGetters() {
        Ticket ticket = new Ticket("Plato1");

        assertThat(ticket.getId()).isNull(); // No se debe establecer el ID manualmente
        assertThat(ticket.getPlato()).isEqualTo("Plato1");
    }

    @Test
    void testSetters() {
        Ticket ticket = new Ticket();
        ticket.setPlato("Plato2");

        assertThat(ticket.getPlato()).isEqualTo("Plato2");
    }

    @Test
    void testEmptyConstructor() {
        Ticket ticket = new Ticket();

        assertThat(ticket.getId()).isNull();
        assertThat(ticket.getPlato()).isNull();
    }
}

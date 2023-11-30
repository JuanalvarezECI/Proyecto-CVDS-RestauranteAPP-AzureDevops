package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Ticket;
import co.edu.escuelaing.cvds.lab7.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Integer realizarPedido(String nombrePlato) {
        Ticket ticket = new Ticket();
        ticket.setPlato(nombrePlato);
        ticketRepository.save(ticket);
        Ticket ticketGuardado = ticketRepository.save(ticket);
        return ticketGuardado.getId();
    }
}

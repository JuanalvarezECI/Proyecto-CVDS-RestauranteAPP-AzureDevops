package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plato")

    private String plato;

    public Ticket() {
    }

    public Ticket(String plato) {
        this.plato = plato;
    }

    public Integer getId() {

        return id;
    }

    public String getPlato() {

        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}

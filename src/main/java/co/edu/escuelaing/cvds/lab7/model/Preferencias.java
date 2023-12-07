package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "preferencias")
public class Preferencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plato")
    @NotEmpty(message = "El campo 'plato' no puede estar vacío")
    private String plato;

    @Column(name = "descripcion")
    @NotEmpty(message = "El campo 'plato' no puede estar vacío")
    private String descripcion;

    public Preferencias() {
    }

    public Preferencias(String plato, String descripcion) {
        this.plato = plato;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getPlato() {
        return plato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setPlato(String plato) {this.plato = plato;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "plato")
    private String plato;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "caducidad")
    private String caducidad;

    public Menu() {
    }

    public Menu(Integer id, String plato, Integer precio, String caducidad) {
        this.id = id;
        this.plato = plato;
        this.precio = precio;
        this.caducidad = caducidad;
    }

    public Integer getId() {
        return id;
    }

    public String getPlato() {
        return plato;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String getCaducidad() {
        return caducidad;
    }
}
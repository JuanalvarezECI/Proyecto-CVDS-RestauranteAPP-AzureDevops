package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plato")
    private String plato;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "caducidad")
    private String caducidad;
    @Column(name = "unidades")
    private Integer unidades;

    public Menu() {
    }

    public Menu(String plato, Integer precio, String caducidad, Integer unidades) {
        this.plato = plato;
        this.precio = precio;
        this.caducidad = caducidad;
        this.unidades = unidades;

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
    public Integer getUnidades() {
        return unidades;
    }
    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

}
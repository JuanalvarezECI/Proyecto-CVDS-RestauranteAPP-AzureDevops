package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plato")
    @NotEmpty(message = "El campo 'plato' no puede estar vacío")
    private String plato;
    @Column(name = "precio")
    @Positive(message = "El precio debe ser un número positivo")
    private Integer precio;
    @Column(name = "caducidad")
    @NotEmpty(message = "El campo 'Caducidad' no puede estar vacío")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "El formato de 'caducidad' debe ser 'aaaa-mm-dd'")
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

    public void setId(Integer id) {
        this.id = id;
    }
    public void setPlato(String plato) {this.plato = plato;}
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

}
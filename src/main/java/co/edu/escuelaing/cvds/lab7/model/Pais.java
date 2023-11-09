package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")

    private String password;
    @Column(name = "correo")

    private String correo;

    public Pais(){
    }
    public Pais(String username, String password, String correo) {
        this.username = username;
        this.password = password;
        this.correo = correo;

    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }
}
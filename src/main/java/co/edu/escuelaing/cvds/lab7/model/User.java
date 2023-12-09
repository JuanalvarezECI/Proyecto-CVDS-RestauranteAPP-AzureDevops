package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")

    private String password;
    @Column(name = "correo")

    private String correo;

    public User(){
    }
    public User(String username, String password, String correo) {
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
    public String getEmail() {

        return correo;
    }
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setEmail(String correo) {this.correo = correo;}


}

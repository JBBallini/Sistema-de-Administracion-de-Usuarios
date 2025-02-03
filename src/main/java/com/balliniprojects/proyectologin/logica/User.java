
package com.balliniprojects.proyectologin.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author porokiin
 */

@Entity
public class User implements Serializable {
    
    @Id
    //No genero Id automático por tener una tabla ya existente en la DB
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String usuario;
    private String password;
    
    //Marco como foreing key una nueva columna llamada "fk_rol" utilizando "unRol" para utilizar la relación bidireccional n a 1 y n a 1
    @ManyToOne
    @JoinColumn(name = "fk_rol")
    private Rol unRol;
    
    public User() {
    }

    public User(int id, String usuario, String password, Rol unRol) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.unRol = unRol;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

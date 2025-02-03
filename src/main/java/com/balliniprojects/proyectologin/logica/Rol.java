
package com.balliniprojects.proyectologin.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Ballini Juan Bautista
 */

@Entity
public class Rol implements Serializable {
    
    @Id
    //No genero Id automático por tener una tabla ya existente en la DB
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombreRol;
    private String descripcionRol;
    
    //Mapeo con el objeto "unRol" de usuario para entablar la relación bidireccional
    @OneToMany(mappedBy = "unRol")
    private List<User> listaUsuarios;

    public Rol() {
    }

    public Rol(int id, String nombreRol, String descripcionRol, List<User> listaUsuarios) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcionRol = descripcionRol;
        this.listaUsuarios = listaUsuarios;
    }

    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    } 
}

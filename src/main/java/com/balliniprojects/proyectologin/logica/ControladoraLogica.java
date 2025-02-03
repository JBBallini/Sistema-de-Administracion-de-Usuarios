
package com.balliniprojects.proyectologin.logica;

import com.balliniprojects.proyectologin.persistencia.ControladoraPersistencia;
import java.util.Comparator;
import java.util.List;

/**
 * @author porokiin
 */

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis;
    
    public ControladoraLogica(){
        controlPersis = new ControladoraPersistencia();
    }

    public User validarUsuario(String usuario, String password) {
        
       //Compruebo entre todos los usuarios de la BD, el usuario y la contraseña traidos de la IGU
        List<User> listaUsuario = controlPersis.traerUsuarios();
        
        for (User usu : listaUsuario){
            if(usu.getUsuario().equals(usuario)){
                if(usu.getPassword().equals(password)){
                    return usu;
                }else {
                    return null;
                }
            }
        }
        return null;
    }

    public List<User> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String nombre, String password, String rolRecibido) {
        
        //Armamos un nuevo usuario con los datos de la igu
        User usr = new User();
        usr.setUsuario(nombre);
        usr.setPassword(password);
        
        //El rol traido es un string y el que esta en el sistema es un objeto
        Rol rolEncontrado = new Rol();
        //Almaceno el rol encontrado con el método creado
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado != null){
            //Guardo el rol en el objeto "usr"
            usr.setUnRol(rolEncontrado);
        }
        
        //Busco el último ID de la tabla + 1 y se la asigno al usuario para solucionar el problema de generación de Ids con una DB ya existente
        int id = this.buscarUltimaIdUsuario();
        System.out.println("ID traido: " + id);
        usr.setId(id + 1);
        
        //Guardo el usuario en la DB
        controlPersis.crearUsuario(usr);
    }

    //Este método se va a encargar de retornar el rol (objeto) que coincide con el "rolRecibido" (String) y el nombre del rol guardado en la DB
    private Rol traerRol(String rolRecibido) {
        List <Rol> listaRoles = controlPersis.traerRoles();
        
        for(Rol rol : listaRoles){
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuario() {
        List<User> listaUsuarios = this.traerUsuarios();
        
        // Ordenar la lista por ID de forma ascendente
        listaUsuarios.sort(Comparator.comparingInt(User::getId));
        
        User usr = listaUsuarios.get(listaUsuarios.size() - 1);
        return usr.getId();
    }

    public void borrarUsuario(int idUsuario) {
        controlPersis.borrarUsuario(idUsuario);
    }

    public User traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
    }

    public void editarUsuario(User usr, String nombre, String password, String rolRecibido) {
        
        usr.setUsuario(nombre);
        usr.setPassword(password);
        
        Rol rolEncontrado = new Rol();
        //Almaceno el rol encontrado con el método creado
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado != null){
            //Guardo el rol en el objeto "usr"
            usr.setUnRol(rolEncontrado);
        }
        
        controlPersis.editarUsuario(usr);
    }
}

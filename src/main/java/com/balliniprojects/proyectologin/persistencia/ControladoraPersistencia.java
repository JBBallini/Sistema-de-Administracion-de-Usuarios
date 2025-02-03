
package com.balliniprojects.proyectologin.persistencia;

import com.balliniprojects.proyectologin.logica.Rol;
import com.balliniprojects.proyectologin.logica.User;
import com.balliniprojects.proyectologin.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ballini Juan Bautista
 */

public class ControladoraPersistencia {
    
    UserJpaController userJPA = new UserJpaController();
    RolJpaController rolJPA = new RolJpaController();

    public List<User> traerUsuarios() {
        return userJPA.findUserEntities();
    }    

    public List<Rol> traerRoles() {
        return rolJPA.findRolEntities();
    }

    public void crearUsuario(User usr) {
        userJPA.create(usr);
    }

    public void borrarUsuario(int idUsuario) {
        try {
            userJPA.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User traerUsuario(int idUsuario) {
        return userJPA.findUser(idUsuario);
    }

    public void editarUsuario(User usr) {
        try {
            userJPA.edit(usr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

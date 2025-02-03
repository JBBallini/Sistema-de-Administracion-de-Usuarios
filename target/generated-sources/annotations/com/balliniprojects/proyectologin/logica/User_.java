package com.balliniprojects.proyectologin.logica;

import com.balliniprojects.proyectologin.logica.Rol;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-03T16:07:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Rol> unRol;
    public static volatile SingularAttribute<User, String> usuario;
    public static volatile SingularAttribute<User, Integer> id;

}
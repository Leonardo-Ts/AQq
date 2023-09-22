package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.UsuarioEstado;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractUsuario.class)
public abstract class AbstractUsuario_ { 

    public static volatile SingularAttribute<AbstractUsuario, String> latitud;
    public static volatile SingularAttribute<AbstractUsuario, Estado> estado;
    public static volatile SingularAttribute<AbstractUsuario, Frecuencia> frecuencia;
    public static volatile SetAttribute<AbstractUsuario, UsuarioEstado> usuarioEstadoUsuarioViaIdUsuario;
    public static volatile SingularAttribute<AbstractUsuario, String> direccion;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> avqCaptura;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> ultimaLocalizacionValida;
    public static volatile SingularAttribute<AbstractUsuario, String> nombre;
    public static volatile SingularAttribute<AbstractUsuario, Perfil> perfil;
    public static volatile SingularAttribute<AbstractUsuario, String> proveedorTelefonia;
    public static volatile SingularAttribute<AbstractUsuario, String> longitud;
    public static volatile SingularAttribute<AbstractUsuario, Date> ultimaLocalizacion;
    public static volatile SingularAttribute<AbstractUsuario, String> passwd;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> avqAsigna;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> avqCierra;
    public static volatile SingularAttribute<AbstractUsuario, Integer> id;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractUsuario, String> telefono;
    public static volatile SingularAttribute<AbstractUsuario, Double> velocidad;
    public static volatile SingularAttribute<AbstractUsuario, String> username;
    public static volatile SingularAttribute<AbstractUsuario, Base> base;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> avqPermiso_VerTodosLosReportes;
    public static volatile SingularAttribute<AbstractUsuario, Boolean> catalogoPermisoAv;
    

}
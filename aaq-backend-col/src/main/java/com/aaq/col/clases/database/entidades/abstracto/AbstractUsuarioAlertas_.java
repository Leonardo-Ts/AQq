package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Usuario;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractUsuarioAlertas.class)
public class AbstractUsuarioAlertas_ {

	public static volatile SingularAttribute<AbstractUsuarioAlertas, Usuario> usuario;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> tiempoLibre;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> tiempoOcupado;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> arriboPostTiempo;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> login;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> logout;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> noDisponibles;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, String> tipoAlerta;
	public static volatile SingularAttribute<AbstractUsuarioAlertas, Boolean> terminoDistancia;
}

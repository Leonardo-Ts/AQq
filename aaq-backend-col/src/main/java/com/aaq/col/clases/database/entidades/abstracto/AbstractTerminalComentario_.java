package com.aaq.col.clases.database.entidades.abstracto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminalComentario.class)
public abstract class AbstractTerminalComentario_ {

	public static volatile SingularAttribute<AbstractTerminalComentario, Integer> id;
	public static volatile SingularAttribute<AbstractTerminalComentario, String> comentario;
	public static volatile SingularAttribute<AbstractTerminalComentario, java.util.Date> fecha;
	public static volatile SingularAttribute<AbstractTerminalComentario, Terminal> terminal;
	public static volatile SingularAttribute<AbstractTerminalComentario, String> usuario;
	public static volatile SingularAttribute<AbstractTerminalComentario, String> usuarioVisto;
}

package com.aaq.col.clases.database.entidades.abstracto;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractInfoReconocimiento.class)
public abstract class AbstractInfoReconocimiento_ {
	
	public static volatile SingularAttribute<AbstractInfoReconocimiento, Integer> id;
	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> nombre;
	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> apellidoPaterno;
	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> apellidoMaterno;
	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> curp;
	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> reporte;
    public static volatile SingularAttribute<AbstractInfoReconocimiento, Date> fecha;
//	public static volatile SingularAttribute<AbstractInfoReconocimiento, String> tipoAfectado;


}

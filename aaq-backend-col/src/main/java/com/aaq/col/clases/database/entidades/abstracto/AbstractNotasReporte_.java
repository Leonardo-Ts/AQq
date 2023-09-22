package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractNotasReporte.class)
public abstract class AbstractNotasReporte_ {
	
	public static volatile SingularAttribute<AbstractNotasReporte, Estado> estado;
    public static volatile SingularAttribute<AbstractNotasReporte, Integer> id;
    public static volatile SingularAttribute<AbstractNotasReporte, Base> base;
    public static volatile SingularAttribute<AbstractNotasReporte, Terminal> terminal;
    public static volatile SingularAttribute<AbstractNotasReporte, String> notas;
    public static volatile SingularAttribute<AbstractNotasReporte, Date> fecha;
    public static volatile SingularAttribute<AbstractNotasReporte, String> usuario;
    public static volatile SingularAttribute<AbstractNotasReporte, String> reporte;
    public static volatile SingularAttribute<AbstractNotasReporte, String> causaNota;
    

}

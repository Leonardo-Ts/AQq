package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractControlFotografias.class)
public class AbstractControlFotografias_ {

	public static volatile SingularAttribute<AbstractControlFotografias, Integer> id;
    public static volatile SingularAttribute<AbstractControlFotografias, String> nombreFoto;
    public static volatile SingularAttribute<AbstractControlFotografias, String> numReporte;
    public static volatile SingularAttribute<AbstractControlFotografias, String> claveDocumental;
    public static volatile SingularAttribute<AbstractControlFotografias, String> afectado;
    public static volatile SingularAttribute<AbstractControlFotografias, Terminal> terminal;
    public static volatile SingularAttribute<AbstractControlFotografias, Date> fecha;
    public static volatile SingularAttribute<AbstractControlFotografias, Boolean> enviado;
    public static volatile SingularAttribute<AbstractControlFotografias, String> ajustador;
    public static volatile SingularAttribute<AbstractControlFotografias, String> detalle;
    public static volatile SingularAttribute<AbstractControlFotografias, Estado> estado;
    public static volatile SingularAttribute<AbstractControlFotografias, Base> base;
    
}

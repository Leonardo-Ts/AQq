package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractEncuestaAjustador.class)
public abstract class AbstractEncuestaAjustador_ { 

	public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> id;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> numeroReporte;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> nombreAsegurado;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Terminal> terminal;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> atencionPersonalCabina;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> llegadaAjustador;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> presentacionAjustador;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> tratoAjustador;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> capacidadAjustador;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> tratoAjustadorTercero;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> servicioGrua;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Integer> seleccionDeTaller;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Boolean> observoIrregularidadServicio;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Boolean> recibioCopiaDA;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> observaciones;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> nombreConductor;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> telefonoConductor;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> correoConductor;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Date> fecha;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Estado> estado;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, Base> base;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> poliza;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> enviadoFtp;
    public static volatile SingularAttribute<AbstractEncuestaAjustador, String> respuestaFtp;

}
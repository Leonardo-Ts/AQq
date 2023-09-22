package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractReporteMetricaEdua.class)
public abstract class AbstractReporteMetricaEdua_ {

	public static volatile SingularAttribute<AbstractReporteMetricaEdua, Integer> id;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> numeroReporte;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> generalUsuario;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> generalOrigen;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, Boolean> eDua;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> claveAjustador;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> entidad;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, String> base;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, Date> fecha;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, Integer> idTerminal;
    public static volatile SingularAttribute<AbstractReporteMetricaEdua, Boolean> interaccionCompleta;

}

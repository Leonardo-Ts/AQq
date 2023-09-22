package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractReporteSolicitado.class)
public abstract class AbstractReporteSolicitado_ { 

    public static volatile SingularAttribute<AbstractReporteSolicitado, String> horaReal;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> claveProveedor;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> fechaReal;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> lesionadoEdad;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> atencionA;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> lesionadoNombre;
    public static volatile SingularAttribute<AbstractReporteSolicitado, Date> fechaEnviadoSise;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> horaEstimada;
    public static volatile SingularAttribute<AbstractReporteSolicitado, Terminal> terminal;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> comentario;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> lesionadoSexo;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> claveAmbulancia;
    public static volatile SingularAttribute<AbstractReporteSolicitado, Date> fechaInsertado;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> siseRespuestaFolio;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> folioValeTalonario;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> siseRespuestaClave;
    public static volatile SingularAttribute<AbstractReporteSolicitado, Integer> id;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> tipoDeServicio;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> fechaEstimada;
    public static volatile SingularAttribute<AbstractReporteSolicitado, String> numeroReporte;

}
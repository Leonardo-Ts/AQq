package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseAmbulancia.class)
public abstract class AbstractOrdenPaseAmbulancia_ { 

	public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, Integer> id;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> usuario;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, Date> fechaHora;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> numeroReporte;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> tipoAtencion;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> claveHospital;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> claveAmbulancia;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> hospital;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> direccionTraslado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> telefonoHospital;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> nombreLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> ubicacionLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> edadLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> sexoLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> telefonoLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> diagnostico;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, Boolean> enviadoFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, String> reporteNumeroPoliza;
    public static volatile SingularAttribute<AbstractOrdenPaseAmbulancia, Terminal> terminal;
}
package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseMedico.class)
public abstract class AbstractOrdenPaseMedico_ { 

	public static volatile SingularAttribute<AbstractOrdenPaseMedico, Integer> id;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> usuario;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, Date> fechaHora;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> numeroReporte;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> tipoAtencion;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> numeroOcupantes;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> numeroLesionados;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> cobertura;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> causasLesion;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> identificacion;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> nombreLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> telefonoLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> sexoLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> edadLesionado;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> tipoAtencionMedica;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> lesionesAparentes;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> tipoProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> claveProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> hospital;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> telefonoHospital;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> domicilioHospital;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, Boolean> enviadoFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, String> reporteNumeroPoliza;
    public static volatile SingularAttribute<AbstractOrdenPaseMedico, Terminal> terminal;
}
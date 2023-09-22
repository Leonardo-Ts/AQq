package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseAdmision.class)
public abstract class AbstractOrdenPaseAdmision_ { 

	public static volatile SingularAttribute<AbstractOrdenPaseAdmision, Integer> id;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> usuario;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, Date> fechaHora;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> numeroReporte;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> tipoOrden;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> tipoAfectado;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> conductor;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> telefonoConductor;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> oficina;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> ubicacion;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> tipoProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> claveProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> responsableTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> telefonoTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> domicilioTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> cobertura;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> marcaVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> tipoVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> modeloVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> serieVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> colorVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> placasVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> danosPreexistentes;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> danosSiniestro;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, Boolean> deducible;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> tipoDeducible;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> sumaAsegurada;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> porcentajeDeducible;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> monto;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> observaciones;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, Boolean> enviadoFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, String> reporteNumeroPoliza;
    public static volatile SingularAttribute<AbstractOrdenPaseAdmision, Terminal> terminal;
}
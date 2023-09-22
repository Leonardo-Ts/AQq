package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;


@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseEquipoPesado.class)
public abstract class AbstractOrdenPaseEquipoPesado_ { 

	public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, Integer> id;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> usuario;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, Date> fechaHora;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> numeroReporte;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> tipoAtencion;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> conductor;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> telefonoConductor;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> sumaAsegurada;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> tipoDeducible;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> porcentajeDeducible;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> tipoProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> claveProveedor;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> responsableTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> telefonoTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> domicilioTaller;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> marcaVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> modeloVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> serieVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> colorVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> placasVehiculo;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, Boolean> enviadoFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, String> reporteNumeroPoliza;
    public static volatile SingularAttribute<AbstractOrdenPaseEquipoPesado, Terminal> terminal;
}
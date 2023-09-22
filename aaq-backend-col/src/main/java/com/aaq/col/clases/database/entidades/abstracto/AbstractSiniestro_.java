package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractSiniestro.class)
public abstract class AbstractSiniestro_ { 

    public static volatile SingularAttribute<AbstractSiniestro, Estado> estado;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionCalle;
    public static volatile SingularAttribute<AbstractSiniestro, String> longitud;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionCodigoPostal;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionNumero;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionCarreteraNombre;
    public static volatile SingularAttribute<AbstractSiniestro, Integer> id;
    public static volatile SingularAttribute<AbstractSiniestro, String> numeroReporte;
    public static volatile SingularAttribute<AbstractSiniestro, String> latitud;
    public static volatile SingularAttribute<AbstractSiniestro, Boolean> cerrarAsignacion;
    public static volatile SingularAttribute<AbstractSiniestro, Boolean> cerrarLocalizacion;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionMunicipio;
    public static volatile SingularAttribute<AbstractSiniestro, String> idMunSepomex;
    public static volatile SingularAttribute<AbstractSiniestro, Terminal> terminal;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionReferencia;
    public static volatile SingularAttribute<AbstractSiniestro, Date> fecha;
    public static volatile SingularAttribute<AbstractSiniestro, String> identificadorUnico;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionCarreteraKilometro;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionColonia;
    public static volatile SingularAttribute<AbstractSiniestro, String> idEntSepomex;
    public static volatile SingularAttribute<AbstractSiniestro, String> reporteNombreOperadorTelefonico;
    public static volatile SingularAttribute<AbstractSiniestro, Usuario> usuario;
    public static volatile SingularAttribute<AbstractSiniestro, String> claveDeEntidad;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionEstado;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionEntreCalle;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionEsquina;
    public static volatile SingularAttribute<AbstractSiniestro, String> ubicacionPais;

}
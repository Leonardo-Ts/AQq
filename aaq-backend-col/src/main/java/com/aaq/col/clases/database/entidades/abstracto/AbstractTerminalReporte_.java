package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Terminal;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminalReporte.class)
public abstract class AbstractTerminalReporte_ { 

    public static volatile SingularAttribute<AbstractTerminalReporte, String> sipacFolio;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoAseguradora> catalogoAseguradoraBySipacDimosId;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> folioAjustador;
    public static volatile SingularAttribute<AbstractTerminalReporte, Boolean> sipacAplica;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> ajustadorOriginal;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> repuveRespuestaDelWs;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> reporte;
    public static volatile SingularAttribute<AbstractTerminalReporte, Date> repuveFechaDeEnviado;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoHora;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoCodigoDeCausa> catalogoCodigoDeCausa;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoAseguradora> catalogoAseguradoraBySipacRecibimosId;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoFolio;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoAseguradora> catalogoAseguradoraBySipacAmbosId;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoClaveDeEntidad> catalogoClaveDeEntidadByCodigoDeMunicipio;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoImporte;
    public static volatile SingularAttribute<AbstractTerminalReporte, Integer> id;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> ajustadorNuevo;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> averiguacionPreviaFecha;
    public static volatile SingularAttribute<AbstractTerminalReporte, Boolean> sipacRecibimos;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> ramo;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoFecha;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> averiguacionPreviaNumero;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> siniestro;
    public static volatile SingularAttribute<AbstractTerminalReporte, Terminal> terminal;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> identificadorunico;
    public static volatile SingularAttribute<AbstractTerminalReporte, CatalogoClaveDeEntidad> catalogoClaveDeEntidadByCodigoDeEntidad;
    public static volatile SingularAttribute<AbstractTerminalReporte, Date> fecha;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoReferencia;
    public static volatile SingularAttribute<AbstractTerminalReporte, Boolean> sipacAmbos;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoBanco;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> depositoTipoPago;
    public static volatile SingularAttribute<AbstractTerminalReporte, String> anio;
    public static volatile SingularAttribute<AbstractTerminalReporte, Boolean> sipacDimos;

}
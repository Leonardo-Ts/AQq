package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractFormatoReparacionBienes.class)
public abstract class AbstractFormatoReparacionBienes_ { 

    
	 public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Integer> id;
	 

	 public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Date> fechaHora;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbAsegurado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbCarMarca;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbCarModelo;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbClaveAjustador;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes,Integer> rbCuerpoA;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbDanios;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Integer> rbDaniosPre;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbDesDanios;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbDomAfectado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbEmailRepara;
	

	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbFolioElectro;

	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbKm;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbMaterial;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbMedAlto;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbMedAncho;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbMedLong;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNomAfectado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNomAjustador;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNomRepara;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumEndoso;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumFotos;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumInciso;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumPoliza;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumReporte;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNumSiniestro;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbObservaciones;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbOtros;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbRepreAfectado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbTelAfectado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbTelRepara;
	
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbTramo;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbNomAsegurado;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbMunicipio;
	  public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbEstado;
	  
	

    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Integer> enviadoFtp;
	public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> mensajeEmail;
	public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Integer> enviadoEmail;
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> respuestaFtp;
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> rbEmailAfectado;
   
    
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Integer> proceso;
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Timestamp> horaEnvioEmail;
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, Timestamp> horaEnvioSftp;
    public static volatile SingularAttribute<AbstractFormatoReparacionBienes, String> nodoEnvio;

}
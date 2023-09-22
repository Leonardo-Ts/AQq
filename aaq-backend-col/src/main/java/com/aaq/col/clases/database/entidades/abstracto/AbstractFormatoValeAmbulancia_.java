package com.aaq.col.clases.database.entidades.abstracto;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractOrdenPaseAdmision.class)
public abstract class AbstractFormatoValeAmbulancia_ { 

	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Integer> id;
   // public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> usuario;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> emailDefault;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> passwd;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaAsegurado;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaClaveAjustador;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaDatosConductor;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaDatosLesionado;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaDiagnostico;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaDirPaciente;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaEdadPaciente;

    
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaFolioElectro;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Date>  vaHora;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaHospital;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaLugar;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNomAjustador;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNomPaciente;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNomRazon;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNumEndoso;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNumInciso;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNumPoliza;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNumReporte;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaNumSiniestro;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaSexo;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> vaTelPaciente;

    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Integer> enviadoFtp;
    public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> respuestaFtp;
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> mensajeEmail;
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Integer> enviadoEmail;
    //public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Terminal> terminal;
	
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Integer> proceso;
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Timestamp> horaEnvioEmail;
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, Timestamp> horaEnvioSftp;
	public static volatile SingularAttribute<AbstractFormatoValeAmbulancia, String> nodoEnvio;
}
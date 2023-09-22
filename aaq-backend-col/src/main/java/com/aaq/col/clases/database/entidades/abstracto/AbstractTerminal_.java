package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTerminal.class)
public abstract class AbstractTerminal_ { 

    public static volatile SingularAttribute<AbstractTerminal, String> unidadMarca;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> mostrarEnCercania;
    public static volatile SingularAttribute<AbstractTerminal, Estado> estado;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusOcupado;
    public static volatile SingularAttribute<AbstractTerminal, String> horario;
    public static volatile SingularAttribute<AbstractTerminal, String> fuenteArribo;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> estatusInactivo;
    public static volatile SingularAttribute<AbstractTerminal, String> proveedorTelefonia;
    public static volatile SingularAttribute<AbstractTerminal, String> longitud;
    public static volatile SingularAttribute<AbstractTerminal, String> ultimoSiniestroWs;
    public static volatile SingularAttribute<AbstractTerminal, String> unidadSerie;
    public static volatile SingularAttribute<AbstractTerminal, Integer> id;
    public static volatile SingularAttribute<AbstractTerminal, String> numeroproveedor;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> habilitado;
    public static volatile SingularAttribute<AbstractTerminal, String> telefono;
    public static volatile SingularAttribute<AbstractTerminal, String> unidadModelo;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusTermino;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusOtros;
    public static volatile SingularAttribute<AbstractTerminal, String> latitud;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaUltimoLoginDia;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusAsignado;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusDesconectado;
    public static volatile SingularAttribute<AbstractTerminal, String> dispositivoNombre;
    public static volatile SingularAttribute<AbstractTerminal, String> latitudAlterna;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusDisponible;
    public static volatile SingularAttribute<AbstractTerminal, Integer> reportesEsteDia;
    public static volatile SingularAttribute<AbstractTerminal, String> ultimoLocalizacionTiempo;
    public static volatile SingularAttribute<AbstractTerminal, String> claveOficina;
    public static volatile SingularAttribute<AbstractTerminal, String> dispositivoProtocolo;
    public static volatile SingularAttribute<AbstractTerminal, String> estatus;
    public static volatile SingularAttribute<AbstractTerminal, String> passwd;
    public static volatile SingularAttribute<AbstractTerminal, String> dispositivoPasswd;
    public static volatile SingularAttribute<AbstractTerminal, String> unidadNombre;
    public static volatile SingularAttribute<AbstractTerminal, String> correoElectronico;
    public static volatile SingularAttribute<AbstractTerminal, String> ultimoLocalizacionVelocidad;
    public static volatile SingularAttribute<AbstractTerminal, String> ultimoLocalizacionDireccion;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> proximidad;
    public static volatile SingularAttribute<AbstractTerminal, String> horarioSalida;
    public static volatile SingularAttribute<AbstractTerminal, String> nombre;
    public static volatile SingularAttribute<AbstractTerminal, Date> ultimoReporteFecha;
    public static volatile SingularAttribute<AbstractTerminal, String> longitudAlterna;
    public static volatile SingularAttribute<AbstractTerminal, String> fuenteDisponible;
    public static volatile SingularAttribute<AbstractTerminal, String> fuenteAsignacion;
    public static volatile SingularAttribute<AbstractTerminal, String> ultimoLocalizacionReporte;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> coordenadasDesdeServicioWeb;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaEstatusArribo;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> ultimoLocalizacionValida;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaPrimerLoginDia;
    public static volatile SingularAttribute<AbstractTerminal, ReporteSise> reporteSise;
    public static volatile SingularAttribute<AbstractTerminal, String> numeroradio;
    public static volatile SingularAttribute<AbstractTerminal, String> fuenteTermino;
    public static volatile SingularAttribute<AbstractTerminal, String> unidadPlacas;
    public static volatile SingularAttribute<AbstractTerminal, String> fuenteDesconectado;
    public static volatile SingularAttribute<AbstractTerminal, Date> ultimoLocalizacionFecha;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> coordenadasDesdeBase;
    public static volatile SingularAttribute<AbstractTerminal, Integer> intervaloPoolMinutos;
    public static volatile SingularAttribute<AbstractTerminal, Base> base;
    public static volatile SingularAttribute<AbstractTerminal, Date> fechaModificacion;
    public static volatile SingularAttribute<AbstractTerminal, Usuario> usuario;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> tag;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> asistenciaVial;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> reporteSiicaAv;
    public static volatile SingularAttribute<AbstractTerminal, String> sinPosicionActual;
    public static volatile SingularAttribute<AbstractTerminal, GeocercaByEstado > geocercaByEstado;
    public static volatile SingularAttribute<AbstractTerminal, String> androidUid;  
    public static volatile SingularAttribute<AbstractTerminal, Boolean> emailAtraso;
	public static volatile SingularAttribute<AbstractTerminal, ReporteMovilSac> sacNumeroReporte;
	public static volatile SingularAttribute<AbstractTerminal, String> tipoAsistenciaVial;
	public static volatile SingularAttribute<AbstractTerminal, String> reporteApartado;
	public static volatile SingularAttribute<AbstractTerminal, Date> fechaPush;
// Add for Horarios
    public static volatile SingularAttribute<AbstractHorarioGrupo, Grupo> grupo;
    public static volatile SingularAttribute<AbstractTerminal, String> subGrupo;
	public static volatile SingularAttribute<AbstractTerminal, String> diaDescanso;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> guardia;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> moto;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> equipoPesado;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> vistoAlarma;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> incapacidad;
    public static volatile SingularAttribute<AbstractTerminal, String> diasIncapacidad;
    public static volatile SingularAttribute<AbstractTerminal, Boolean> vacaciones;
    public static volatile SingularAttribute<AbstractTerminal, String> diasVacaciones;
    public static volatile SingularAttribute<AbstractTerminal, String> cedulaAjustador;
// Nuevos 17 
    public static volatile SingularAttribute<AbstractTerminal, String> programa;
    public static volatile SingularAttribute<AbstractTerminal, String> noEmpleado;
    public static volatile SingularAttribute<AbstractTerminal, String> coordinador;
    public static volatile SingularAttribute<AbstractTerminal, String> supervisor;
    public static volatile SingularAttribute<AbstractTerminal, String> fechaIngreso;
    public static volatile SingularAttribute<AbstractTerminal, String> noLicencia;
    public static volatile SingularAttribute<AbstractTerminal, String> vigenciaLicencia;
    public static volatile SingularAttribute<AbstractTerminal, String> noTarjetaGasolina;
    public static volatile SingularAttribute<AbstractTerminal, String> noTag;
    public static volatile SingularAttribute<AbstractTerminal, String> gps;
    public static volatile SingularAttribute<AbstractTerminal, String> telefonoPersonal;
    public static volatile SingularAttribute<AbstractTerminal, String> dirCalle;
    public static volatile SingularAttribute<AbstractTerminal, String> dirNumero;
    public static volatile SingularAttribute<AbstractTerminal, String> dirColonia;
    public static volatile SingularAttribute<AbstractTerminal, Estado> dirEstado;
    public static volatile SingularAttribute<AbstractTerminal, String> dirCP;
    public static volatile SingularAttribute<AbstractTerminal, String> rfc;
    public static volatile SingularAttribute<AbstractTerminal, String> conceptos;
    public static volatile SingularAttribute<AbstractTerminal, Usuario> usuarioModif;

    


}
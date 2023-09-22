package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Map;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.sisesac.SegundasAtencion;
import com.aaq.col.clases.pojo.aaq.ExamenTEP;
import com.aaq.col.clases.sac.model.ConfirmarGruaSac;
import com.aaq.col.clases.sac.model.DatosArriboSac;
import com.aaq.col.clases.sac.model.DatosDispositivoMovilFolio;
import com.aaq.col.clases.sac.model.DatosFolioHospitalAmbulancia;
import com.aaq.col.clases.sac.model.DatosGestionSac;
import com.aaq.col.clases.sac.model.DatosSolicitudAbogado;
import com.aaq.col.clases.sac.model.DatosTerminoSac;
import com.aaq.col.clases.webservices.wscabina.reporte.RequestArca;
import com.aaq.col.clases.webservices.wscabina.reporte.RequestPemex;
import com.aaq.col.clases.webservices.wscabina.siniestro.AperturaEstimacion;
import com.aaq.col.clases.xml.webservices.JMWSDatosCFE;
import com.aaq.col.clases.xml.webservices.JMWSDatosCapufe;
import com.aaq.col.clases.xml.webservices.JMWSDatosCartaCob;


public interface SacSP_DaoInterfase {
	
	public String arriboSac(DatosArriboSac entradas);
	public Map<String, String>  terminoSac(DatosTerminoSac entradas, Terminal term);
	public Map<String, String> gestionSac(DatosGestionSac entradas, Terminal term);
	public Map<String, Object> dispositivoMovilFolio(DatosDispositivoMovilFolio entradas, Terminal term);
	public Map<String, Object> dispositivoMovilFolioHospitalAmbulancia(DatosFolioHospitalAmbulancia entradas, String claveProveedor, Terminal term, Boolean persona);
	public Map<String, Object> insertarCoberturaEstimacion(AperturaEstimacion entradas, String numeroSiniestro);
	public String insertarCuentasEspecialesArca(RequestArca entradas, String tipo, String usuario, String password);
	public String insertarCuentasEspecialesCapufe(JMWSDatosCapufe entradas, String tipo, String usuario, String password);
	public String insertarCuentasEspecialesCFE(JMWSDatosCFE entradas, String tipo, String usuario, String password);
	public String insertarCuentasEspecialesPemex(RequestPemex entradas, String tipo, String usuario, String password);
	public String dispositivoMovilVisto(String numeroReporte);
	public Map<String, Object> solicitudAbogado(DatosSolicitudAbogado solicitudAbogado, Terminal term);
	public String insertarCuentasEspecialesCartaCob(JMWSDatosCartaCob  entradas, String usuario, String password); 
	public String insertarIdealease( String licencia, String reporte, String tipo);
	public String confirmarGrua(ConfirmarGruaSac entrada);
	public String segundaAtencion(SegundasAtencion entrada);
	public String solicitarTicketCondi(Terminal terminal, String reporte, String claveCondicion) ;
	public abstract String examenToxicologicoSAC(Terminal terminal, ExamenTEP entrada);
	public abstract Map<String, Object> dispositivoMovilFolio2(DatosDispositivoMovilFolio entradas);

}

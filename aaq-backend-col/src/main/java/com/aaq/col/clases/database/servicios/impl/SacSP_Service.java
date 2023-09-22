package com.aaq.col.clases.database.servicios.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.SacSP_Dao;
import com.aaq.col.clases.database.servicios.interfase.SacSP_ServiceInterfase;
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

@Service("sacSPService")
@Transactional("sacTransactionManager")
public class SacSP_Service implements SacSP_ServiceInterfase{
	
	@Autowired
	private SacSP_Dao sacSP_Dao;

	@Override
	public String arriboSac(DatosArriboSac entradas) {
		return sacSP_Dao.arriboSac(entradas);
	}

	@Override
	public Map<String, String> terminoSac(DatosTerminoSac entradas, Terminal term) {
	    return sacSP_Dao.terminoSac(entradas, term);
	}
	
	@Override
	public  Map<String, String> gestionSac(DatosGestionSac entradas, Terminal term) {
		return sacSP_Dao.gestionSac(entradas, term);
	}
	
	@Override
	public Map<String, Object> dispositivoMovilFolio(DatosDispositivoMovilFolio entradas, Terminal term){
		return sacSP_Dao.dispositivoMovilFolio(entradas, term);
	}
	
	@Override
	public Map<String, Object> dispositivoMovilFolioHospitalAmbulancia(DatosFolioHospitalAmbulancia entradas, String claveProveedor, Terminal term, Boolean persona){
		return sacSP_Dao.dispositivoMovilFolioHospitalAmbulancia(entradas, claveProveedor, term, persona);
	}
	
	@Override
	public Map<String, Object> insertarCoberturaEstimacion(AperturaEstimacion entradas, String numeroSiniestro) {
		return sacSP_Dao.insertarCoberturaEstimacion(entradas, numeroSiniestro);
	}

	@Override
	public String insertarCuentasEspecialesArca(RequestArca entradas, String tipo, String usuario, String password) {
		return sacSP_Dao.insertarCuentasEspecialesArca(entradas, tipo, usuario, password);
	}
	
	@Override
	public String insertarCuentasEspecialesCapufe(JMWSDatosCapufe entradas, String tipo, String usuario, String password) {
		return sacSP_Dao.insertarCuentasEspecialesCapufe(entradas, tipo, usuario, password);
	}
	
	@Override
	public String insertarCuentasEspecialesCFE(JMWSDatosCFE entradas, String tipo, String usuario, String password) {
		return sacSP_Dao.insertarCuentasEspecialesCFE(entradas, tipo, usuario, password);
	}
	
	@Override
	public String insertarCuentasEspecialesPemex(RequestPemex entradas, String tipo, String usuario, String password) {
		return sacSP_Dao.insertarCuentasEspecialesPemex(entradas, tipo, usuario, password);
	}
	
	@Override
	public String dispositivoMovilVisto(String numeroReporte){
		return sacSP_Dao.dispositivoMovilVisto(numeroReporte);
	}

	@Override
	public Map<String, Object> solicitudAbogado(DatosSolicitudAbogado solicitudAbogado, Terminal term) {
		return sacSP_Dao.solicitudAbogado(solicitudAbogado, term);
	}
	
	@Override
	public String insertarCuentasEspecialesCartaCob(JMWSDatosCartaCob  entradas, String usuario, String password) {
		return sacSP_Dao.insertarCuentasEspecialesCartaCob(entradas, usuario, password);
	}

	@Override
	public String insertarIdealease(String licencia, String reporte, String tipo) {
		return sacSP_Dao.insertarIdealease(licencia, reporte, tipo);
	}

	@Override
	public String confirmarGrua(ConfirmarGruaSac entrada) {
		return sacSP_Dao.confirmarGrua(entrada);
	}

	@Override
	public String solicitarTicketCondiciones(Terminal terminal, String codicionEspecial)  {
		return sacSP_Dao.solicitarTicketCondi(terminal, terminal.getReporteSac().getGeneralNumeroReporte(), codicionEspecial);
	}

	@Override
	public String examenToxicologicoSAC(Terminal terminal, ExamenTEP entrada) {
		return sacSP_Dao.examenToxicologicoSAC(terminal, entrada);
	}
	
	@Override
	public Map<String, Object> dispositivoMovilFolio2(DatosDispositivoMovilFolio entradas) {
		return sacSP_Dao.dispositivoMovilFolio2(entradas);
	}
}

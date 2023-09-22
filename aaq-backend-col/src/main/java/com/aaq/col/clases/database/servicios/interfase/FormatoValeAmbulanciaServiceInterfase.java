package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoValeAmbulancia;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoValeAmbulanciaServiceInterfase extends JMServicioGenericoInterfase<FormatoValeAmbulancia> {

	public abstract FormatoValeAmbulancia objetoFormatoValeAmbulancia(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoValeAmbulancia t);
	public abstract List<FormatoValeAmbulancia> listaDeFormatoValeAmbulancia();
	public abstract String ejecutarFuncionInsertarValeAmbulancia(String vaAsegurado, String vaClaveAjustador,
			String vaDatosConductor, String vaDatosLesionado, String vaDiagnostico, String vaDirPaciente,
			String vaEdadPaciente, String vaFolioElectro, Date vaHora, String vaHospital, String vaLugar,
			String vaNomAjustador, String vaNomPaciente, String vaNomRazon, String vaNumEndoso, String vaNumInciso,
			String vaNumPoliza, String vaNumReporte, String vaNumSiniestro, String vaSexo, String vaTelPaciente,
			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaConductor, String firmaLesionado
	);
	public abstract int obtenerConsecutivo(String reporte);

}
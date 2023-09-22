package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoValeAmbulancia;
import com.aaq.col.clases.database.repositorios.impl.FormatoValeAmbulanciaDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoValeAmbulanciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoValeAmbulanciaService")
@Transactional
public class FormatoValeAmbulanciaService implements FormatoValeAmbulanciaServiceInterfase {
	
	@Autowired
	@Qualifier("formatoValeAmbulanciaDao")
	FormatoValeAmbulanciaDao formatoValeAmbulanciaDao;

	@Override
	public FormatoValeAmbulancia objetoFormatoValeAmbulancia(String id) {
		return this.formatoValeAmbulanciaDao.objetoFormatoValeAmbulancia(id);
	}

	@Override
	public String ejecutarFuncionInsertarValeAmbulancia(

			String vaAsegurado, String vaClaveAjustador, String vaDatosConductor, String vaDatosLesionado,
			String vaDiagnostico, String vaDirPaciente, String vaEdadPaciente, String vaFolioElectro, Date vaHora,
			String vaHospital, String vaLugar, String vaNomAjustador, String vaNomPaciente, String vaNomRazon,
			String vaNumEndoso, String vaNumInciso, String vaNumPoliza, String vaNumReporte, String vaNumSiniestro,
			String vaSexo, String vaTelPaciente, String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaConductor, String firmaLesionado

	) {
		return this.formatoValeAmbulanciaDao.ejecutarFuncionInsertarValeAmbulancia(

				vaAsegurado, vaClaveAjustador, vaDatosConductor, vaDatosLesionado, vaDiagnostico, vaDirPaciente,
				vaEdadPaciente, vaFolioElectro, vaHora, vaHospital, vaLugar, vaNomAjustador, vaNomPaciente, vaNomRazon,
				vaNumEndoso, vaNumInciso, vaNumPoliza, vaNumReporte, vaNumSiniestro, vaSexo, vaTelPaciente,
				emailDefault, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaConductor, firmaLesionado);
	}

	@Override
	public List<FormatoValeAmbulancia> listaDeFormatoValeAmbulancia() {
		return this.formatoValeAmbulanciaDao.listaDeFormatoValeAmbulancia();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoValeAmbulancia t) {

		return this.formatoValeAmbulanciaDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoValeAmbulanciaDao.obtenerConsecutivo(reporte);

	}

}
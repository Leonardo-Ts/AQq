package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.aaq.col.clases.database.repositorios.impl.FormatoOrdenServicioDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoOrdenServicioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoOrdenServicioService")
@Transactional
public class FormatoOrdenServicioService implements FormatoOrdenServicioServiceInterfase {
	
	@Autowired
	@Qualifier("formatoOrdenServicioDao")
	FormatoOrdenServicioDao formatoOrdenServicioDao;

	@Override
	public FormatoOrdenServicio objetoFormatoOrdenServicio(String id) {
		return this.formatoOrdenServicioDao.objetoFormatoOrdenServicio(id);
	}

	@Override
	public String ejecutarFuncionInsertarFormatoServicio(

			Date osFechaAtencion, String osSexoConductor, String osPoliza, String osTipoAuto, String osNumInciso,
			String osPlacasAuto, String osNumReporte, Integer osEdadConductor, Timestamp osHoraArribo,
			String osNomAjustador, String osTelConductor, Timestamp osHoraTermino, Integer osTipoServicio,
			String osEmailConductor, String osLugarServicio, Integer osSurtidoCombustible, Timestamp osHoraReporte,
			Integer osId, String osNumSiniestro, String osInformeAjustador, String osNomConductor, String osModeloAuto,
			String osClave, String osNumSerieAuto, String osAsegurado, String osMarcaAuto, String osAnioAuto,

			Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		return this.formatoOrdenServicioDao.ejecutarFuncionInsertarFormatoServicio(

				osFechaAtencion, osSexoConductor, osPoliza, osTipoAuto, osNumInciso, osPlacasAuto, osNumReporte,
				osEdadConductor, osHoraArribo, osNomAjustador, osTelConductor, osHoraTermino, osTipoServicio,
				osEmailConductor, osLugarServicio, osSurtidoCombustible, osHoraReporte, osId, osNumSiniestro,
				osInformeAjustador, osNomConductor, osModeloAuto, osClave, osNumSerieAuto, osAsegurado, osMarcaAuto,
				osAnioAuto, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado

		);
	}

	@Override
	public List<FormatoOrdenServicio> listaDeFormatoOrdenServicio() {
		return this.formatoOrdenServicioDao.listaDeFormatoOrdenServicio();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoOrdenServicio t) {

		return this.formatoOrdenServicioDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoOrdenServicioDao.obtenerConsecutivo(reporte);
	}

}
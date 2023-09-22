package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoOrdenServicioServiceInterfase extends JMServicioGenericoInterfase<FormatoOrdenServicio> {

	public FormatoOrdenServicio objetoFormatoOrdenServicio(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoOrdenServicio t);
	public abstract List<FormatoOrdenServicio> listaDeFormatoOrdenServicio();
	public abstract String ejecutarFuncionInsertarFormatoServicio(Date osFechaAtencion, String osSexoConductor,
			String osPoliza, String osTipoAuto, String osNumInciso, String osPlacasAuto, String osNumReporte,
			Integer osEdadConductor, Timestamp osHoraArribo, String osNomAjustador, String osTelConductor,
			Timestamp osHoraTermino, Integer osTipoServicio, String osEmailConductor, String osLugarServicio,
			Integer osSurtidoCombustible, Timestamp osHoraReporte, Integer osId, String osNumSiniestro,
			String osInformeAjustador, String osNomConductor, String osModeloAuto, String osClave,
			String osNumSerieAuto, String osAsegurado, String osMarcaAuto, String osAnioAuto, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado
	);
	public abstract int obtenerConsecutivo(String reporte);

}
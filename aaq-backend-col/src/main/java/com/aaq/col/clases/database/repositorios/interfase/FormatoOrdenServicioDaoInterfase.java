 package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoOrdenServicio;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoOrdenServicioDaoInterfase extends JMRepositorioGenericoInterfase<FormatoOrdenServicio> {

	
	public abstract FormatoOrdenServicio objetoFormatoOrdenServicio(final String id);
	public abstract List<FormatoOrdenServicio> listaDeFormatoOrdenServicio();
	public abstract String ejecutarFuncionInsertarFormatoServicio(
			Date osFechaAtencion, String osSexoConductor, String osPoliza, String osTipoAuto, String osNumInciso,
			String osPlacasAuto, String osNumReporte, Integer osEdadConductor, Timestamp osHoraArribo,
			String osNomAjustador, String osTelConductor, Timestamp osHoraTermino, Integer osTipoServicio,
			String osEmailConductor, String osLugarServicio, Integer osSurtidoCombustible, Timestamp osHoraReporte,
			Integer osId, String osNumSiniestro, String osInformeAjustador, String osNomConductor, String osModeloAuto,
			String osClave, String osNumSerieAuto, String osAsegurado, String osMarcaAuto, String osAnioAuto,
			Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado
	);
	public abstract String InsertarFormatoOrdenServicio(DatosInsertarFormatoOrdenServicio entradas);
	public abstract String ejecutarFuncionWebserviceStoreFOS(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);
}
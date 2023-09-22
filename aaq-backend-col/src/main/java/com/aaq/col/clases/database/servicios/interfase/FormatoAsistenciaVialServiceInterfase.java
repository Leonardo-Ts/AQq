package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoAsistenciaVialServiceInterfase extends JMServicioGenericoInterfase<FormatoAsistenciaVial> {

	public abstract FormatoAsistenciaVial objetoFormatoAsistenciaVial(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoAsistenciaVial t);
	public abstract List<FormatoAsistenciaVial> listaDeFormatoAsistenciaVial();
	public abstract String ejecutarFuncionInsertarAsistenciaVial(
			String avAsegurado, String avNumInciso, String avNomAsegurado, Date avFecha, String avNumPoliza,
			String avClaveAjustador, String avEmail, Integer avPregunta6, String avPregunta5, Integer avPregunta4,
			Integer avPregunta3, Integer avPregunta2, Integer avPregunta1, String avNumReporte, Integer avId,
			String avComentarios, Integer avPregunta7, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado);
	public abstract int obtenerConsecutivo(String reporte);
}
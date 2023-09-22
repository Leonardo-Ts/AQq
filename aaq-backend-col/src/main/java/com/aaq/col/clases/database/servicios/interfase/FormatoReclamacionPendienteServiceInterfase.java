 package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoReclamacionPendienteServiceInterfase
		extends JMServicioGenericoInterfase<FormatoReclamacionPendiente> {

	public abstract FormatoReclamacionPendiente objetoFormatoReclamacionPendiente(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoReclamacionPendiente t);
	public abstract List<FormatoReclamacionPendiente> listaDeFormatoReclamacionPendiente();
	public abstract String ejecutarFuncionInsertarReclamacionPendiente(String rpNumReporte, String rpNombreConductor,
			Integer rpDfEndoso, String rpAsegurado, String rpObservaciones, String rpObsEndosoAclara, Integer rpOtros,
			String rpNumReclamacion, Integer rpId, String rpNomAjustador, Integer rpCopiaActaMp, Date rpFecha,
			Integer rpReciboPago, Integer rpLicencia, String rpClaveAjustador, String rpNomConductor,
			String rpNumInciso, String rpNumPoliza, String emailDefault, Integer rpPolizaVigente, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado
	);
	public abstract int obtenerConsecutivo(String reporte);

}
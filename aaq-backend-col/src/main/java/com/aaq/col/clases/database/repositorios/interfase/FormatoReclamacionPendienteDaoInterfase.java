package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionPendiente;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface FormatoReclamacionPendienteDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoReclamacionPendiente> {

	public abstract FormatoReclamacionPendiente objetoFormatoReclamacionPendiente(final String id);
	public abstract List<FormatoReclamacionPendiente> listaDeFormatoReclamacionPendiente();
	public abstract String ejecutarFuncionInsertarReclamacionPendiente(String rpNumReporte, String rpNombreConductor,
			Integer rpDfEndoso, String rpAsegurado, String rpObservaciones, String rpObsEndosoAclara, Integer rpOtros,
			String rpNumReclamacion, Integer rpId, String rpNomAjustador, Integer rpCopiaActaMp, Date rpFecha,
			Integer rpReciboPago, Integer rpLicencia, String rpClaveAjustador, String rpNomConductor,
			String rpNumInciso, String rpNumPoliza, String emailDefault, Integer rpPolizaVigente, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado
	);
	public abstract String ejecutarFuncionWebserviceStoreFRP(Map<String, String> entry);
	public abstract String InsertarFormatoReclamacionPendiente(DatosInsertarFormatoReclamacionPendiente entrada);
	public abstract int obtenerConsecutivo(String reporte);

}
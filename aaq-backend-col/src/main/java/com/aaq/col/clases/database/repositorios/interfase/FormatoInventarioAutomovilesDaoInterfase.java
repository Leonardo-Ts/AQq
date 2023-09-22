 package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoInventarioAutomoviles;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioAutomoviles;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoInventarioAutomovilesDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoInventarioAutomoviles> {

	public abstract FormatoInventarioAutomoviles objetoFormatoInventarioAutomoviles(final String id);
	public abstract List<FormatoInventarioAutomoviles> listaDeFormatoInventarioAutomoviles();
	public abstract String ejecutarFuncionInsertarInventarioAutomoviles(

			String iaNumReporte, String iaTipoAuto, String iaAsegurado, Timestamp iaHora, String iaInventario1,
			String iaInventario2, String iaInventario3, String iaInventario4, String iaInventario5,
			String iaNomAjustador, String iaNumMotor, String iaAnioAuto, String iaNomAsegurado, String iaNumSiniestro,
			String iaDirDestino, String iaCantidad, String iaObservacion, Integer iaId, Integer iaPuertasAuto,
			String iaClaveAjustador, String iaColorAuto, String iaMarcaAuto, String iaNomDestino, String iaKilometraje,
			Integer iaVidaLlantas, String iaNumSerie, Integer iaCombustible, String iaNumInciso, String iaNumPoliza,
			String iaDesAuto,

			String iaNomOperador,

			String iaNomRazon,

			Integer iaLlaves, String iaPlacasAuto, Integer iaTManual, Integer iaDestino, String emailDefault,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer iaObjetosPer, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado,
			String firmaOperRecibe, String firmaAjusRecibe, String niu, String iaCorreoGrua, String iaCorreoTaller

	);
	public abstract String InsertarFormatoInventarioAutomoviles(DatosInsertarFormatoInventarioAutomoviles entrada);
	public abstract String ejecutarFuncionWebserviceStoreFIA(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}
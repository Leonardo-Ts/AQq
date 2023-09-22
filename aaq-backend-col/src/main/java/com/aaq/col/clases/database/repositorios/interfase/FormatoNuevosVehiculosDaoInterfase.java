package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoNuevosVehiculos;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoNuevosVehiculos;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface FormatoNuevosVehiculosDaoInterfase extends JMRepositorioGenericoInterfase<FormatoNuevosVehiculos> {

	public abstract FormatoNuevosVehiculos objetoFormatoNuevosVehiculos(final String id);
	public abstract List<FormatoNuevosVehiculos> listaDeFormatoNuevosVehiculos();
	public abstract String ejecutarFuncionInsertarNuevosVehiculos(String nvPlacas, Integer nvId,

			String nvAsegurado, String nvClaveAjustador, Integer nvDerivadaAuto,

			String nvEmail, Date nvFecha, Date nvFechaInspeccion, Integer nvFotoMotor, Integer nvFotoSerie,
			Timestamp nvHora, String nvKilometrosAuto, String nvModeloAuto, String nvMotorAuto,
			String nvNombreAjustador, String nvNombreCliente, String nvNumInciso, String nvNumPoliza,
			String nvNumReporte, String nvNumSerieAuto, String nvObservacionesAuto, String nvOficna,
			Integer nvProcedenciaAuto, String nvPuertasAuto, String nvSolicitante, String nvTelSolicitante,
			String nvTipoAuto, Integer nvTipoEmpleado, Integer nvTotalFotos, String nvTransmisionAuto,
			String nvUbicacion, String nvUnidadAuto, Integer enviadoEmail, ////
			String mensajeEmail, String nvDaniosPre, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaCliente,
			String firmaAgente

	);
	public abstract String InsertarFormatoNuevosVehiculos(DatosInsertarFormatoNuevosVehiculos entrada);
	public abstract String ejecutarFuncionWebserviceStoreFNV(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}
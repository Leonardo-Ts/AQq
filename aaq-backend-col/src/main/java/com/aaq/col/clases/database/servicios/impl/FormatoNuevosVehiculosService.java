package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoNuevosVehiculos;
import com.aaq.col.clases.database.repositorios.impl.FormatoNuevosVehiculosDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoNuevosVehiculosServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoNuevosVehiculosService")
@Transactional
public class FormatoNuevosVehiculosService implements FormatoNuevosVehiculosServiceInterfase {
	
	@Autowired
	@Qualifier("formatoNuevosVehiculosDao")
	FormatoNuevosVehiculosDao formatoNuevosVehiculosDao;

	@Override
	public FormatoNuevosVehiculos objetoFormatoNuevosVehiculos(String id) {
		return this.formatoNuevosVehiculosDao.objetoFormatoNuevosVehiculos(id);
	}

	@Override
	public String ejecutarFuncionInsertarNuevosVehiculos(

			String nvPlacas, Integer nvId,

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

	) {
		return this.formatoNuevosVehiculosDao.ejecutarFuncionInsertarNuevosVehiculos(

				nvPlacas, nvId,

				nvAsegurado, nvClaveAjustador, nvDerivadaAuto,

				nvEmail, nvFecha, nvFechaInspeccion, nvFotoMotor, nvFotoSerie, nvHora, nvKilometrosAuto, nvModeloAuto,
				nvMotorAuto, nvNombreAjustador, nvNombreCliente, nvNumInciso, nvNumPoliza, nvNumReporte, nvNumSerieAuto,
				nvObservacionesAuto, nvOficna, nvProcedenciaAuto, nvPuertasAuto, nvSolicitante, nvTelSolicitante,
				nvTipoAuto, nvTipoEmpleado, nvTotalFotos, nvTransmisionAuto, nvUbicacion, nvUnidadAuto, enviadoEmail, ////
				mensajeEmail, nvDaniosPre,

				proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaCliente,
				firmaAgente

		);
	}

	@Override
	public List<FormatoNuevosVehiculos> listaDeFormatoNuevosVehiculos() {
		return this.formatoNuevosVehiculosDao.listaDeFormatoNuevosVehiculos();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoNuevosVehiculos t) {

		return this.formatoNuevosVehiculosDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoNuevosVehiculosDao.obtenerConsecutivo(reporte);
	}

}
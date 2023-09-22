package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoInventarioAutomoviles;
import com.aaq.col.clases.database.repositorios.impl.FormatoInventarioAutomovilesDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoInventarioAutomovilesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoInventarioAutomovilesService")
@Transactional
public class FormatoInventarioAutomovilesService implements FormatoInventarioAutomovilesServiceInterfase {
	
	@Autowired
	@Qualifier("formatoInventarioAutomovilesDao")
	FormatoInventarioAutomovilesDao formatoInventarioAutomovilesDao;

	@Override
	public FormatoInventarioAutomoviles objetoFormatoInventarioAutomoviles(String id) {
		return this.formatoInventarioAutomovilesDao.objetoFormatoInventarioAutomoviles(id);
	}

	@Override
	public String ejecutarFuncionInsertarInventarioAutomoviles(String iaNumReporte, String iaTipoAuto,
			String iaAsegurado, Timestamp iaHora, String iaInventario1, String iaInventario2, String iaInventario3,
			String iaInventario4, String iaInventario5, String iaNomAjustador, String iaNumMotor, String iaAnioAuto,
			String iaNomAsegurado, String iaNumSiniestro, String iaDirDestino, String iaCantidad, String iaObservacion,
			Integer iaId, Integer iaPuertasAuto, String iaClaveAjustador, String iaColorAuto, String iaMarcaAuto,
			String iaNomDestino, String iaKilometraje, Integer iaVidaLlantas, String iaNumSerie, Integer iaCombustible,
			String iaNumInciso, String iaNumPoliza, String iaDesAuto, String iaNomOperador, String iaNomRazon,
			Integer iaLlaves, String iaPlacasAuto, Integer iaTManual, Integer iaDestino, String emailDefault,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer iaObjetosPer, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado,
			String firmaOperRecibe, String firmaAjusRecibe, String niu, String iaCorreoGrua, String iaCorreoTaller

	) {
		return this.formatoInventarioAutomovilesDao.ejecutarFuncionInsertarInventarioAutomoviles(

				iaNumReporte, iaTipoAuto, iaAsegurado, iaHora, iaInventario1, iaInventario2, iaInventario3,
				iaInventario4, iaInventario5, iaNomAjustador, iaNumMotor, iaAnioAuto, iaNomAsegurado, iaNumSiniestro,
				iaDirDestino, iaCantidad, iaObservacion, iaId, iaPuertasAuto, iaClaveAjustador, iaColorAuto,
				iaMarcaAuto, iaNomDestino, iaKilometraje, iaVidaLlantas, iaNumSerie, iaCombustible, iaNumInciso,
				iaNumPoliza, iaDesAuto, iaNomOperador, iaNomRazon,

				iaLlaves, iaPlacasAuto, iaTManual, iaDestino, emailDefault, enviadoEmail, ////
				mensajeEmail, ///
				iaObjetosPer, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAsegurado, firmaOperRecibe, firmaAjusRecibe, niu, iaCorreoGrua, iaCorreoTaller

		);
	}

	@Override
	public List<FormatoInventarioAutomoviles> listaDeFormatoInventarioAutomoviles() {
		return this.formatoInventarioAutomovilesDao.listaDeFormatoInventarioAutomoviles();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoInventarioAutomoviles t) {

		return this.formatoInventarioAutomovilesDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoInventarioAutomovilesDao.obtenerConsecutivo(reporte);
	}

}
package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.aaq.col.clases.database.repositorios.impl.FormatoObservacionesAseguradoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoObservacionesAseguradoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoObservacionesAseguradoService")
@Transactional
public class FormatoObservacionesAseguradoService implements FormatoObservacionesAseguradoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoObservacionesAseguradoDao")
	FormatoObservacionesAseguradoDao formatoObservacionesAseguradoDao;

	@Override
	public FormatoObservacionesAsegurado objetoFormatoObservacionesAsegurado(String id) {
		return this.formatoObservacionesAseguradoDao.objetoFormatoObservacionesAsegurado(id);
	}

//	@Override
//	public String ejecutarFuncionInsertarObservacionesAsegurado(
//			 String FOA_NUM_REPORTE,
//			 String FOA_NUM_SINIESTRO,
//			 String FOA_NUM_POLIZA,
//			 String FOA_NUM_ASEGURADO,
//			 String FOA_NOM_AJUSTADOR,
//			 String FOA_OBSERVACIONES,
//			 String FOA_NOM_CONDUCTOR,
//			 String FOA_TELEFONO,
//			 String FOA_CORREO_CONDUCTOR,
//			 String FOA_CLAVE_AJUSTADOR,
//			 Date FOA_FECHA,
//			 String FOA_LUGAR,
//			 Integer CHECK_1,
//			 Integer CHECK_2,
//			 Integer CHECK_3,
//			 Integer CHECK_4,
//			 String FIRMA_CONDUCTOR,
//			 Integer check_1, 
//			 Integer check_2,
//			 Integer check_3, 
//			 Integer check_4, 
//			 Integer enviadoEmail,
//			 String mensajeEmail,
//			 Integer proceso,
//			 Timestamp horaEnvioEmail,
//			 Timestamp horaEnvioSftp,
//			 String nodoEnvio,
//			 Integer numConsecutivo
//
//	) {
//		return this.formatoObservacionesAseguradoDao.ejecutarFuncionInsertarObservacionesAsegurado(
//				  FOA_NUM_REPORTE,
//				  FOA_NUM_SINIESTRO,
//				  FOA_NUM_POLIZA,
//				  FOA_NUM_ASEGURADO,
//				  FOA_NOM_AJUSTADOR,
//				  FOA_OBSERVACIONES,
//				  FOA_NOM_CONDUCTOR,
//				  FOA_TELEFONO,
//				  FOA_CORREO_CONDUCTOR,
//				  FOA_CLAVE_AJUSTADOR,
//				  FOA_FECHA,
//				  FOA_LUGAR,
//				  CHECK_1,
//				  CHECK_2,
//				  CHECK_3,
//				  CHECK_4,
//				  FIRMA_CONDUCTOR,
//				  check_1, 
//				  check_2,
//				  check_3, 
//				  check_4, 
//				  enviadoEmail,
//				  mensajeEmail,
//				  proceso,
//				  horaEnvioEmail,
//				  horaEnvioSftp,
//				  nodoEnvio,
//				  numConsecutivo
//
//		);
//	}

	
	@Override
	public List<FormatoObservacionesAsegurado> listaDeFormatoObservacionesAsegurado() {
		return this.formatoObservacionesAseguradoDao.listaDeFormatoObservacionesAsegurado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoObservacionesAsegurado t) {

		return this.formatoObservacionesAseguradoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoObservacionesAseguradoDao.obtenerConsecutivo(reporte);

	}
}
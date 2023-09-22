package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.database.repositorios.impl.FormatoReparacionBienesDiversosDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReparacionBienesDiversosServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReparacionBienesDiversosService")
@Transactional
public class FormatoReparacionBienesDiversosService implements FormatoReparacionBienesDiversosServiceInterfase {
	
	@Autowired
	@Qualifier("formatoReparacionBienesDiversosDao")
	FormatoReparacionBienesDiversosDao formatoReparacionBienesDiversosDao;

	@Override
	public FormatoReparacionBienesDiversos objetoFormatoReparacionBienesDiversos(String id) {
		return this.formatoReparacionBienesDiversosDao.objetoFormatoReparacionBienesDiversos(id);
	}

	
	/*@Override
	public String ejecutarFuncionInsertarReparacionBienesDiversos(
			
			String bd_num_reporte, 
			String bd_num_siniestro,
			String bd_num_poliza,
			String bd_num_asegurado, 
			Date bd_fecha,
			String bd_nombre_afectado,
			String bd_tel_afectado,
			String bd_ubicacion_siniestro,
			String bd_domicilio_siniestro,
			String bd_telefono_siniestro,
			String bd_ubicacion_resguardo,
			String bd_domicilio_resguardo,
			String bd_telefono_resguardo,
			String bd_responsable,
			String bd_danios_diversos,			
			String bd_observaciones,
			String bd_long,
			String bd_alto,
			String bd_ancho,
			String bd_tipo, 
			String bd_serie, 
			String bd_tramo, 
			String bd_km, 
			String bd_descripcion_danios_can,
			String bd_des_danios_pre, 
			String bd_motivo, 
			String bd_correo, 
			String bd_nom_ajustador, 
			String bd_clave_ajustador, 
			String bd_nom_asegurado_tercero, 
			Integer check_1, 
			Integer check_2, 
			Integer check_3, 
			Integer check_4, 
			String ilustracion, 
			String firma_ajustador,
			String firma_asegurado_tercero,
			Integer enviadoFTP,
			 String FtpRespuesta,
			 Integer enviadoEmail,
			 String mensajeEmail,
			 Integer proceso,
			 Timestamp horaEnvioEmail,
			 Timestamp horaEnvioSftp,
			 String nodoEnvio,
			 Integer numConsecutivo

	) {
		return this.formatoReparacionBienesDiversosDao.ejecutarFuncionInsertarReparacionBienesDiversos(
				 bd_num_reporte, 
				 bd_num_siniestro,
				 bd_num_poliza,
				 bd_num_asegurado, 
				 bd_fecha,
				 bd_nombre_afectado,
				 bd_tel_afectado,
				 bd_ubicacion_siniestro,
				 bd_domicilio_siniestro,
				 bd_telefono_siniestro,
				 bd_ubicacion_resguardo,
				 bd_domicilio_resguardo,
				 bd_telefono_resguardo,
				 bd_responsable,
				 bd_danios_diversos,
				 bd_observaciones,
				 bd_long,
				 bd_alto,
				 bd_ancho,
				 bd_tipo, 
				 bd_serie, 
				 bd_tramo, 
				 bd_km, 
				 bd_descripcion_danios_can,
				 bd_des_danios_pre, 
				 bd_motivo, 
				 bd_correo, 
				 bd_nom_ajustador, 
				 bd_clave_ajustador, 
				 bd_nom_asegurado_tercero, 
				 check_1, 
				 check_2, 
				 check_3, 
				 check_4, 
				 ilustracion, 
				 firma_ajustador,
				 firma_asegurado_tercero,
				 enviadoFTP,
				  FtpRespuesta,
				  enviadoEmail,
				  mensajeEmail,
				  proceso,
				 horaEnvioEmail,
				 horaEnvioSftp,
				  nodoEnvio,
				  numConsecutivo

		);
	}*/
 
	
	@Override
	public List<FormatoReparacionBienesDiversos> listaDeFormatoReparacionBienesDiversos() {
		return this.formatoReparacionBienesDiversosDao.listaDeFormatoReparacionBienesDiversos();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReparacionBienesDiversos t) {

		return this.formatoReparacionBienesDiversosDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReparacionBienesDiversosDao.obtenerConsecutivo(reporte);

	}
}
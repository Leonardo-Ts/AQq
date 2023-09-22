package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoResponsabilidadCivil;
import com.aaq.col.clases.database.repositorios.impl.FormatoResponsabilidadCivilDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoResponsabilidadCivilServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoResponsabilidadCivilService")
@Transactional
public class FormatoResponsabilidadCivilService implements FormatoResponsabilidadCivilServiceInterfase {

	@Autowired
	@Qualifier("formatoResponsabilidadCivilDao")
	FormatoResponsabilidadCivilDao formatoResponsabilidadCivilDao;

	@Override
	public FormatoResponsabilidadCivil objetoFormatoResponsabilidadCivil(String id) {
		return this.formatoResponsabilidadCivilDao.objetoFormatoResponsabilidadCivil(id);
	}

	@Override
	public String ejecutarFuncionInsertarResponsabilidadCivil(
			 String rc_num_reporte,
			 String rc_num_siniestro, 
			 String rc_num_poliza,
			 String rc_num_asegurado,
			 Date rc_fecha_siniestro,
			 String rc_folio_dua,
			 Integer rc_vehiculo_q,  
			 String rc_compania_trans_mer,
			 String rc_reporte_vehiculo,
			 String rc_nom_propietario,
			 String rc_tel_propietario,
			 String rc_correo_propietario,  
			 String rc_nom_transportista, 
			 String rc_tel_transportista,
			 String rc_correo_transportista, 
			 String rc_dir_siniestro,
			 String rc_entidad_siniestro, 
			 String rc_dir_resguardo,
			 String rc_entidad_resguardo,
			 String rc_responsable, 
			 String rc_entidad_resp, 
			 String rc_tel_responsable, 
			 Integer rc_tipo_siniestro,
			 String rc_num_acta, 
			 String rc_descripcion_veh, 
			 String rc_nom_operador,  
			 Integer rc_opc_ebriedad, 
			 Integer rc_opc_licencia, 
			 String rc_dictamen,
			 Integer  rc_opc_carga_daniada,
			 String rc_descripcion_merc,
			 String rc_porcentaje_aprox,
			 String rc_opc_seguro_trans,
			 String rc_nom_aseguradora, 
			 Integer rc_opc_interviene_a, 
			 Integer rc_opc_traspaleo_c,
			 String rc_folio_carta,
			 String rc_folio_factura,  
			 String rc_folio_remision, 
			 String rc_folio_guia,
			 String rc_folio_mapa,
			 String rc_informe_ajustador,
			 String rc_nom_ajustador,
			 String rc_clave_ajustador, 
			 String rc_nom_asegurado_tercero, 
			 String rc_nom_asegurado, 
			 String rc_documentos_req, 
			 Integer check_1, 
			 Integer check_2,
			 Integer check_3, 
			 Integer check_4, 
			 String croquis,  
			 String firma_ajustador,
			 String firma_asegurado_tercero,
			 String firma_asegurado,
			 Integer enviadoEmail,
			 String mensajeEmail,
			 Integer proceso,
			 Timestamp horaEnvioEmail,
			 Timestamp horaEnvioSftp,
			 String nodoEnvio,
			 Integer numConsecutivo

	) {
		return this.formatoResponsabilidadCivilDao.ejecutarFuncionInsertarResponsabilidadCivil(
				  rc_num_reporte,
				  rc_num_siniestro, 
				  rc_num_poliza,
				  rc_num_asegurado,
				  rc_fecha_siniestro,
				  rc_folio_dua,
				  rc_vehiculo_q,  
				  rc_compania_trans_mer,
				  rc_reporte_vehiculo,
				  rc_nom_propietario,
				  rc_tel_propietario,
				  rc_correo_propietario,  
				  rc_nom_transportista, 
				  rc_tel_transportista,
				  rc_correo_transportista, 
				  rc_dir_siniestro,
				  rc_entidad_siniestro, 
				  rc_dir_resguardo,
				  rc_entidad_resguardo,
				  rc_responsable, 
				  rc_entidad_resp, 
				  rc_tel_responsable, 
				  rc_tipo_siniestro,
				  rc_num_acta, 
				  rc_descripcion_veh, 
				  rc_nom_operador,  
				  rc_opc_ebriedad, 
				  rc_opc_licencia, 
				  rc_dictamen,
				   rc_opc_carga_daniada,
				  rc_descripcion_merc,
				  rc_porcentaje_aprox,
				  rc_opc_seguro_trans,
				  rc_nom_aseguradora, 
				  rc_opc_interviene_a, 
				  rc_opc_traspaleo_c,
				  rc_folio_carta,
				  rc_folio_factura,  
				  rc_folio_remision, 
				  rc_folio_guia,
				  rc_folio_mapa,
				  rc_informe_ajustador,
				  rc_nom_ajustador,
				  rc_clave_ajustador, 
				  rc_nom_asegurado_tercero, 
				  rc_nom_asegurado, 
				  rc_documentos_req, 
				  check_1, 
				  check_2,
				  check_3, 
				  check_4, 
				  croquis,  
				  firma_ajustador,
				  firma_asegurado_tercero,
				  firma_asegurado,
				  enviadoEmail,
				  mensajeEmail,
				  proceso,
				  horaEnvioEmail,
				  horaEnvioSftp,
				  nodoEnvio,
				  numConsecutivo

		);
	}

	
	@Override
	public List<FormatoResponsabilidadCivil> listaDeFormatoResponsabilidadCivil() {
		return this.formatoResponsabilidadCivilDao.listaDeFormatoResponsabilidadCivil();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoResponsabilidadCivil t) {

		return this.formatoResponsabilidadCivilDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoResponsabilidadCivilDao.obtenerConsecutivo(reporte);

	}
}
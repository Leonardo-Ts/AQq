package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoResponsabilidadCivil;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoResponsabilidadCivilServiceInterfase
		extends JMServicioGenericoInterfase<FormatoResponsabilidadCivil> {

	public abstract FormatoResponsabilidadCivil objetoFormatoResponsabilidadCivil(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoResponsabilidadCivil t);
	public abstract List<FormatoResponsabilidadCivil> listaDeFormatoResponsabilidadCivil();
	public abstract String ejecutarFuncionInsertarResponsabilidadCivil(
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
	);
	public abstract int obtenerConsecutivo(String reporte);
}
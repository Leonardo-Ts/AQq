package com.aaq.col.clases.database.repositorios.impl;


import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.HistoricoRecuperosAjustador;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.HistoricoRecuperosAjustadorDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "historicoRecuperosAjustadorDao")
public class HistoricoRecuperosAjustadorDao extends SIICAServerGenericDaoJpaImpl<HistoricoRecuperosAjustador> implements
		HistoricoRecuperosAjustadorDaoInterfase {

	@Override
	public HistoricoRecuperosAjustador objetoHistoricoRecuperosAjustador(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(HistoricoRecuperosAjustador.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoHistoricoRecuperosAjustador", id);
		}
		return null;
	}


	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoRecuperosAjustadorNuevo(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado, 
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto) {


		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"HISTORICO_RECU_AJUS_ADD");

			nat.registerStoredProcedureParameter("in_clave_recupero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_descripcion_recupero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_total_vales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_aseguradora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_descripcion_aseguradora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_afectado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_folio_vale", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_monto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_descripcion_monto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_clave_recupero", claveRecupero);
			nat.setParameter("in_descripcion_recupero", descripcionRecupero);
			nat.setParameter("in_total_vales", totalVales);
			nat.setParameter("in_clave_aseguradora", claveAseguradora);
			nat.setParameter("in_descripcion_aseguradora", descripcionAseguradora);
			nat.setParameter("in_clave_ajustador", claveAjustador);
			nat.setParameter("in_reporte", reporte);
			nat.setParameter("in_afectado", afectado);
			nat.setParameter("in_numero_siniestro", numeroSiniestro);
			nat.setParameter("in_folio_vale", folioVale);
			nat.setParameter("in_monto", monto);
			nat.setParameter("in_descripcion_monto", descripcionMonto);

			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionHistoricoRecuperosAjustadorNuevo", claveRecupero, descripcionRecupero, totalVales, claveAseguradora,
					descripcionAseguradora, claveAjustador, reporte, afectado, numeroSiniestro, numeroSiniestro, folioVale, monto, descripcionMonto);
			return new JMResultadoOperacion(e);
		}
	}

}
package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.EncuestaAjustador;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractEncuestaAjustador_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.EncuestaAjustadorDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;

@org.springframework.stereotype.Repository(value = "encuestaAjustadorDao")
public class EncuestaAjustadorDao extends SIICAServerGenericDaoJpaImpl<EncuestaAjustador> implements EncuestaAjustadorDaoInterfase {
	
	 
	
	@Override
	public EncuestaAjustador objetoEncuestaAjustador(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(EncuestaAjustador.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoEncuestaAjustador", id);
		}
		return null;
	}
	
	@Override
	public List<EncuestaAjustador> listaDeEncuestaAjustador(
			Date fechaBusquedaInicial, Date fechaBusquedaFinal,
			Terminal claveA, String reporte,Estado estado,Base base,
			String poliza,Integer limite) {
		
			Date dateInicio = null;
			Date dateFin = null;
			
			try {
				
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<EncuestaAjustador> query = builder.createQuery(EncuestaAjustador.class);
				final Root<EncuestaAjustador> root = query.from(EncuestaAjustador.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if ((fechaBusquedaInicial != null) && (fechaBusquedaFinal != null)) {
					HoraConsultaUtil utileria = new HoraConsultaUtil();
					try {
						dateInicio = utileria.formatInicial(fechaBusquedaInicial);
						dateFin = utileria.formatFinal(fechaBusquedaFinal);
					} catch (Exception e) {
						this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
					}
					
					predicates.add(builder.between(root.get(AbstractEncuestaAjustador_.fecha), dateInicio,
							dateFin));
				}
				
				if (claveA !=null) {					
					predicates.add(builder.equal(root.get(AbstractEncuestaAjustador_.terminal), claveA));
				}
				if (StringUtils.isNotBlank(reporte)) {
					predicates.add(builder.equal(root.get(AbstractEncuestaAjustador_.numeroReporte), reporte));
				}
				
				if (StringUtils.isNotBlank(poliza)) {
					predicates.add(builder.equal(root.get(AbstractEncuestaAjustador_.poliza), poliza));
				}
				
				if (estado !=null) {		
					predicates.add(builder.equal(root.get(AbstractEncuestaAjustador_.estado), estado));
				}
				
				if (base !=null && base.getId()>0) {			
					predicates.add(builder.equal(root.get(AbstractEncuestaAjustador_.base), base));
				}
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.desc(root.get(AbstractEncuestaAjustador_.fecha)));
				//query.orderBy(builder.desc(root.get(AbstractEncuestaAjustador_.id)));
				final TypedQuery<EncuestaAjustador> typedQ = this.getEntityManager().createQuery(query);
				typedQ.setMaxResults(limite != null ? limite.intValue() : 100);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador", limite);
			}
			return new Vector<>();
	}
	
	@Override
	public List<EncuestaAjustador> listaDeEncuestaAjustadorSftp(){
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<EncuestaAjustador> query = builder.createQuery(EncuestaAjustador.class);
			final Root<EncuestaAjustador> root = query.from(EncuestaAjustador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			predicates.add(builder.or(builder.notEqual(root.get(AbstractEncuestaAjustador_.respuestaFtp), "OK!"), 
					builder.isNull(root.get(AbstractEncuestaAjustador_.respuestaFtp))));
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractEncuestaAjustador_.id)));
			final TypedQuery<EncuestaAjustador> typedQ = this.getEntityManager().createQuery(query);
			
			typedQ.setMaxResults(50);
			return typedQ.getResultList();
			
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustadorSftp", 500);
		}
		return new Vector<>();
	}

	@Override
	public String ejecutarFuncioninsertarEncuestaAjustador(final String usuario,
			final String passwd,final String numeroDeReporte,final String nombreAsegurado,
			final Integer atencionPersonalCabina,final Integer llegadaAjustador,
			final Integer presentacionAjustador,final  Integer tratoAjustador,
			final Integer capacidadAjustador,final  Integer tratoAjustadorTercero,
			final Integer servicioDeGrua,final Integer seleccionDeTaller,
			final boolean observoIrregularidadServicio,final boolean recibioCopiaDA,
			final String observaciones,final String nombreConductor,final String telefono,
			final String correo,final Integer idEstado,final Integer idBase,final String poliza) {
		
		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"encuesta_movil_ws_insr_ncuest1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
//			nat.registerStoredProcedureParameter("in_passwd", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombre_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_atencion_personal_cabina", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_llegada_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_presentacion_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_trato_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_capacidad_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_trato_ajustador_tercero", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_servicio_grua", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_seleccion_taller", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_observo_irregularidad_ser", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_recibio_copia_da", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombre_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_correo_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_estado", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_base", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			
			nat.setParameter("in_usuario", usuario);	
//			nat.setParameter("in_passwd", passwd);
			nat.setParameter("in_numero_reporte", numeroDeReporte);
			nat.setParameter("in_nombre_asegurado", nombreAsegurado);
			nat.setParameter("in_atencion_personal_cabina", atencionPersonalCabina);
			nat.setParameter("in_llegada_ajustador", llegadaAjustador);
			nat.setParameter("in_presentacion_ajustador", presentacionAjustador);
			nat.setParameter("in_trato_ajustador", tratoAjustador);
			nat.setParameter("in_capacidad_ajustador", capacidadAjustador);
			nat.setParameter("in_trato_ajustador_tercero", tratoAjustadorTercero);
			nat.setParameter("in_servicio_grua", servicioDeGrua);
			nat.setParameter("in_seleccion_taller", seleccionDeTaller);
			nat.setParameter("in_observo_irregularidad_ser", (observoIrregularidadServicio)?new String("t"):new String("f"));
			nat.setParameter("in_recibio_copia_da", (recibioCopiaDA)?new String("t"):new String("f"));
			nat.setParameter("in_observaciones", observaciones);
			nat.setParameter("in_nombre_conductor", nombreConductor);
			nat.setParameter("in_telefono_conductor", telefono);
			nat.setParameter("in_correo_conductor", correo);
			nat.setParameter("in_estado", idEstado);
			nat.setParameter("in_base", idBase);
			nat.setParameter("in_poliza", poliza);

			nat.execute();

//			return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			return String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e,
					"ejecutarFuncioninsertarEncuestaAjustador",usuario,
					passwd,numeroDeReporte,nombreAsegurado,
					atencionPersonalCabina,llegadaAjustador,
					presentacionAjustador,tratoAjustador,
					capacidadAjustador,tratoAjustadorTercero,
					servicioDeGrua,seleccionDeTaller,
					observoIrregularidadServicio,recibioCopiaDA,
					observaciones,nombreConductor,telefono,correo,idEstado,
					idBase,poliza);
			return "ERROR: " + e.getMessage();
		}
		
	}
	
}
package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacTerceros_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilSacTercerosDaoInterfase;
import com.aaq.col.clases.sac.model.DatosGestionTerceroSac;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "reporteMovilSacTercerosDao")
public class ReporteMovilSacTercerosDao extends SIICAServerGenericDaoJpaImpl<ReporteMovilSacTerceros> implements ReporteMovilSacTercerosDaoInterfase {

	@Override
	public ReporteMovilSacTerceros objetoReporteMovilSacTerceros(
			String numeroReporte, String numeroAjustador) {
		
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacTerceros> query = builder.createQuery(ReporteMovilSacTerceros.class);
			final Root<ReporteMovilSacTerceros> root = query.from(ReporteMovilSacTerceros.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractReporteMovilSacTerceros_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacTerceros_.ajusteAjustadorCodigo), numeroAjustador));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacTerceros_.id)));
			final TypedQuery<ReporteMovilSacTerceros> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteMovilSacTerceros> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacTerceros", numeroReporte, numeroAjustador);
		}
		return null;
	}

	@Override
	public List<ReporteMovilSacTerceros> listaDeReporteMovilSacTerceros(
			String numeroReporte, String numeroAjustador) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacTerceros> query = builder.createQuery(ReporteMovilSacTerceros.class);
			final Root<ReporteMovilSacTerceros> root = query.from(ReporteMovilSacTerceros.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

            predicates.add(builder.equal(root.get(AbstractReporteMovilSacTerceros_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacTerceros_.ajusteAjustadorCodigo), numeroAjustador));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacTerceros_.id)));

			final TypedQuery<ReporteMovilSacTerceros> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(3000);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacTerceros", numeroReporte, numeroAjustador);
		}
		return new Vector<>();
	}
	
	@Override
	public JMResultadoOperacion guardarTerceros(final String numeroReporte, final String claveProveedor, final String poliza, final DatosGestionTerceroSac dgts)
			{
		
		if (numeroReporte == null) {
			return new JMResultadoOperacion(new Exception("Reporte Nulo"));
		}
		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"reporte_sac_terceros_insertar1");

			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_tercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_marca", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ano_modelo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_placa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_serie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_color", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_contacto", String.class, ParameterMode.IN);
			//nat.registerStoredProcedureParameter("in_ciaaseg", String.class, ParameterMode.IN);
			//nat.registerStoredProcedureParameter("in_poliza", String.class, ParameterMode.IN);
			//nat.registerStoredProcedureParameter("in_gxg", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
								
			nat.setParameter("in_numero_reporte", numeroReporte);
			nat.setParameter("in_clave_proveedor",claveProveedor);
			nat.setParameter("in_id_tercero",dgts.getNumero().replaceAll("[^0-9]", "").trim());
			nat.setParameter("in_marca",dgts.getMarcaVehiculo() );
			nat.setParameter("in_tipo",dgts.getTipoVehiculo());
			nat.setParameter("in_ano_modelo",dgts.getModeloVehiculo());
			nat.setParameter("in_placa",dgts.getPlacasVehiculo());
			nat.setParameter("in_serie",dgts.getSerieTercero());
			nat.setParameter("in_color",dgts.getColorVehiculo());
			nat.setParameter("in_conductor",dgts.getConductorTercero() );
			nat.setParameter("in_telefono_contacto",dgts.getTelefonoTercero());
			//nat.setParameter("in_ciaaseg",null);
			//nat.setParameter("in_poliza",poliza);
			//nat.setParameter("in_gxg",null );

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e,
					"reporte_sac_terceros_insertar", numeroReporte, claveProveedor, poliza, dgts);
			return new JMResultadoOperacion(e);
		} catch (final RollbackException e) {
			this.documentarExcepcionParaMetodo(e,
					"reporte_sac_terceros_insertar", numeroReporte, claveProveedor, poliza, dgts);
			return new JMResultadoOperacion(e);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e,
					"reporte_sac_terceros_insertar", numeroReporte, claveProveedor, poliza, dgts);
			return new JMResultadoOperacion(e);
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e,
					"reporte_sac_terceros_insertar", numeroReporte, claveProveedor, poliza, dgts);
			return new JMResultadoOperacion(e);
		}
		
	}

}
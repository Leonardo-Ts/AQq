package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.CannotCreateTransactionException;

import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacGruas_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilSacGruasDaoInterfase;

@org.springframework.stereotype.Repository(value = "reporteMovilSacGruasDao")
public class ReporteMovilSacGruasDao extends SIICAServerGenericDaoJpaImpl<ReporteMovilSacGruas> implements ReporteMovilSacGruasDaoInterfase {

	@Override
	public ReporteMovilSacGruas objetoReporteMovilSacGruas(
			String numeroReporte, String numeroAjustador) {
		
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacGruas> query = builder.createQuery(ReporteMovilSacGruas.class);
			final Root<ReporteMovilSacGruas> root = query.from(ReporteMovilSacGruas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.ajusteAjustadorCodigo), numeroAjustador));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacGruas_.id)));
			final TypedQuery<ReporteMovilSacGruas> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteMovilSacGruas> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacGruas", numeroReporte, numeroAjustador);
		}
		return null;
	}

	@Override
	public List<ReporteMovilSacGruas> listaDeReporteMovilSacGruas(
			String numeroReporte, String numeroAjustador) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacGruas> query = builder.createQuery(ReporteMovilSacGruas.class);
			final Root<ReporteMovilSacGruas> root = query.from(ReporteMovilSacGruas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

            predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.ajusteAjustadorCodigo), numeroAjustador));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacGruas_.id)));

			final TypedQuery<ReporteMovilSacGruas> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(3000);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacGruas", numeroReporte, numeroAjustador);
		}
		return new Vector<>();
	}
	
	@Override
	public List<ReporteMovilSacGruas> listaDeReporteMovilSacGruasC(String numeroReporte, String numeroAjustador, String  tipoAfectado) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacGruas> query = builder.createQuery(ReporteMovilSacGruas.class);
			final Root<ReporteMovilSacGruas> root = query.from(ReporteMovilSacGruas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

            predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.ajusteAjustadorCodigo), numeroAjustador));
			}
			
			if (tipoAfectado != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacGruas_.tipoAfectado), tipoAfectado));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacGruas_.id)));

			final TypedQuery<ReporteMovilSacGruas> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(300);
			return typedQ.getResultList();
		} catch (final NoResultException | NonUniqueResultException | RollbackException | DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacGruas", numeroReporte, numeroAjustador);
		} catch (PersistenceException | IndexOutOfBoundsException | CannotCreateTransactionException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacGruas", numeroReporte, numeroAjustador);
		}
		return new Vector<>();
	}


}
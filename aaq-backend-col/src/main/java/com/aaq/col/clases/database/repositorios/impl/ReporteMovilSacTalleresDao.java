package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacTalleres_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilSacTalleresDaoInterfase;

@org.springframework.stereotype.Repository(value = "reporteMovilSacTalleresDao")
public class ReporteMovilSacTalleresDao extends SIICAServerGenericDaoJpaImpl<ReporteMovilSacTalleres> implements ReporteMovilSacTalleresDaoInterfase {

	@Override
	public ReporteMovilSacTalleres objetoReporteMovilSacTalleres(
			String numeroReporte, String numeroAjustador) {
		
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacTalleres> query = builder.createQuery(ReporteMovilSacTalleres.class);
			final Root<ReporteMovilSacTalleres> root = query.from(ReporteMovilSacTalleres.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractReporteMovilSacTalleres_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacTalleres_.ajusteAjustadorCodigo), numeroAjustador));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacTalleres_.id)));
			final TypedQuery<ReporteMovilSacTalleres> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteMovilSacTalleres> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		}
		return null;
	}

	@Override
	public List<ReporteMovilSacTalleres> listaDeReporteMovilSacTalleres(
			String numeroReporte, String numeroAjustador) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSacTalleres> query = builder.createQuery(ReporteMovilSacTalleres.class);
			final Root<ReporteMovilSacTalleres> root = query.from(ReporteMovilSacTalleres.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

            predicates.add(builder.equal(root.get(AbstractReporteMovilSacTalleres_.generalNumeroReporte), numeroReporte));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSacTalleres_.ajusteAjustadorCodigo), numeroAjustador));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSacTalleres_.id)));

			final TypedQuery<ReporteMovilSacTalleres> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(3000);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSacTalleres", numeroReporte, numeroAjustador);
		}
		return new Vector<>();
	}


}
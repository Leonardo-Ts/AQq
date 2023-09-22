package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.EntidadAbogadoCrm;
import com.aaq.col.clases.database.entidades.abstracto.AbstractEntidadAbogadoCrm_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.EntidadAbogadoCrmDaoInterfase;


@org.springframework.stereotype.Repository(value = "entidadAbogadoCrmDao")
public class EntidadAbogadoCrmDao extends SIICAServerGenericDaoJpaImpl<EntidadAbogadoCrm> implements EntidadAbogadoCrmDaoInterfase {

	@Override
	public EntidadAbogadoCrm objetoEntidadAbogadoCrm(String nombreEntidad) {
		
		if (StringUtils.isBlank(nombreEntidad)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<EntidadAbogadoCrm> query = builder.createQuery(EntidadAbogadoCrm.class);
			final Root<EntidadAbogadoCrm> root = query.from(EntidadAbogadoCrm.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractEntidadAbogadoCrm_.edoPob), nombreEntidad));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<EntidadAbogadoCrm> typedQ = this.getEntityManager().createQuery(query);
			final List<EntidadAbogadoCrm> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSacTerceros", nombreEntidad);
		}
		return null;
	}
}
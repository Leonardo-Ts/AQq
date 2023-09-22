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
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoGrua_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoGruaDaoInterface;

@Repository("catalogoGruaDao")
public class CatalogoGruaDao extends SIICAServerGenericDaoJpaImpl<CatalogoGrua> implements CatalogoGruaDaoInterface {

	@Override
	public CatalogoGrua objetoCatalogoGrua(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoGrua.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoGrua", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoGrua", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoGrua", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoGrua", id);
		}
		return null;
	}

	@Override
	public List<CatalogoGrua> listaDeCatalogoGrua(final String clave, final String descripcion, final String codigo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoGrua> query = builder.createQuery(CatalogoGrua.class);
			final Root<CatalogoGrua> root = query.from(CatalogoGrua.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoGrua_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoGrua_.descripcion), descripcion));
			}
			if (StringUtils.isNotBlank(codigo)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoGrua_.codigo), codigo));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoGrua_.id)));
			final TypedQuery<CatalogoGrua> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoGrua");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoGrua");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoGrua");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoGrua");
		}
		return new Vector<>();
	}

}

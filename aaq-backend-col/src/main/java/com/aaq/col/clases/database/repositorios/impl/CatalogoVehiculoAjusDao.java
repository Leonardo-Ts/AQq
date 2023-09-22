package com.aaq.col.clases.database.repositorios.impl;

import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoAjus_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehiculoAjusDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoVehiculoAjusDao")
public class CatalogoVehiculoAjusDao extends SIICAServerGenericDaoJpaImpl<CatalogoVehiculoAjus> implements CatalogoVehiculoAjusDaoInterfase {


	@Override
	public CatalogoVehiculoAjus objetoCatalogoVehiculoAjus(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoVehiculoAjus.class, new Integer(id)): null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehiculoAjus", id);
		}
		return null;
	}

	@Override
	public List<CatalogoVehiculoAjus> listaDeCatalogoVehiculoAjus() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehiculoAjus> query = builder.createQuery(CatalogoVehiculoAjus.class);
			final Root<CatalogoVehiculoAjus> root = query.from(CatalogoVehiculoAjus.class);
			query.select(root);
						
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehiculoAjus_.marca)));
			final TypedQuery<CatalogoVehiculoAjus> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehiculoAjus");
		}
		return new Vector<>();
	}

}

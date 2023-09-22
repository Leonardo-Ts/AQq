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

import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCredenciales_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCredencialesDaoInterfase;

@Repository("catalogoCredencialesDao")
public class CatalogoCredencialesDao extends SIICAServerGenericDaoJpaImpl<CatalogoCredenciales> implements CatalogoCredencialesDaoInterfase{

	@Override
	public CatalogoCredenciales objetoCatalogoCredenciales(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoCredenciales.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCredenciales", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCredenciales", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCredenciales", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCredenciales", id);
		}
		return null;
	}


	
	@Override
	public List<CatalogoCredenciales> listaDeCatalogoCredenciales(final String nombre, final String url, final String usuario, final String pwd) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCredenciales> query = builder.createQuery(CatalogoCredenciales.class);
			final Root<CatalogoCredenciales> root = query.from(CatalogoCredenciales.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCredenciales_.nombre), nombre));
			}
			if (StringUtils.isNotBlank(url)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCredenciales_.url), url));
			}
			if (StringUtils.isNotBlank(pwd)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCredenciales_.pwd), pwd));
			}
			if (StringUtils.isNotBlank(usuario)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCredenciales_.usuario), usuario));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCredenciales_.id)));
			final TypedQuery<CatalogoCredenciales> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCredenciales");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCredenciales");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCredenciales");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCredenciales");
		}
		return new Vector<>();
	}
	
}

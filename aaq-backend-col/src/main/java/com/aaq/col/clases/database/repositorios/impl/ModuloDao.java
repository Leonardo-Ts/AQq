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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.aaq.col.clases.database.entidades.abstracto.AbstractModulo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ModuloDaoInterfase;

@org.springframework.stereotype.Repository(value = "moduloDao")
public class ModuloDao extends SIICAServerGenericDaoJpaImpl<Modulo> implements ModuloDaoInterfase {

	@Override
	public Modulo objetoModulo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Modulo.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoModulo", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoModulo", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoModulo", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoModulo", id);
		}
		return null;
	}

	@Override
	public List<Modulo> listaDeModulo() {
		return this.listaDeModulo(null, null, null, null, null, true);
	}

	@Override
	public List<Modulo> listaDeModulo(final ModuloPadre moduloPadre, final String[] paginas, final boolean conNombres) {
		return this.listaDeModulo(null, moduloPadre, null, null, paginas, conNombres);
	}

	@Override
	public List<Modulo> listaDeModulo(final List<Integer> listaNoPermitida, final ModuloPadre moduloPadre,
			final String nombre, final String nombresiicav3, final Object[] pagina, final boolean conNombres) {

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Modulo> query = builder.createQuery(Modulo.class);
			final Root<Modulo> root = query.from(Modulo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractModulo_.habilitado), Boolean.TRUE));

			if (conNombres) {
				predicates.add(builder.isNotNull(root.get(AbstractModulo_.descripcion)));
				predicates.add(builder.isNotNull(root.get(AbstractModulo_.nombrecorto)));
			}

			if ((listaNoPermitida != null) && (listaNoPermitida.size() > 0)) {
				predicates.add(builder.not(root.get(AbstractModulo_.id).in(listaNoPermitida)));
			}

			if (moduloPadre != null) {
				predicates.add(builder.equal(root.get(AbstractModulo_.moduloPadre), moduloPadre));
			}

			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractModulo_.nombre), nombre));
			}

			if (StringUtils.isNotBlank(nombresiicav3)) {
				predicates.add(builder.equal(root.get(AbstractModulo_.nombresiicav3), nombresiicav3));
			}

			if (ArrayUtils.isNotEmpty(pagina)) {
				predicates.add(root.get(AbstractModulo_.pagina).in(pagina));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractModulo_.nombre)),
					builder.asc(root.get(AbstractModulo_.moduloPadre).get("nombre")),
					builder.asc(root.get(AbstractModulo_.nombrecorto)));
			final TypedQuery<Modulo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeModulo", listaNoPermitida, moduloPadre, nombre,
					nombresiicav3, pagina, new Boolean(conNombres));
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeModulo", listaNoPermitida, moduloPadre, nombre,
					nombresiicav3, pagina, new Boolean(conNombres));
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeModulo", listaNoPermitida, moduloPadre, nombre,
					nombresiicav3, pagina, new Boolean(conNombres));
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeModulo", listaNoPermitida, moduloPadre, nombre,
					nombresiicav3, pagina, new Boolean(conNombres));
		}
		return new Vector<>();
	}
}
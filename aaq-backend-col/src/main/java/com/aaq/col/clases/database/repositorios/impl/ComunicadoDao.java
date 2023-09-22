package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractComunicado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ComunicadoDaoInterfase;


@org.springframework.stereotype.Repository(value = "comunicadoDao")
public class ComunicadoDao extends SIICAServerGenericDaoJpaImpl<Comunicado> implements ComunicadoDaoInterfase {

	@Override
	public Comunicado objetoComunicado(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Comunicado.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoComunicado", id);
		}
		return null;
	}

	@Override
	public List<Comunicado> listaDeComunicado(final Estado estado, final Base base, final Terminal terminal,
			final Boolean soloActivos) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Comunicado> query = builder.createQuery(Comunicado.class);
			final Root<Comunicado> root = query.from(Comunicado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (BooleanUtils.isTrue(soloActivos) && (terminal != null)) {

				predicates.add(builder.or(builder.equal(root.get(AbstractComunicado_.estado), terminal.getEstado()),
						builder.isNull(root.get(AbstractComunicado_.estado))));

				predicates.add(builder.or(builder.equal(root.get(AbstractComunicado_.base), terminal.getBase()),
						builder.isNull(root.get(AbstractComunicado_.base))));

				predicates.add(builder.or(builder.equal(root.get(AbstractComunicado_.terminal), terminal),
						builder.isNull(root.get(AbstractComunicado_.terminal))));

				predicates.add(builder.lessThanOrEqualTo(root.get(AbstractComunicado_.fechaInicio), new Date()));
				predicates.add(builder.greaterThanOrEqualTo(root.get(AbstractComunicado_.fechaTermino), new Date()));
			} else {
				if (estado != null) {
					predicates.add(builder.equal(root.get(AbstractComunicado_.estado), estado));
				}
				if (base != null) {
					predicates.add(builder.equal(root.get(AbstractComunicado_.base), base));
				}
				if (terminal != null) {
					predicates.add(builder.equal(root.get(AbstractComunicado_.terminal), terminal));
				}
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractComunicado_.fechaCaptura)));
			final TypedQuery<Comunicado> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeComunicado", estado, base, terminal, soloActivos);
		}
		return new Vector<>();
	}
}
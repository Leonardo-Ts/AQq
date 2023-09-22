package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalComentario;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalComentario_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalComentarioDaoInterfase;


@org.springframework.stereotype.Repository(value = "terminalComentarioDao")
public class TerminalComentarioDao extends SIICAServerGenericDaoJpaImpl<TerminalComentario> implements
TerminalComentarioDaoInterfase {

	@Override
	public TerminalComentario objetoTerminalComentario(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalComentario.class, new Integer(id)): null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalComentario", id);
		}
		return null;
	}

	@Override
	public List<TerminalComentario> listaTerminalComentarios(Terminal terminal) {
		if (terminal == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalComentario> query = builder.createQuery(TerminalComentario.class);
			final Root<TerminalComentario> root = query.from(TerminalComentario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminalComentario_.terminal), terminal));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTerminalComentario_.fecha)));
			final TypedQuery<TerminalComentario> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaTerminalComentarios", terminal);
		}
		return new Vector<>();
	}
	
	@Override
	public List<TerminalComentario> listaTerminalComentariosVistos(Terminal terminal) {
		if (terminal == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalComentario> query = builder.createQuery(TerminalComentario.class);
			final Root<TerminalComentario> root = query.from(TerminalComentario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminalComentario_.terminal), terminal));
			predicates.add(builder.isNull(root.get(AbstractTerminalComentario_.usuarioVisto)));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
//			query.orderBy(builder.desc(root.get(AbstractTerminalComentario_.fecha)));
			query.orderBy(builder.desc(root.get(AbstractTerminalComentario_.terminal)));
			final TypedQuery<TerminalComentario> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaTerminalComentarios", terminal);
		}
		return new Vector<>();
	}


}

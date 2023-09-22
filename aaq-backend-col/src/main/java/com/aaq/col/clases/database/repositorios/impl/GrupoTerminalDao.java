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

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GrupoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractGrupoTerminal_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GrupoTerminalDaoInterfase;


@org.springframework.stereotype.Repository(value = "grupoTerminalDao")
public class GrupoTerminalDao extends SIICAServerGenericDaoJpaImpl<GrupoTerminal> implements
		GrupoTerminalDaoInterfase {

	@Override
	public GrupoTerminal objetoGrupoTerminal(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(GrupoTerminal.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGrupoTerminal", id);
		}
		return null;
	}

	@Override
	public List<GrupoTerminal> listaDeGrupoTerminal(final Grupo grupo) {
		return this.listaDeGrupoTerminal(grupo, null);
	}

	@Override
	public List<GrupoTerminal> listaDeGrupoTerminal(final Terminal terminal) {
		return this.listaDeGrupoTerminal(null, terminal);
	}
	
	private List<GrupoTerminal> listaDeGrupoTerminal(Grupo grupo, Terminal terminal){
		if(grupo != null || terminal != null){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<GrupoTerminal> query = builder.createQuery(GrupoTerminal.class);
				final Root<GrupoTerminal> root = query.from(GrupoTerminal.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (grupo != null) {
					predicates.add(builder.equal(root.get(AbstractGrupoTerminal_.grupo), grupo));
				}
				
				if (terminal != null) {
					predicates.add(builder.equal(root.get(AbstractGrupoTerminal_.terminal), terminal));
				}
				
				predicates.add(builder.equal(root.get(AbstractGrupoTerminal_.terminal).get("habilitado"), Boolean.TRUE));
				
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractGrupoTerminal_.terminal).get("nombre")));
				final TypedQuery<GrupoTerminal> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeGrupoTerminal", grupo);
			}
		}
		else{
			return new Vector<>();
		}
		return new Vector<>();
	}

}
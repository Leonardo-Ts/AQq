package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
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
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractBase_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.BaseDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@org.springframework.stereotype.Repository(value = "baseDao")
public class BaseDao extends SIICAServerGenericDaoJpaImpl<Base> implements BaseDaoInterfase {

	@Override
	public Base objetoBase(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Base.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoBase", id);
		}
		return null;
	}

	@Override
	public List<Base> listaDeBase(final Estado estado) {
		return this.listaDeBase(estado, false);

	}

	@Override
	public List<Base> listaDeBase(final Estado estado, final boolean todas) {
		return this.listaDeBase(estado, null, todas, false,null,null);

	}

	@Override
	public List<Base> listaDeBase(final Estado estado, final String idPermitido, final boolean todas,
			final boolean foraneo, final Boolean conLatitudLongitud, final Boolean habilitadasEnMapa) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Base> query = builder.createQuery(Base.class);
			final Root<Base> root = query.from(Base.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractBase_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractBase_.estado), estado));
			}

			if (StringUtils.isNotBlank(idPermitido)) {
				predicates.add(root.get(AbstractBase_.id).in(JMUtileriaString.listaDeInteger(idPermitido, ",")));
			}

			if (!todas) {
				predicates.add(builder.greaterThan(root.get(AbstractBase_.id), new Integer(0)));
			}

			if (foraneo) {
				predicates.add(builder.greaterThan(root.get(AbstractBase_.id), new Integer(0)));
				predicates.add(builder.not(root.get(AbstractBase_.identidad_).in(
						JMUtileriaString.listaDeInteger("9,14,15,19", ","))));
			}

			if (BooleanUtils.isTrue(conLatitudLongitud)){
				predicates.add(builder.isNotNull(root.get(AbstractBase_.latitud)));
				predicates.add(builder.isNotNull(root.get(AbstractBase_.longitud)));
			}
			if (habilitadasEnMapa != null){
				predicates.add(builder.equal(root.get(AbstractBase_.habilitadoEnMapaCabina),habilitadasEnMapa));
			}


			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractBase_.nombre)));
			final TypedQuery<Base> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeBase", estado, idPermitido, new Boolean(todas), new Boolean(
					foraneo));
		}
		return new Vector<>();
	}

	@Override
	public List<JMEntidadObjeto> listaDeReporteDeUso(final Estado estado) {

		try {
			final StringBuilder query = new StringBuilder("  select ");
			query.append(" (select estado.nombre from estado where estado.id = base.identidad) AS ESTADO,");
			query.append(" base.nombre,");
			query.append(" (SELECT count(*) from terminal where terminal.habilitado= TRUE AND  terminal.idzona = base.id) AS TOTAL_TERMINALES,");
			query.append(" (SELECT count(*) FROM historico_terminal WHERE  historico_terminal.idterminal IN  (select terminal.id from terminal where terminal.habilitado = TRUE AND  terminal.idzona = base.id)  ) AS TOTAL_REGISTROS,");
			query.append(" (SELECT count(distinct(historico_terminal.idterminal)) FROM historico_terminal WHERE  historico_terminal.idterminal IN  (select terminal.id from terminal where terminal.habilitado = TRUE AND  terminal.idzona = base.id)  and operacion='ajustadoresIniciarSession') AS TERMINALES_INICIO_SESION,");
			query.append(" (SELECT count(distinct(historico_terminal.idterminal)) FROM historico_terminal WHERE  historico_terminal.idterminal IN  (select terminal.id from terminal where terminal.habilitado = TRUE AND  terminal.idzona = base.id)  and operacion='Arribo Movil V3') AS TERMINALES_ARRIBO");
			query.append(" FROM base WHERE ");
			query.append(" base.habilitado = true ");
			query.append(" AND base.identidad = " + estado.getId());
			query.append(" AND base.id > 0 ");
			query.append(" ORDER BY base.nombre ASC ");

			return null;
			// return
			// this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
			// .getResultList());

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteDeUso", estado);
		}
		return null;

	}

}
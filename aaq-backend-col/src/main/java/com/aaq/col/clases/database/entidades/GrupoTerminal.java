package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGrupoTerminal;
import com.aaq.col.clases.database.servicios.interfase.GrupoTerminalServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "grupoTerminal")
@Entity(name = "GrupoTerminal")
@Access(AccessType.FIELD)
@Table(name = "grupo_terminal")
public class GrupoTerminal extends AbstractGrupoTerminal {

	private static final long serialVersionUID = -6187092245337397218L;

	public GrupoTerminal() {
		super();
	}

	private static GrupoTerminalServiceInterfase grupoTerminalService;

	public static GrupoTerminalServiceInterfase getGrupoTerminalService() {
		if (GrupoTerminal.grupoTerminalService == null) {
			GrupoTerminal.grupoTerminalService = JMSIICAServerServiceSingleton.getInstance()
					.getGrupoTerminalService();
		}
		return GrupoTerminal.grupoTerminalService;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return GrupoTerminal.getGrupoTerminalService().eliminarObjeto(this);
		}	catch (IndexOutOfBoundsException | ClassCastException e) {
			return new JMResultadoOperacion(e);
		}	catch (final RollbackException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		}	catch ( DataAccessException e) {
			return new JMResultadoOperacion(e);
		} 	catch ( Exception e) {
			return new JMResultadoOperacion(e);
		}
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return GrupoTerminal.getGrupoTerminalService().guardarObjeto(this);
		} 	catch ( ClassCastException | RollbackException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}	catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} 	catch (  DataAccessException e) {
			return new JMResultadoOperacion(e);
		}	catch (  Exception e) {
			return new JMResultadoOperacion(e);
		}

	}
}

 package com.aaq.col.clases.database.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMarcaEstilo;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaEstiloServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@Entity(name = "CatalogoMarcaEstilo")
@Access(AccessType.FIELD)
@Table(name = "catalogo_marca_estilo")
public class CatalogoMarcaEstilo extends AbstractCatalogoMarcaEstilo {

	private static final long serialVersionUID = -4101948897806853869L;

	/** default constructor */
	public CatalogoMarcaEstilo() {
	}

	private static CatalogoMarcaEstiloServiceInterfase catalogoMarcaEstiloService;

	public static CatalogoMarcaEstiloServiceInterfase getCatalogoMarcaEstiloService() {
		if (CatalogoMarcaEstilo.catalogoMarcaEstiloService == null) {
			CatalogoMarcaEstilo.catalogoMarcaEstiloService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoMarcaEstiloService();
		}
		return CatalogoMarcaEstilo.catalogoMarcaEstiloService;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getDescripcion();
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad#editarObjeto ()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad#eliminarObjeto
	 * ()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoMarcaEstilo.getCatalogoMarcaEstiloService().eliminarObjeto(this);
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad#guardarObjeto
	 * ()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoMarcaEstilo.getCatalogoMarcaEstiloService().guardarObjeto(this);
		}  catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}	catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}

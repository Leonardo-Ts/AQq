package com.aaq.col.clases.database.entidades;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoDeCausa;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoDeCausaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoCodigoDeCausa")
@RequestScoped
@Entity(name = "CatalogoCodigoDeCausa")
@Access(AccessType.FIELD)
@Table(name = "catalogo_codigo_de_causa")
public class CatalogoCodigoDeCausa extends AbstractCatalogoCodigoDeCausa {

	private static final long serialVersionUID = -6746563121318689544L;

	/** default constructor */
	public CatalogoCodigoDeCausa() {
		super();
		this.setDescripcion("Descripcion");
		this.setHabilitado(Boolean.TRUE);
	}

	// **************************************************************//
	// Overriders
	// **************************************************************//

	private static CatalogoCodigoDeCausaServiceInterfase catalogoCodigoDeCausaService;

	public static CatalogoCodigoDeCausaServiceInterfase getCatalogoCodigoDeCausaService() {
		if (CatalogoCodigoDeCausa.catalogoCodigoDeCausaService == null) {
			CatalogoCodigoDeCausa.catalogoCodigoDeCausaService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoCodigoDeCausaService();
		}
		return CatalogoCodigoDeCausa.catalogoCodigoDeCausaService;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.getId().intValue();
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
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoCodigoDeCausa.getCatalogoCodigoDeCausaService().guardarObjeto(this);
		} catch (RollbackException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoCodigoDeCausa.getCatalogoCodigoDeCausaService().guardarObjeto(this);
		} catch (RollbackException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}  catch ( DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}

}

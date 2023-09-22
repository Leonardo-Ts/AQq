package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoAseguradora;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAseguradoraServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoAseguradora")
@RequestScoped
@Entity(name = "CatalogoAseguradora")
@Access(AccessType.FIELD)
@Table(name = "catalogo_aseguradora")
public class CatalogoAseguradora extends AbstractCatalogoAseguradora {

	private static final long serialVersionUID = 3373643434561846566L;

	public CatalogoAseguradora() {
		super();
	}

	private static CatalogoAseguradoraServiceInterfase catalogoAseguradoraService;

	public static CatalogoAseguradoraServiceInterfase getCatalogoAseguradoraService() {
		if (CatalogoAseguradora.catalogoAseguradoraService == null) {
			CatalogoAseguradora.catalogoAseguradoraService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoAseguradoraService();
		}
		return CatalogoAseguradora.catalogoAseguradoraService;
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion"}).getLista();
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
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoAseguradora.getCatalogoAseguradoraService().guardarObjeto(this);
			
		} catch (RollbackException | IndexOutOfBoundsException  e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		} catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		} 
	}
}

 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractComunicado;
import com.aaq.col.clases.database.servicios.interfase.ComunicadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "comunicado")
@RequestScoped
@Entity(name = "Comunicado")
@Access(AccessType.FIELD)
@Table(name = "comunicado")
public class Comunicado extends AbstractComunicado {

	private static final long serialVersionUID = -4522011253554836018L;

	@Transient
	private String _idBase;

	@Transient
	private String _idTerminal;

	@Transient
	private String _idEstado;

	/** default constructor */
	public Comunicado() {
		this.setFechaCaptura(new Date());
		this.setFechaInicio(new Date());
		this.setFechaTermino(DateUtils.addDays(new Date(), 30));
	}

	private static ComunicadoServiceInterfase comunicadoService;

	public static ComunicadoServiceInterfase getComunicadoService() {
		if (Comunicado.comunicadoService == null) {
			Comunicado.comunicadoService = JMSIICAServerServiceSingleton.getInstance().getComunicadoService();
		}
		return Comunicado.comunicadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Consecutivo,id", "Estado,estado", "Base,base",
				"Ajustador,terminal", "Fecha de Captura,fechaCaptura,fecha", "Fecha de Inicio,fechaInicio,fecha",
				"Fecha de Fin de Vigencia,fechaTermino,fecha", "Mensaje,texo" }).getLista();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getBase() != null) {
			this.set_idBase(Objects.toString(this.getBase().getId()));
		}
		if (this.getEstado() != null) {
			this.set_idEstado(Objects.toString(this.getEstado().getId()));
		}
		if (this.getTerminal() != null) {
			this.set_idTerminal(Objects.toString(this.getTerminal().getId()));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return Comunicado.getComunicadoService().eliminarObjeto(this);
		} catch ( RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
				return new JMResultadoOperacion(e.getMessage());
		}  catch (Exception e) {
			return new JMResultadoOperacion(e.getMessage());
	} 
			
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_idBase())) {
			try {
				this.setBase(Base.getBaseService().objetoBase(this.get_idBase()));
			} catch (RollbackException | IndexOutOfBoundsException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (PersistenceException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
				try {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				} catch (ClassCastException ex) {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				}
			} 
		}
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (RollbackException | IndexOutOfBoundsException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (PersistenceException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
				try {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				} catch (ClassCastException | RollbackException | IndexOutOfBoundsException  ex) {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				}
			} 
		}
		if (StringUtils.isNotBlank(this.get_idTerminal())) {
			try {
				this.setTerminal(Terminal.getTerminalService().objetoTerminal(this.get_idTerminal()));
			} catch (IndexOutOfBoundsException | RollbackException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (PersistenceException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
			}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
				try {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				} catch (ClassCastException | IndexOutOfBoundsException | RollbackException ex) {
					JMEntidad.getLogger().error("guardarObjeto ==> objetoBase=> " + this.get_idBase(), e);
				}
			} 
		}

		try {
			return Comunicado.getComunicadoService().guardarObjeto(this);
		} catch (IndexOutOfBoundsException | RollbackException e) {
			JMEntidad.getLogger().error("guardarObjeto", e);
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			JMEntidad.getLogger().error("guardarObjeto", e);
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			JMEntidad.getLogger().error("guardarObjeto", e);
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
				JMEntidad.getLogger().error("guardarObjeto", e);
				return new JMResultadoOperacion(e.getMessage());
		} catch ( Exception e) {
			JMEntidad.getLogger().error("guardarObjeto", e);
			return new JMResultadoOperacion(e.getMessage());
	} 
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Consecutivo: " + this.getId();
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @return the _idBase
	 */
	public String get_idBase() {
		return this._idBase;
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @param _idBase
	 *            the _idBase to set
	 */
	public void set_idBase(final String _idBase) {
		this._idBase = _idBase;
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @return the _idTerminal
	 */
	public String get_idTerminal() {
		return this._idTerminal;
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @param _idTerminal
	 *            the _idTerminal to set
	 */
	public void set_idTerminal(final String _idTerminal) {
		this._idTerminal = _idTerminal;
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @return the _idEstado
	 */
	public String get_idEstado() {
		return this._idEstado;
	}

	/**
	 *  Jan 17, 2014 3:21:19 PM
	 * 
	 * @param _idEstado
	 *            the _idEstado to set
	 */
	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

}

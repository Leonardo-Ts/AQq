package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractHistoricoTerminal entity provides the base persistence definition of
 * the HistoricoTerminal entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractHistoricoTerminal extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786778970851237330L;

	@SequenceGenerator(name = "historico_terminalSEQ", sequenceName = "historico_terminal_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_terminalSEQ")
	private Integer id;

	@Column(name = "fecha", nullable = false, unique = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fecha;

	@Column(name = "reporte", length = 255, nullable = true, unique = true)
	private String reporte;

	@Column(name = "fuente", length = 255, nullable = true, unique = false)
	private String fuente;

	@Column(name = "operacion", length = 255, nullable = true, unique = true)
	private String operacion;

	@Column(name = "detalles", nullable = true, unique = false)
	private String detalles;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = true, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "idusuario", referencedColumnName = "id", nullable = true, unique = true, insertable = true, updatable = true)
	private Usuario usuario;

	// Constructors

	/** default constructor */
	public AbstractHistoricoTerminal() {
		super();
	}

	/**
	 * full constructor
	 * 
	 * @param usuario
	 * @param terminal
	 * @param fecha
	 * @param reporte
	 * @param fuente
	 * @param operacion
	 * @param detalles
	 */
	public AbstractHistoricoTerminal(final Usuario usuario, final Terminal terminal, final Date fecha,
			final String reporte, final String fuente, final String operacion, final String detalles) {
		this.usuario = usuario;
		this.terminal = terminal;
		this.fecha = fecha;
		this.reporte = reporte;
		this.fuente = fuente;
		this.operacion = operacion;
		this.detalles = detalles;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(final java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the reporte
	 */
	public String getReporte() {
		return this.reporte;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(final String reporte) {
		this.reporte = reporte;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the fuente
	 */
	public String getFuente() {
		return this.fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param fuente
	 *            the fuente to set
	 */
	public void setFuente(final String fuente) {
		this.fuente = fuente;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the operacion
	 */
	public String getOperacion() {
		return this.operacion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param operacion
	 *            the operacion to set
	 */
	public void setOperacion(final String operacion) {
		this.operacion = operacion;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the detalles
	 */
	public String getDetalles() {
		return this.detalles;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param detalles
	 *            the detalles to set
	 */
	public void setDetalles(final String detalles) {
		this.detalles = detalles;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the terminal
	 */
	public Terminal getTerminal() {
		return this.terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param terminal
	 *            the terminal to set
	 */
	public void setTerminal(final Terminal terminal) {
		this.terminal = terminal;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * mfernandez Aug 7, 2014 3:44:02 PM
	 * 
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

}
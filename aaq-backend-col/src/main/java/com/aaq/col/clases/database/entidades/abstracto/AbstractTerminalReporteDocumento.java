package com.aaq.col.clases.database.entidades.abstracto;

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

import org.eclipse.persistence.annotations.Convert;

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractTerminalReporteDocumento entity provides the base persistence
 * definition of the TerminalReporteDocumento entity. @author mfernandez
 * Fernandez
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractTerminalReporteDocumento extends JMEntidad {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5433362829001358413L;

	@SequenceGenerator(name = "terminal_reporte_documentoSEQ", sequenceName = "terminal_reporte_documento_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_reporte_documentoSEQ")
	private Integer id;

	@Column(name = "valor", nullable = true, unique = false)
	@Convert("booleanConverter")
	private Boolean valor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = TerminalReporte.class)
	@JoinColumn(name = "idterminalreporte", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private TerminalReporte terminalReporte;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = TerminalReporteDocumentoTipo.class)
	@JoinColumn(name = "idterminalreportedocumentotipo", referencedColumnName = "id", nullable = false, unique = true, insertable = true, updatable = true)
	private TerminalReporteDocumentoTipo terminalReporteDocumentoTipo;

	// Constructors

	/** default constructor */
	public AbstractTerminalReporteDocumento() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @return the valor
	 */
	public Boolean getValor() {
		return this.valor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(final Boolean valor) {
		this.valor = valor;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @return the terminalReporte
	 */
	public TerminalReporte getTerminalReporte() {
		return this.terminalReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @param terminalReporte
	 *            the terminalReporte to set
	 */
	public void setTerminalReporte(final TerminalReporte terminalReporte) {
		this.terminalReporte = terminalReporte;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @return the terminalReporteDocumentoTipo
	 */
	public TerminalReporteDocumentoTipo getTerminalReporteDocumentoTipo() {
		return this.terminalReporteDocumentoTipo;
	}

	/**
	 * mfernandez Aug 7, 2014 4:48:52 PM
	 * 
	 * @param terminalReporteDocumentoTipo
	 *            the terminalReporteDocumentoTipo to set
	 */
	public void setTerminalReporteDocumentoTipo(final TerminalReporteDocumentoTipo terminalReporteDocumentoTipo) {
		this.terminalReporteDocumentoTipo = terminalReporteDocumentoTipo;
	}

}
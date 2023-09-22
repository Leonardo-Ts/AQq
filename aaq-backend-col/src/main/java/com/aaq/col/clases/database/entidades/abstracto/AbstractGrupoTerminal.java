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

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

/**
 * AbstractFrecuenciaBase entity provides the base persistence definition of the
 * FrecuenciaBase entity. @author mfernandez [Jose Miguel Fernandez]
 */

@Access(AccessType.FIELD)
@MappedSuperclass
public abstract class AbstractGrupoTerminal extends JMEntidad {

	private static final long serialVersionUID = -1707526951045462434L;

	@SequenceGenerator(name = "grupo_terminalSEQ", sequenceName = "grupo_terminal_seq", allocationSize = 1)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_terminalSEQ")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Grupo.class)
	@JoinColumn(name = "idgrupo", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Grupo grupo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Terminal.class)
	@JoinColumn(name = "idterminal", referencedColumnName = "id", nullable = false, unique = false, insertable = true, updatable = true)
	private Terminal terminal;

	// Constructors

	/** default constructor */
	public AbstractGrupoTerminal() {
		super();
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * mfernandez Aug 7, 2014 3:40:58 PM
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}



}
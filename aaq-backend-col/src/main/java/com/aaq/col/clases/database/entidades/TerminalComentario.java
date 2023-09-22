package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalComentario;
import com.aaq.col.clases.database.servicios.interfase.TerminalComentarioServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "terminalComentario")
@RequestScoped
@Entity(name = "TerminalComentario")
@Access(AccessType.FIELD)
@Table(name="TERMINAL_COMENTARIOS")
public class TerminalComentario extends AbstractTerminalComentario {

	private static final long serialVersionUID = 3787371326357633241L;
	
	private static TerminalComentarioServiceInterfase terminalComentarioService;

	public TerminalComentario() {
		super();
		this.setFecha(new Date());
	}
	

	public static TerminalComentarioServiceInterfase getTerminalComentarioService() {
		if (TerminalComentario.terminalComentarioService == null) {
			TerminalComentario.terminalComentarioService = JMSIICAServerServiceSingleton.getInstance().getTerminalComentarioService();
		}
		return TerminalComentario.terminalComentarioService;
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Comentario,comentario", "Fecha,fecha", "Usuario,usuario", "Visto Por,usuarioVisto"})
				.getLista();
	}
	
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return TerminalComentario.getTerminalComentarioService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
	
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalComentario.getTerminalComentarioService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalComentario;
import com.aaq.col.clases.database.repositorios.impl.TerminalComentarioDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalComentarioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalComentarioService")
@Transactional
public class TerminalComentarioService implements TerminalComentarioServiceInterfase {
	
	public Log log = LogFactory.getLog(TerminalComentario.class);

	@Autowired
	@Qualifier("terminalComentarioDao")
	private TerminalComentarioDao terminalComentarioDao;
	
	@Override
	public TerminalComentario objetoTerminalComentario(String id) {
		return terminalComentarioDao.objetoTerminalComentario(id);
	}

	public List<TerminalComentario> listaTerminalComentarios(Terminal terminal) {
		return terminalComentarioDao.listaTerminalComentarios(terminal);
	}
	
	@Override
	public List<TerminalComentario> listaTerminalComentarios(Terminal terminal, String usuario) {
		List<TerminalComentario> salida = terminalComentarioDao.listaTerminalComentarios(terminal);
		if (salida.size() > 0) {
			for (TerminalComentario terminalComentario : salida) {
				if (StringUtils.isBlank(terminalComentario.getUsuarioVisto())) {
					terminalComentario.setUsuarioVisto(usuario);
					this.guardarObjeto(terminalComentario);
				}
			}
		}
		return salida;
//		return terminalComentarioDao.listaTerminalComentarios(terminal);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(TerminalComentario t)  {
		return terminalComentarioDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(TerminalComentario t)  {
		return terminalComentarioDao.guardarObjeto(t);
	}
	
	@Override
	public boolean contieneComentariosNoVistos(Terminal terminal) {
		List<TerminalComentario> salida = terminalComentarioDao.listaTerminalComentariosVistos(terminal);	
//		log.info("Total de comentarios de "+terminal.getNumeroproveedor()+" cantidad de coments "+salida.size());
		if (salida.size() > 0) {
//			log.info("Contiene comentarios no visto");
			return true;
			} else {
//			log.info("Todos sus comentarios han sido vistos");
				return false;
			}
	}

}

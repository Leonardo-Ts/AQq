package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.database.repositorios.impl.FormatoReclamacionComprobantePeajeDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReclamacionComprobantePeajeServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReclamacionComprobantePeajeService")
@Transactional
public class FormatoReclamacionComprobantePeajeService implements FormatoReclamacionComprobantePeajeServiceInterfase {
	
	@Autowired
	@Qualifier("formatoReclamacionComprobantePeajeDao")
	FormatoReclamacionComprobantePeajeDao formatoReclamacionComprobantePeajeDao;

	@Override
	public FormatoReclamacionComprobantePeaje objetoFormatoReclamacionComprobantePeaje(String id) {
		return this.formatoReclamacionComprobantePeajeDao.objetoFormatoReclamacionComprobantePeaje(id);
	}

	@Override
	public List<FormatoReclamacionComprobantePeaje> listaDeFormatoReclamacionComprobantePeaje() {
		return this.formatoReclamacionComprobantePeajeDao.listaDeFormatoReclamacionComprobantePeaje();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReclamacionComprobantePeaje t) {

		return this.formatoReclamacionComprobantePeajeDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReclamacionComprobantePeajeDao.obtenerConsecutivo(reporte);

	}
}
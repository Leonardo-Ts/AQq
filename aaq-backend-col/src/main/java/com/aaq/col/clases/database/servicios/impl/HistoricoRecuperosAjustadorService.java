 package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.HistoricoRecuperosAjustador;
import com.aaq.col.clases.database.repositorios.impl.HistoricoRecuperosAjustadorDao;
import com.aaq.col.clases.database.repositorios.impl.HistoricoTerminalDao;
import com.aaq.col.clases.database.servicios.interfase.HistoricoRecuperosAjustadorServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("historicoRecuperosAjustadorService")
@Transactional
public class HistoricoRecuperosAjustadorService implements HistoricoRecuperosAjustadorServiceInterfase {
	
	@Autowired
	@Qualifier("historicoRecuperosAjustadorDao")
	HistoricoRecuperosAjustadorDao historicoRecuperosAjustadorDao;
	HistoricoTerminalDao historicoTerminalDao;

	@Override
	public HistoricoRecuperosAjustador objetoHistoricoRecuperosAjustador(final String id) {
		return this.historicoRecuperosAjustadorDao.objetoHistoricoRecuperosAjustador(id);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoRecuperosAjustadorNuevo(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado, 
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto) {
		return this.historicoRecuperosAjustadorDao.ejecutarFuncionHistoricoRecuperosAjustadorNuevo(claveRecupero, descripcionRecupero, totalVales, claveAseguradora, descripcionAseguradora, 
				claveAjustador, reporte, afectado, numeroSiniestro, folioVale, monto, descripcionMonto);

	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final HistoricoRecuperosAjustador t) {
		return this.historicoRecuperosAjustadorDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final HistoricoRecuperosAjustador t) {
		return this.historicoRecuperosAjustadorDao.guardarObjeto(t);
	}
}
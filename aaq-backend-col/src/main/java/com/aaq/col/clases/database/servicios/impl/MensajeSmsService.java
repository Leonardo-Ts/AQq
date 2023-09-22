 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.impl.MensajeSmsDao;
import com.aaq.col.clases.database.servicios.interfase.MensajeSmsServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("mensajeSmsService")
@Transactional
public class MensajeSmsService implements MensajeSmsServiceInterfase {
	
	@Autowired
	@Qualifier("mensajeSmsDao")
	MensajeSmsDao mensajeSmsDao;

	@Override
	public MensajeSms objetoMensajeSms(final String id) {
		return this.mensajeSmsDao.objetoMensajeSms(id);
	}

	@Override
	public List<MensajeSms> listaDeMensajeSms(final Date fechaInicial, final Date fechaFinal, final String reporte,
			final String oficina, final String poliza, final String agente, final String asegurado,
			final String gerente, final Terminal terminal, final Integer limite) {
		return this.mensajeSmsDao.listaDeMensajeSms(fechaInicial, fechaFinal, reporte, oficina, poliza, agente,
				asegurado, gerente, terminal, limite);
	}

//	@Override
//	public List<JMEntidadObjeto> listaDeMensajeSmsParaGrafica(final Date fechaInicial, final Date fechaFinal,
//			final String reporte, final String oficina, final String poliza, final String agente,
//			final String asegurado, final String gerente, final String idterminal) {
//		return this.mensajeSmsDao.listaDeMensajeSmsParaGrafica(fechaInicial, fechaFinal, reporte, oficina, poliza,
//				agente, asegurado, gerente, idterminal);
//	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final MensajeSms t) {
		return this.mensajeSmsDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final MensajeSms t) {
		return this.mensajeSmsDao.guardarObjeto(t);
	}
	
	@Override
	public List<EntidadObjeto> listaDeMensajeSmsParaGrafica(final Date fechaInicial, final Date fechaFinal,
			final String reporte, final String oficina, final String poliza, final String agente,
			final String asegurado, final String gerente, final String idterminal) {
		return this.mensajeSmsDao.listaDeMensajeSmsParaGrafica(fechaInicial, fechaFinal, reporte, oficina, poliza,
				agente, asegurado, gerente, idterminal);
	}
}
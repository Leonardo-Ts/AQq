package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.HistoricoRecuperosAjustador;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HistoricoRecuperosAjustadorDaoInterfase extends JMRepositorioGenericoInterfase<HistoricoRecuperosAjustador> {

	public abstract HistoricoRecuperosAjustador objetoHistoricoRecuperosAjustador(String id);

	public abstract JMResultadoOperacion ejecutarFuncionHistoricoRecuperosAjustadorNuevo(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado,
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto);

}
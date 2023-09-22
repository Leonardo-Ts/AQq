package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface BaseServiceInterfase extends JMServicioGenericoInterfase<Base> {

	public abstract Base objetoBase(final String id) ;
	public abstract List<Base> listaDeBase(final Estado estado) ;
	public abstract List<Base> listaDeBase(final Estado estado, final boolean todas);
	public abstract List<Base> listaDeBase(final Estado estado, final String idPermitido, final boolean todas,
			final boolean foraneo ,final Boolean conLatitudLongitud, final Boolean habilitadasEnMapa);
	public abstract List<JMEntidadObjeto> listaDeReporteDeUso(final Estado estado);
	public abstract JMResultadoOperacion eliminarObjeto(Base t);
	public abstract JMResultadoOperacion guardarObjeto(Base t);
}
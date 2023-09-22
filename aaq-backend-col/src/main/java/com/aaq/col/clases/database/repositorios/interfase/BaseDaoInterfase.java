package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;

public interface BaseDaoInterfase extends JMRepositorioGenericoInterfase<Base> {

	public abstract Base objetoBase(final String id);

	public abstract List<Base> listaDeBase(final Estado estado);

	public abstract List<Base> listaDeBase(final Estado estado, final boolean todas);

	public abstract List<Base> listaDeBase(final Estado estado, final String idPermitido, final boolean todas,
			final boolean foraneo, final Boolean conLatitudLongitud, final Boolean habilitadasEnMapa);

	public abstract List<JMEntidadObjeto> listaDeReporteDeUso(final Estado estado);

}
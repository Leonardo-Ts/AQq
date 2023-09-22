 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioUnicoPesado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoInventarioUnicoPesadoDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoInventarioUnicoPesado> {

	public abstract FormatoInventarioUnicoPesado objetoFormatoInventarioUnicoPesado(final String id);
	public abstract List<FormatoInventarioUnicoPesado> listaDeFormatoInventarioUnicoPesado();
	public abstract String InsertarFormatoInventarioUnicoPesado(DatosInsertarFormatoInventarioUnicoPesado entrada);
	public abstract String ejecutarFuncionWebserviceStoreFINP(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}
 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReparacionBienesDiversos;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoReparacionBienesDiversosDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoReparacionBienesDiversos> {

	
	public abstract FormatoReparacionBienesDiversos objetoFormatoReparacionBienesDiversos(final String id);
	public abstract List<FormatoReparacionBienesDiversos> listaDeFormatoReparacionBienesDiversos();
	public abstract String InsertarFormatoReparacionBienesDiversos(DatosInsertarFormatoReparacionBienesDiversos entrada);
	public abstract String ejecutarFuncionWebserviceStoreFBD(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}
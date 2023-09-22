package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionComprobantePeaje;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoReclamacionComprobantePeajeDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoReclamacionComprobantePeaje> {

	public abstract FormatoReclamacionComprobantePeaje objetoFormatoReclamacionComprobantePeaje(final String id);
	public abstract List<FormatoReclamacionComprobantePeaje> listaDeFormatoReclamacionComprobantePeaje();
	public abstract String InsertarFormatoReclamacionComprobantePeaje(DatosInsertarFormatoReclamacionComprobantePeaje entrada);
	public abstract String ejecutarFuncionWebserviceStoreFRCP(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}
package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.sisesac.ReconocimientoSISE;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;


public interface SiseSP_DaoInterfase {
	
	public abstract List<String> actualizarTelefonosSise(List<Terminal> entradas);
	public abstract String guardarRecSise(ReconocimientoSISE sise);
	public abstract EstadoCuenta obtenerEdoCta(String poliza, String inciso, String fecha, Terminal term, String reporteSAC, String ramo);
	public abstract List<SerieEdoCta> serieEdoCta(Terminal term, String serie, String reporteSAC);
	public abstract List<Serie6EdoCta> serie6EdoCta(Terminal term, String serie, String reporteSAC);
	
}

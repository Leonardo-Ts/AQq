package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Map;

public interface ConclusionSiniestroDaoInterfase {
	
	public abstract Map<String, Object> obtenerInformacionDUA( String reporte);
	public abstract Map<String, Object> informacionFoliosDUA(final String reporte);
	public abstract String actualizarSiniestro(String reporte, String poliza, String siniestro);

}

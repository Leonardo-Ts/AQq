package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.sisesac.ReconocimientoSISE;
import com.aaq.col.clases.database.repositorios.impl.SiseSP_Dao;
import com.aaq.col.clases.database.servicios.interfase.SiseSP_ServiceInterfase;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;



@Service("siseSPService")
public class SiseSP_Service implements SiseSP_ServiceInterfase{
	
	@Autowired
	private SiseSP_Dao siseSP_Dao;

	@Override
	public List<String> actualizarTelefonosSise(List<Terminal> entradas) {
		return siseSP_Dao.actualizarTelefonosSise(entradas);
	}
	
	@Override
	public String reconocimientoSise(ReconocimientoSISE  entradas) {
		return siseSP_Dao.guardarRecSise(entradas);
	}

	@Override
	public EstadoCuenta obtenerEdoCta(String poliza, String inciso, String fecha, Terminal term, String reporteSAC, String ramo) {
		return this.siseSP_Dao.obtenerEdoCta(poliza, inciso, fecha, term, reporteSAC, ramo);
	}
	
	@Override
	public List<SerieEdoCta> serieEdoCta(Terminal term, String serie, String reporteSAC) {
			return this.siseSP_Dao.serieEdoCta(term, serie, reporteSAC);
	}
	
	@Override
	public List<Serie6EdoCta> serie6EdoCta(Terminal term, String serie, String reporteSAC) {
			return this.siseSP_Dao.serie6EdoCta(term, serie, reporteSAC);
	}
}

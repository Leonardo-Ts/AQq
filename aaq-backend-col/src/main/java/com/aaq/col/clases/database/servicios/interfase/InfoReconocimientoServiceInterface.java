package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.InfoReconocimiento;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface InfoReconocimientoServiceInterface  extends JMServicioGenericoInterfase<InfoReconocimiento>{

	public abstract InfoReconocimiento objetoInfoReconocimiento(String id) ;
	public abstract List<InfoReconocimiento> listaDeInfoReconocimienot(String reporte) ;
	public abstract JMResultadoOperacion eliminarObjeto(InfoReconocimiento inf) ;
	public abstract JMResultadoOperacion guardarObjeto(InfoReconocimiento info) ;
	
}

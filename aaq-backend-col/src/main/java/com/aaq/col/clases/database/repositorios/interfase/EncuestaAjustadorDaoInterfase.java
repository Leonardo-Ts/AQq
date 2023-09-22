package com.aaq.col.clases.database.repositorios.interfase;


import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.EncuestaAjustador;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface EncuestaAjustadorDaoInterfase extends JMRepositorioGenericoInterfase<EncuestaAjustador> {
	
	public abstract EncuestaAjustador objetoEncuestaAjustador(final String id);
	public abstract List<EncuestaAjustador> listaDeEncuestaAjustador(Date fechaBusquedaInicial, Date fechaBusquedaFinal,
			final Terminal claveA, final String reporte,final Estado estado,final Base base,final String poliza,
	        final Integer limite);
	public abstract List<EncuestaAjustador> listaDeEncuestaAjustadorSftp();
	public abstract String ejecutarFuncioninsertarEncuestaAjustador(String usuario,String passwd,
		    String numeroDeReporte,String nombreAsegurado,
			Integer atencionPersonalCabina,Integer llegadaAjustador,
			Integer presentacionAjustador,Integer tratoAjustador,
			Integer capacidadAjustador,Integer tratoAjustadorTercero,
			Integer servicioDeGrua,Integer seleccionDeTaller,
			boolean observoIrregularidadServicio,boolean recibioCopiaDA,
			String observaciones, String nombreConductor, String telefono,
			String correo,Integer idEstado,Integer idBase,String poliza);

	
			

}
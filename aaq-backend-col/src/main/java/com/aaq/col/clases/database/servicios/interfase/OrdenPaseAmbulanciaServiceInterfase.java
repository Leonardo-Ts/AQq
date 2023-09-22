package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.OrdenPaseAmbulancia;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface OrdenPaseAmbulanciaServiceInterfase extends JMServicioGenericoInterfase<OrdenPaseAmbulancia> {

	public abstract OrdenPaseAmbulancia objetoOrdenPaseAmbulancia(final String id);
	public abstract JMResultadoOperacion guardarObjeto(OrdenPaseAmbulancia t);
	public abstract List<OrdenPaseAmbulancia> listaDeOrdenPaseAmbulancia();
	public abstract String ejecutarFuncioninsertarValeAmbulancia(String usuario, String passwd, Date fechaHora,
			String reporte, String tipoAtencion, String claveHospital, String claveAmbulancia, String hospital,
			String direccionTraslado, String telefonoHospital, String nombreLesionado, String ubicacionLesionado,
			String edadLesionado, String sexoLesionado, String telefonoLesionado, String diagnostico,
			Integer id_ajustador, String reporteNumeroPoliza);

}
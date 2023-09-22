package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.OrdenPaseEquipoPesado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface OrdenPaseEquipoPesadoServiceInterfase extends JMServicioGenericoInterfase<OrdenPaseEquipoPesado> {

	public abstract OrdenPaseEquipoPesado objetoOrdenPaseEquipoPesado(final String id);
	public abstract JMResultadoOperacion guardarObjeto(OrdenPaseEquipoPesado t);
	public abstract List<OrdenPaseEquipoPesado> listaDeOrdenPaseEquipoPesado();
	public abstract String ejecutarFuncionInsertarPaseEquipoPesado(String usuario, String password, Date fechaHora,
			String numeroReporte, String tipoAtencion, String conductor, String telefonoConductor, String sumaAsegurada,
			String tipoDeducible, String porcentajeDeducible, String tipoProveedor, String claveProveedor,
			String responsableTaller, String telefonoTaller, String domicilioTaller, String marcaVehiculo,
			String modeloVehiculo, String serieVehiculo, String colorVehiculo, String placasVehiculo,
			Integer id_ajustador, String reporteNumeroPoliza);

}
 package com.aaq.col.system.webservices;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioArriboApp;
import com.aaq.col.clases.webservices.movil.peticion.MovilServicioTerminoApp;
import com.aaq.col.clases.xml.webservices.JMWSTerminalGenesys;

@WebService(name = "Genesys", targetNamespace = "http://siica.m2s.com.mx/SIICAServer/webservices")
public interface GenesysWebServiceInterfase {

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarArriboApp(
			@WebParam(name = "servicioArriboApp") final MovilServicioArriboApp servicioArriboApp);

	@WebMethod()
	@WebResult(name = "resultado")
	public MovilResultadoOperacion insertarTerminoApp(MovilServicioTerminoApp serv);
	
	@WebMethod()
	@WebResult(name = "terminal")
	public JMWSTerminalGenesys informacionTerminal(@WebParam(name = "usuario") String usuario);
	
}

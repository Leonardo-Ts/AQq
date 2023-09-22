package com.aaq.col.clases.webservices.wscabina.siniestro;

import java.net.MalformedURLException;
import java.net.URL;

import javax.persistence.RollbackException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import org.apache.cxf.feature.Features;
import org.eclipse.persistence.exceptions.TransactionException;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.siica.JMConstantes;


@SuppressWarnings("all")
@WebServiceClient(name = "WSSiniestroServiceImplService",  targetNamespace = "http://webservicesImpl.ws.cabina.qualitas.com/")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class WSSiniestroServiceImplService extends Service {

	public final static URL WSDL_LOCATION;

	public final static QName SERVICE = new QName("http://webservicesImpl.ws.cabina.qualitas.com/",
			"WSSiniestroServiceImplService");

	public final static QName WSSiniestroServiceImplPort = new QName("http://webservicesImpl.ws.cabina.qualitas.com/",
			"WSSiniestroServiceImplPort");
	static {
		URL url = null;
		try {
			url = new URL(Configuracion.getConfiguracionService().obtenerCadena(
					JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_WSDL));

		} catch (final ClassCastException | IndexOutOfBoundsException | RollbackException | TransactionException | MalformedURLException  e) {
			java.util.logging.Logger.getLogger(WSSiniestroServiceImplService.class.getName()).log(
					java.util.logging.Level.INFO, "Can not initialize the default wsdl from {0}");
		}
		WSDL_LOCATION = url;
	}

	public WSSiniestroServiceImplService(final URL wsdlLocation) {
		super(wsdlLocation, WSSiniestroServiceImplService.SERVICE);
	}

	public WSSiniestroServiceImplService(final URL wsdlLocation, final QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	/**
	 * @return returns WSSiniestroService
	 */
	@WebEndpoint(name = "WSSiniestroServiceImplPort")
	public WSSiniestroService getWSSiniestroServiceImplPort() {
		return super.getPort(WSSiniestroServiceImplService.WSSiniestroServiceImplPort, WSSiniestroService.class);
	}

	/**
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return returns WSSiniestroService
	 */
	@WebEndpoint(name = "WSSiniestroServiceImplPort")
	public WSSiniestroService getWSSiniestroServiceImplPort(final WebServiceFeature... features) {
		return super.getPort(WSSiniestroServiceImplService.WSSiniestroServiceImplPort, WSSiniestroService.class,
				features);
	}

}

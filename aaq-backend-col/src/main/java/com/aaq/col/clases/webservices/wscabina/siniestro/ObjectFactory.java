 package com.aaq.col.clases.webservices.wscabina.siniestro;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@SuppressWarnings("all")
/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jmfg.siicaserver.system.webservices.clientes.jaxb.wscabina.siniestro package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _AperturaEstimacionResponse_QNAME = new QName(
			"http://webservices.ws.cabina.qualitas.com/", "aperturaEstimacionResponse");

	private final static QName _AperturaEstimacion_QNAME = new QName("http://webservices.ws.cabina.qualitas.com/",
			"aperturaEstimacion");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * com.jmfg.siicaserver.system.webservices.clientes.jaxb.wscabina.siniestro
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link AperturaEstimacion }
	 */
	public AperturaEstimacion createAperturaEstimacion() {
		return new AperturaEstimacion();
	}

	/**
	 * Create an instance of {@link AperturaEstimacionResponse }
	 */
	public AperturaEstimacionResponse createAperturaEstimacionResponse() {
		return new AperturaEstimacionResponse();
	}

	/**
	 * Create an instance of {@link AperturaReserva }
	 */
	public AperturaReserva createAperturaReserva() {
		return new AperturaReserva();
	}

	/**
	 * Create an instance of {@link ResultadoAperturaEstimacion }
	 */
	public ResultadoAperturaEstimacion createResultadoAperturaEstimacion() {
		return new ResultadoAperturaEstimacion();
	}

	/**
	 * Create an instance of {@link Resultado }
	 */
	public Resultado createResultado() {
		return new Resultado();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AperturaEstimacionResponse }{@code >}
	 */
	@XmlElementDecl(namespace = "http://webservices.ws.cabina.qualitas.com/", name = "aperturaEstimacionResponse")
	public JAXBElement<AperturaEstimacionResponse> createAperturaEstimacionResponse(
			final AperturaEstimacionResponse value) {
		return new JAXBElement<AperturaEstimacionResponse>(ObjectFactory._AperturaEstimacionResponse_QNAME,
				AperturaEstimacionResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link AperturaEstimacion }{@code >}
	 */
	@XmlElementDecl(namespace = "http://webservices.ws.cabina.qualitas.com/", name = "aperturaEstimacion")
	public JAXBElement<AperturaEstimacion> createAperturaEstimacion(final AperturaEstimacion value) {
		return new JAXBElement<AperturaEstimacion>(ObjectFactory._AperturaEstimacion_QNAME, AperturaEstimacion.class,
				null, value);
	}

}

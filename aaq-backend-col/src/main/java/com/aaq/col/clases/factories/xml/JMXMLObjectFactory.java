 package com.aaq.col.clases.factories.xml;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.xml.link2b.JMLinkMotoContenedor;
import com.aaq.col.clases.xml.link2b.JMLinkResultadoTransaccion;
import com.aaq.col.clases.xml.webservices.JMWSResultadoOperacion;
import com.aaq.col.clases.xml.webservices.Resultado;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.fabricas.reporte.JMFabricaXML;

import java.util.ArrayList;


public class JMXMLObjectFactory extends JMFabricaXML {

	private static final long serialVersionUID = -3529606949342917849L;

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_FABRICAS);

	public JMXMLObjectFactory() {
		super();
		this.getXstreamObject().autodetectAnnotations(true);
		this.getXstreamObject().alias("Resultados", ArrayList.class);


	}



//	public JMWSDatosSolicitudGrua obtenerJMWSSolicitudGruaParaString(final String var) throws Exception {
//
//		try {
//			return (JMWSDatosSolicitudGrua) this.getXstreamObject().fromXML(var);
//		} catch (final Exception e) {
//			throw e;
//		}
//
//	}

//	public String obtenerStringParaJMSolicitudGrua(final JMWSDatosSolicitudGrua var) throws Exception {
//
//		try {
//			return this.getXstreamObject().toXML(var);
//		} catch (final Exception e) {
//			throw e;
//		}
//
//	}

//	public String obtenerStringParaJMDatosArribo(final JMWSDatosArribo var) {
//
//		try {
//			return this.getXstreamObject().toXML(var);
//		} catch (final Exception e) {
//			throw e;
//		}
//
//	}


	public String obtenerStringParaJMResultadoOperacion(final JMWSResultadoOperacion var) {
		try {
			return this.getXstreamObject().toXML(var).replaceAll("\n", "");
		} catch (final Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "obtenerStringParaJMResultadoOperacion", var);
		}

		return null;

	}


	public JMLinkMotoContenedor obtenerJMLinkMotoContenedorParaString(final String var) throws Exception {

		try {
			return (JMLinkMotoContenedor) this.getXstreamObject().fromXML(var);
		} catch (final Exception e) {
			throw new Exception(
					"Error Aplicativo Cobro Web: El Contenedor XML en formato XStream No Pudo Ser Interpretado: "
							+ e.getMessage());
		}

	}

	public JMLinkResultadoTransaccion obtenerJMLink2bResultadoTransaccionParaString(final String var) throws Exception {

		try {
			return (JMLinkResultadoTransaccion) this.getXstreamObject().fromXML(var);
		} catch (final Exception e) {
			throw new Exception(
					"Error Aplicativo Cobro Web: La respuesta del Servicio LINK2B No pudo Ser INterpretada: "
							+ e.getMessage());
		}

	}

	@SuppressWarnings("static-access")
	public String obtenerStringParaJMLinkMotoContenedor(final JMLinkMotoContenedor contenedor) {

		try {
			return this.headerMensajeXML() + this.getXstreamObject().toXML(contenedor);
		} catch (final Exception e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "obtenerStringParaJMLinkMotoContenedor",
					contenedor);
		}

		return null;

	}

//	@SuppressWarnings("static-access")
//	public String obtenerStringParaJMWSDatosGruaProveedor(final JMWSDatosGruaProveedor obj) {
//
//		try {
//			return this.headerMensajeXML() + this.getXstreamObject().toXML(obj);
//		} catch (final Exception e) {
//			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "obtenerStringParaJMWSDatosGruaProveedor", obj);
//		}
//
//		return null;
//
//	}

//	public JMWSDatosGruaProveedor obtenerJMWSDatosGruaProveedorParaString(final String obj) throws Exception {
//
//		try {
//			return (JMWSDatosGruaProveedor) this.getXstreamObject().fromXML(obj);
//		} catch (final Exception e) {
//			throw e;
//		}
//
//	}

	public Siniestro obtenerSiniestroParaString(final String in) throws Exception {
		try {
			return (Siniestro) this.getXstreamObject().fromXML(in);
		} catch (final Exception e) {
			throw e;
		}

	}

	public Resultado obtenerResultadoParaString(final String in) throws Exception {
		try {
			return (Resultado) this.getXstreamObject().fromXML(in);
		} catch (final Exception e) {
			throw e;
		}
	}

//	@SuppressWarnings("static-access")
//	public String obtenerStringParaJMWSDatosGestion(final JMWSDatosGestion var) {
//
//		try {
//			return this.headerMensajeXML() + this.getXstreamObject().toXML(var).replaceAll("\n", "");
//		} catch (final Exception e) {
//			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "obtenerStringParaJMWSDatosGestion", var);
//		}
//
//		return null;
//	}
}

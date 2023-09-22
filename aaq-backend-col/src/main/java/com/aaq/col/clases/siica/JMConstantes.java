/*
 * Propietario y confidencial.
 *
 * Copyright (C) Integracion de Sistemas de Avanzada Tecnologia, SA de CV - Todos los Derechos Reservados.
 * La copia no autorizada de este archivo, por cualquier medio, esta estrictamente prohibida
 * Los contenidos de este archivo estan sujetos a cambio en cualquier momento sin aviso previo.
 * Este documento no confiere al receptor el derecho o licencia de hacer, usar, vender o practicar cualquier
 * tecnologia o metodos descritos en el mismo.
 * Ninguno de los contenidos, en su totalidad o en partes, pueden ser copiados o distribidos por cualquier
 * medio fisico o electronico sin el consentimiento previo, expreso y escrito de
 * Integracion de  Sistemas de Avanzada Tecnologia
 *
 * Proprietary and confidential
 *
 * Copyright (C) Controltrack, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * All information contained herein is, and remains
 * the property of Controltrack Inc and its suppliers, if any.
 * The intellectual and technical concepts contained herein are proprietary to Controltrack Inc.
 *
 *
 * Desarrolloado por Jose Miguel Fernandez <mfernandez@controltrack.net>, Octubre 2005 - Marzo 2015
 *
 *
 */
package com.aaq.col.clases.siica;

import java.io.Serializable;

// **************************************************************//
// Lista de Constantes Globales de la aplicacion
// **************************************************************//

/**
 * 31/07/2008 03:04:09
 * 
 * @author mfernandez
 */
public class JMConstantes implements Serializable {

	/**
	 * Nov 6, 2007 7:03:03 PM
	 */
	private static final long serialVersionUID = -6740235106776564454L;

	// **************************************************************//
	// Constantes de Pagina
	// **************************************************************//

	// Bean Extensible -> Principal
	/** Some field */
	public static final String BEAN_SIICA_APLICACION = "JMBeanSIICAAplicacion";

	/** Some field */
	public static final String BEAN_SOCKET_SMS = "JMBeanSocketSMS";

	/** Some field */
	public static final String PRINCIPAL_LIGA_INICIO_SIN_SESSION = "/Sistema/firma.siica";

	/** Some field */
	public static final String PRINCIPAL_LIGA_INICIO_CON_SESSION = "/Sistema/sistema.siica";

	// **************************************************************//
	// Constantes de Estatus de Terminal
	// **************************************************************//
	/** Some field */
	public static final int TERMINAL_ESTATUS_DISPONIBLE = 1;

	/** Some field */
	public static final int TERMINAL_ESTATUS_OCUPADO = 2;

	/** Some field */
	public static final int TERMINAL_ESTATUS_DESCONECTADO = 3;

	/** Some field */
	public static final int TERMINAL_ESTATUS_NO_DEFINIDO = 4;

	/** Some field */
	public static final int TERMINAL_ESTATUS_OTROS = 5;

	/** Some field */
	public static final int TERMINAL_ESTATUS_NO_TRABAJANDO = 6;

	// **************************************************************//
	// Constantes de Clases CSS
	// **************************************************************//

	/** Some field */
	public static final String CSS_COLUMNA_1_DEMORA = "terminal_fecha_demora";

	/** Some field */
	public static final String CSS_COLUMNA_1_OK = "terminal_fecha_ok";

	/** Some field */
	public static final String CSS_COLUMNA_CONECTADO_DEMORA = "terminal_fecha_conectado_demora";

	/** Some field */
	public static final String CSS_COLUMNA_CONECTADO_OK = "terminal_fecha_conectado_ok";

	/** Some field */
	public static final String CSS_COLUMNA_REPORTE_NULL = "terminal_fecha_reporte_nulo";

	/** Some field */
	public static final String CSS_COLUMNA_REPORTE_NOT_NULL = "terminal_reporte_no_nulo";

	/** Some field */
	public static final String CSS_COLUMNA_FHT2_OK = "terminal_fecha_hora_tiempo_dos_ok";

	/** Some field */
	public static final String CSS_COLUMNA_FHT2_S1 = "terminal_fecha_hora_tiempo_dos_s1";

	/** Some field */
	public static final String CSS_COLUMNA_FHT2_S2 = "terminal_fecha_hora_tiempo_dos_s2";

	/** Some field */
	public static final String CSS_COLUMNA_FHT2_S3 = "terminal_fecha_hora_tiempo_dos_s3";

	/** Some field */
	public static final String CSS_COLUMNA_DESCONECTADO_NULL = "terminal_fecha_desconectado_nulo";

	/** Some field */
	public static final String CSS_COLUMNA_DESCONECTADO_NOT_NULL = "terminal_fecha_desconectado_no_nulo";

	/** Some field */
	public static final String CSS_GRUA_VERDE = "css_grua_verde";

	/** Some field */
	public static final String CSS_GRUA_AMARILLO = "css_grua_amarillo";

	/** Some field */
	public static final String CSS_GRUA_ROJO = "css_grua_rojo";

	// **************************************************************//
	// Constantes de Modulos del Sistema
	// **************************************************************//

	// modulos de cirstales
	/** Some module */
	public static final String MODULO_APLICACION_CRISTALES_ALTA = "/Aplicacion/cristalesv2.alta.siica";

	/** Some module */
	public static final String MODULO_APLICACION_CRISTALES_SEGUIMIENTO = "/Aplicacion/cristalesv2.seguimiento.siica";

	/** Some module */
	public static final String MODULO_APLICACION_CRISTALES_VALIDACION = "/Aplicacion/cristalesv2.validacion.siica";

	// modulos de aplicaciones
	/** Some module */
	public static final String MODULO_APLICACION_ALARMA_DATOS_EXTENDIDOS = "/Aplicacion/alarmaDetalle.siica";
	
	/**Modulo para enviar notificiacion personal*/
	public static final String MODULO_APLICACION_ALARMA_NOTIFICACION =  "/Aplicacion/notificacionPersonal.siica";

	/** Some module */
	public static final String MODULO_APLICACION_ALARMA_ESTATUS_AJUSTADOR = "/SIICAGlobal/alarmaEstatusAjustadores.siica";

	/** Some module */
	public static final String MODULO_APLICACION_ALARMA_CHECKBOX = "/SIICAGlobal/alarmaCheckboxDisponibilidad.siica";

	/** Some module */
	public static final String MODULO_APLICACION_ALARMA_VISTA_CLASICA = "/SIICAGlobal/alarmaVisualizacionClasica.siica";

	/** Some module */
	public static final String MODULO_APLICACION_GRUA_DATOS_EXTENDIDOS = "/Aplicacion/gruaDetalle.siica";

	/** Some module */
	public static final String MODULO_APLICACION_COBRO_WEB = "/Aplicacion/cobroWeb.siica";
	
	/** Some module */
	public static final String MODULO_APLICACION_ENCUESTA_MOVIL = "/Aplicacion/encuestasDetalle.siica";

	// globla
	/** Some module */
	public static final String MODULO_GLOBAL_PERMISO_REPORTE_BANCARIO_DATOS_TARJETA = "/SIICAGlobal/datosTarjeta.siica";

	/** Some module */
	public static final String MODULO_GLOBAL_PERMISO_TODOS_LOS_ESTADOS = "/SIICAGlobal/todosLosEstados.siica";

	/** Some module */
	public static final String MODULO_GLOBAL_PERMISO_TODOS_LAS_BASES = "/SIICAGlobal/todasLasBases.siica";

	/** Some module */
	public static final String MODULO_CATALOGO_USUARIO_CALIDAD_PROVEEDOR = "/Aplicacion/controlcalidad.supervisor.talleres.siica";
	
	public static final String MODULO_APLICACION_ALARMA_NOTAS =  "/Aplicacion/notas.siica";

	// **************************************************************//
	// Constantes de Acciones de Pagina
	// **************************************************************//

	/** Some field */
	public transient static final String WEB_PARAMETRO_IDENTI = "id";

	/** Some field */
	public static final int WEB_TIPO_PAGINA_CAPTURA = 1;

	/** Some field */
	public static final int WEB_TIPO_PAGINA_CONFIRMACION = 2;

	/** Some field */
	public static final int WEB_TIPO_PAGINA_RESULTADO = 3;

	/** Some field */
	public static final int WEB_TIPO_PAGINA_VALIDACION = 4;

	/** Some field */
	public static final int WEB_TIPO_PAGINA_VISUALIZACION = 5;

	/** some crap */
	public static final String ICONO_SINIESTRO_ARRASTRABLE = "punto_arrastrable";

	/** some crap */
	public static final String ICONO_SINIESTRO_NO_ARRASTRABLE = "punto_no_arrastrable";

	/** some crap */
	public static final String ICONO_VEHICULO_DISPONIBLE = "vehiculo_disponible";
	/** some crap */
	public static final String ICONO_VEHICULO_DISPONIBLE_BASE = "vehiculo_disponible_base";

	/** some crap */
	public static final String ICONO_VEHICULO_OCUPADO = "vehiculo_ocupado";
	/** some crap */
	public static final String ICONO_VEHICULO_OCUPADO_BASE = "vehiculo_ocupado_base";

	/** some crap */
	public static final String ICONO_VEHICULO_DESCONECTADO = "vehiculo_desconectado";

	/** some crap */
	public static final String ICONO_VEHICULO_DESCONECTADO_BASE = "vehiculo_desconectado_base";

	/** some crap */
	public static final String ICONO_VEHICULO_NARANJA = "vehiculo_naranja";

	/** some crap */
	public static final String ICONO_VEHICULO_SIN_GPS = "vehiculo_sin_gps";

	/** some crap */
	public static final String ICONO_VEHICULO_INACTIVO = "vehiculo_inactivo";

	/** some crap */
	public static final String ICONO_VEHICULO_OTROS = "vehiculo_otros";

	/** some crap */
	public static final String ICONO_NO_TRABAJANDO = "vehiculo_no_trabajando";

	/** some crap */
	public static final String ICONO_VEHICULO_BLANCO = "vehiculo_blanco";
	
	/** some crap*/
	public static final String ICONO_MOTO_DISPONIBLE = "moto_disponible";
	
	/** some crap*/
	public static final String ICONO_MOTO_DESCONECTADO = "moto_desconectado";
	
	/** some crap*/
	public static final String ICONO_MOTO_OCUPADO = "moto_ocupado";
	
	/** some crap*/
	public static final String ICONO_MOTO_SIN_GPS = "moto_sin_gps";
	
	public static final String ICONO_EXPRES_DISPONIBLE = "expres_disponible";
	
	public static final String ICONO_EXPRES_VPOSICION = "expres_sin_gps";
	
	public static final String ICONO_EXPRES_OCUPADO = "expres_ocupado";
	
	public static final String ICONO_EXPRES_DESCONECTADO = "expres_desconectado";
	
	public static final String ICONO_EQUIPO_PESADO_DISPONIBLE="equipo_pesado_disponible";
	public static final String ICONO_EQUIPO_PESADO_DESCONECTADO="equipo_pesado_desconectado";
	public static final String ICONO_EQUIPO_PESADO_OCUPADO="equipo_pesado_ocupado";
	public static final String ICONO_EQUIPO_PESADO_VPOSICION="equipo_pesado_sin_gps";

	// **************************************************************//
	// Constantes de Objetos de session
	// **************************************************************//

	/** some crap */
	public transient static  final  String SESSION_WEB_OBJETO_USUARIO = "usuario";

	/** some crap */
	public transient static final String SESSION_WEB_OBJETO_PERMISO = "permiso";

	/** some crap */
	public transient static final String SESSION_WEB_OBJETO_TERMINAL = "terminal";

	/** some crap */
	public transient static final String SESSION_WEB_OBJETO_HASHCODE = "hashcode";

	// **************************************************************//
	// Constantes de Propiedades de configuracion de la aplicacion
	// **************************************************************//
	/** some crap */
	public static final String PORTAL_AVQ_CONFIGURACION_PORTAL_PROVEEDOR_PAGINA_INICIO = "configuracion.avq.catalogos.proveedores.portal.edicion.inicio";

	/** some crap */
	public static final String PORTAL_AVQ_CONFIGURACION_PORTAL_PROVEEDOR_PAGINA_CONTACTO = "configuracion.avq.catalogos.proveedores.portal.edicion.contacto";

	/** some crap */
	public static final String PORTAL_AVQ_CONFIGURACION_PORTAL_PROVEEDOR_PAGINA_SCROLLER = "configuracion.avq.catalogos.proveedores.portal.edicion.scroller";

	/** some crap */
	public static final String CONFIGURACION_AVQ_CONFIGURACION_SERVICIOS_MENSAJES_SMS_CLIENTE = "configuracion.siica.avq.servicios.mensajes.sms.cliente";

	/** some crap */
	public transient static final String CONFIGURACION_AVQ_FACTURACION_EMAIL_CC = "configuracion.siica.avq.facturacion.correo.electronico.cc";

	/** some crap */
	public static final String CONFIGURACION_AVQ_FACTURACION_ARCHIVO_XML_PATH = "configuracion.siica.avq.facturacion.archivo.xml.path";

	/** some crap */
	public static final String CONFIGURACION_AVQ_FACTURACION_ARCHIVO_PDF_PATH = "configuracion.siica.avq.facturacion.archivo.pdf.path";

	/** some crap */
	public static final String CONFIGURACION_AVQ_MODO_REDUCIDO = "configuracion.siica.avq.modo.reducido";

	/** some crap */
	public static final String CONFIGURACION_SERVIDOR_COMPANIA = "configuracion.servidor.sistema.compania";

	/** some crap */
	public static final String CONFIGURACION_MAPAS_EQUIVALENCIAS_ESTADO = "configuracion.mapas.satelital.equivalencia.estado.";

	/** some crap */
	public static final String CONFIGURACION_MAPAS_EQUIVALENCIAS_CARTOGRAFIA = "configuracion.mapas.satelital.equivalencia.cartografia.";

	/** gryas */
	public static final String CONFIGURACION_GRUAS_CORREOS_CABINA = "configuracion.siica.gruas.correos.cabina";

	/** gryas */
	public static final String CONFIGURACION_GRUAS_SMS_CABINA = "configuracion.siica.gruas.sms.cabina";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL = "configuracion.siica.sistema.email.from";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_HOST = "configuracion.siica.sistema.email.host.direccion";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA = "configuracion.siica.sistema.email.conexion.segura";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_PUERTO = "configuracion.siica.sistema.email.host.puerto";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_USUARIO = "configuracion.siica.sistema.email.usuario";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_PASSWD = "configuracion.siica.sistema.email.passwd";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_LOGIN = "configuracion.siica.sistema.email.iniciar.login";

	/** mail */
	public transient static final String CONFIGURACION_MAIL_SERVER_DEBUG = "configuracion.siica.sistema.email.debug";
	
	/** Alarma mails */
	public transient static final String CONFIGURACION_MAIL_ALARMA_INICIAR = "configuracion.siica.sistema.alarma.mails.iniciar";

	/** Alarma mails */
	public transient static final String CONFIGURACION_MAIL_ALARMA_INTERVALO = "configuracion.siica.sistema.alarma.mails.intervalo";

	/** Alarma mails */
	public transient static final String CONFIGURACION_MAIL_CORREOS_ALARMA = "configuracion.siica.sistema.alarma.mails.correos";
	
	/** FTP Host */
	public static final String CONFIGURACION_OP_FTP_HOST = "configuracion.siica.sistema.orden.pases.host.ftp";
	
	/** FTP Usuario */
	public static final String CONFIGURACION_OP_FTP_USUARIO = "configuracion.siica.sistema.orden.pases.usuario.ftp";
	
	/** FTP Password */
	public transient static final String CONFIGURACION_OP_FTP_PASSWD = "configuracion.siica.sistema.orden.pases.passwd.ftp";
	
	/** FTP MAIL ENABLE */
	public transient static final String CONFIGURACION_OP_FTP_MAIL_ENABLE = "configuracion.siica.sistema.orden.pases.passwd.mail.enable";
	
	/** FTP Host */
	public static final String CONFIGURACION_OP_FTP_PUERTO = "configuracion.siica.sistema.orden.pases.puerto.ftp";
	
	/** FTP Hora Envio */
	public transient static final String CONFIGURACION_OP_FTP_ENVIO_EMAIL = "configuracion.siica.sistema.orden.pases.envioemail.ftp";
	
	/** FTP Timer Iniciar */
	public static final String CONFIGURACION_OP_FTP_TIMER_INICIAR = "configuracion.siica.sistema.orden.pases.iniciar";

	/** FTP Timer Intervalo */
	public static final String CONFIGURACION_OP_FTP_TIMER_INTERVALO = "configuracion.siica.sistema.orden.pases.intervalo";
	
	/** FTP Path Intervalo */
	public static final String CONFIGURACION_OP_FTP_PATH = "configuracion.siica.sistema.orden.pases.path";	
	
	/** FTP Path Mensaje Email */
	public transient static final String CONFIGURACION_OP_FTP_MENSAJE_EMAIL = "configuracion.siica.sistema.orden.pases.mensaje.email";	
		
		
	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_GENERAL_COBRAR_MINIMO = "configuracion.siica.cobro.web.general.cobrar.minimo";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_GENERAL_MONTO_MAXIMO = "configuracion.siica.cobro.web.general.monto.maximo";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_GENERAL_LLAVE_ENCRIPCION = "configuracion.siica.cobro.web.general.llave.encripcion";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT = "configuracion.siica.cobro.web.moto.amex.merchant";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT_3_MESES = "configuracion.siica.cobro.web.moto.amex.merchant.3.meses";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT_6_MESES = "configuracion.siica.cobro.web.moto.amex.merchant.6.meses";

	/** link2b moto amex */
	public static final String CONFIGURACION_LINK2B_MOTO_AMEX_CCTYPE = "configuracion.siica.cobro.web.moto.amex.cc.type";
	
	/**Claves comodines**/
	public static final String CONFIGURACION_SIICA_SERVER_CLAVES_COMODIN = "configuracion.siica.webservices.claves.comodin";
	
	/** Polizas Especiales Insertar ARCA**/
	public static final String CONFIGURACION_SIICA_INSERTARARCA_POLIZAS = "configuracion.siica.insertarArca.polizas";

	// link2b moto
	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_COMPANY = "configuracion.siica.cobro.web.moto.company";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_BRANCH = "configuracion.siica.cobro.web.moto.branch";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_COUNTRY = "configuracion.siica.cobro.web.moto.country";

	/** link2b moto */
	public transient static final String CONFIGURACION_LINK2B_MOTO_US_NA = "configuracion.siica.cobro.web.moto.username";

	/** link2b moto */
	public transient static final String CONFIGURACION_LINK2B_MOTO_PASSWD = "configuracion.siica.cobro.web.moto.passwd";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_MERCHANT = "configuracion.siica.cobro.web.moto.merchant";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_TP_OPERACION = "configuracion.siica.cobro.web.moto.tp.operacion";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_CRYPTO = "configuracion.siica.cobro.web.moto.crypto";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_TYPE = "configuracion.siica.cobro.web.moto.type";

	/** link2b moto */
	public static final String CONFIGURACION_LINK2B_MOTO_CURRENCY = "configuracion.siica.cobro.web.moto.currency";

	/** link2b moto meses sin intereses */
	public static final String CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_TP_OPERACION = "configuracion.siica.cobro.web.moto.tp.operacion.meses.sin.intereses";

	/** link2b moto meses sin intereses */
	public static final String CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_MERCHANT_3_MESES = "configuracion.siica.cobro.web.moto.merchant.3.meses";

	/** link2b moto meses sin intereses */
	public static final String CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_MERCHANT_6_MESES = "configuracion.siica.cobro.web.moto.merchant.6.meses";

	// link2b -> server
	/** link2b general */
	public static final String CONFIGURACION_LINK2B_SERVER_URL = "configuracion.siica.cobro.web.host.direccion";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_SIICASERVER_SIICA_EMERGENCIA_MOVIL_CORREO_CC = "configuracion.siica.webservices.emergencia.movil.correo.cc";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_SIICASERVER_SIICA_WEB_SERVICE_END_POINT = "configuracion.siica.webservices.jaxb.siicaserver.siica.web.service";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_WS_ASISTENCIA_VIAL_END_POINT = "configuracion.siica.webservices.jaxb.ws.asistencia.vial.endpoint";

	/** webservices jaxb */
	public transient static final String CONFIGURACION_WEBSERVICES_JAXB_WS_ASISTENCIA_VIAL_US_NA = "configuracion.siica.webservices.jaxb.ws.asistencia.vial.usuario";

	/** webservices jaxb */
	public transient static final String CONFIGURACION_WEBSERVICES_JAXB_WS_ASISTENCIA_VIAL_PASSWD = "configuracion.siica.webservices.jaxb.ws.asistencia.vial.passwd";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_REPUVE_END_POINT = "configuracion.siica.webservices.jaxb.repuve";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_WS_QUALITAS_REPORTE_ULTIMA_POSICION_INICIAR = "configuracion.siica.webservices.jaxb.wsqualitas.reporte.ultima.posicion.iniciar";
	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_WS_QUALITAS_REPORTE_ULTIMA_POSICION_INTERVALO = "configuracion.siica.webservices.jaxb.wsqualitas.reporte.ultima.posicion.intervalo";
	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_WS_QUALITAS_REPORTE_ULTIMA_POSICION_WSDL = "configuracion.siica.webservices.jaxb.wsqualitas.reporte.ultima.posicion.wsdl";
	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_WS_QUALITAS_REPORTE_ULTIMA_POSICION_USUARIO = "configuracion.siica.webservices.jaxb.wsqualitas.reporte.ultima.posicion.usuario";
	/** webservices jaxb */
	public transient static final String CONFIGURACION_WEBSERVICES_JAXB_WS_QUALITAS_REPORTE_ULTIMA_POSICION_PASSWD = "configuracion.siica.webservices.jaxb.wsqualitas.reporte.ultima.posicion.passwd";


	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_COBERTURA_SERVICE_END_POINT = "configuracion.siica.webservices.jaxb.cobertura.service";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_CONTROL_DOCS_SERVICE_END_POINT = "configuracion.siica.webservices.jaxb.control.docs.service";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_CONTROL_DOCS_MOVIL_SERVICE_END_POINT = "configuracion.siica.webservices.jaxb.control.docs.service.movil";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_ALARMA_ESTADO_CUENTA_END_POINT = "configuracion.siica.webservices.jaxb.alarmas.estado.de.cuenta";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_AVQ_CATALOGOS_SERVICE_END_POINT = "configuracion.siica.webservices.jaxb.avq.catalogos.service";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_AVQ_WS_EDO_CTA_POINT = "configuracion.siica.webservices.jaxb.avq.wsEdoCta";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_AVQ_WS_REPORTES_END_POINT = "configuracion.siica.webservices.jaxb.ws.reporte.endpoint";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_BANORTE_CATALOGOS_CABINA_INICIAR = "configuracion.banorte.ws.catalogos.cabina.iniciar";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_BANORTE_CATALOGOS_CABINA_INTERVALO = "configuracion.banorte.ws.catalogos.cabina.intervalo";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_BANORTE_CATALOGOS_CABINA_ENDPOINT = "configuracion.banorte.ws.catalogos.cabina.endpoint";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_BANORTE_CATALOGOS_CABINA_OFICINAS = "configuracion.banorte.ws.catalogos.cabina.oficinas";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_WSDL = "configuracion.siica.webservices.jaxb.estimacion.wsdl";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_COBERTURA_ESTIMACION_USUARIO = "configuracion.siica.webservices.jaxb.estimacion.usuario";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_CABINA_REPORTE = "configuracion.siica.webservices.jaxb.wscabina.reporte";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_CABINA_UBICACION = "configuracion.siica.webservices.jaxb.wscabina.ubicacion";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_CABINA_GRUAS = "configuracion.siica.webservices.jaxb.wscabina.gruas";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_CABINA_GRUAS_USUARIO = "configuracion.siica.webservices.jaxb.wscabina.gruas.usuario";

	/** webservices jaxb */
	public transient static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_CABINA_GRUAS_PASSWD = "configuracion.siica.webservices.jaxb.wscabina.gruas.passwd";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_MOVIL_WS_AVISOS_ASIGNACION_WSDL = "configuracion.siica.webservices.jaxb.ws.avisos.asignacion.wsdl";

	/** webservices jaxb */
	public static final String CONFIGURACION_WEBSERVICES_JAXB_SIICA_WEB_SERVICIOS_REPORTE = "configuracion.siica.webservices.jaxb.siica.web.servicios.reporte";

	/** webservices axis 1 */
	public static final String CONFIGURACION_WEBSERVICES_AXIS1_LEGAL_GENERAR_REPORTE = "configuracion.siica.webservices.axis1.legal.generar.reporte";

	/** webservices axis 1 */
	public static final String CONFIGURACION_WEBSERVICES_AXIS1_SISE_CONSULTA_PORT = "configuracion.siica.webservices.axis1.sise.consulta.port";

	/** webservices axis 1 */
	public static final String CONFIGURACION_WEBSERVICES_AXIS1_SISE_SINIESTRO_PORT = "configuracion.siica.webservices.axis1.sise.siniestro.port";

	/** webservices axis 1 */
	public static final String CONFIGURACION_WEBSERVICES_AXIS1_V3_SISE_CONSULTA_PORT = "configuracion.siica.webservices.axis1.v3.sise.consulta.port";

	/** webservices axis 1 */
	public static final String CONFIGURACION_WEBSERVICES_AXIS1_V3_SISE_SINIESTRO_PORT = "configuracion.siica.webservices.axis1.v3.sise.siniestro.port";

	/** some crap */
	public static final String CONFIGURACION_SMS_SOCKET_INICIAR_SOCKET = "configuracion.siica.socket.sms.iniciar";

	/** some crap */
	public static final String CONFIGURACION_SMS_SOCKET_HOST = "configuracion.siica.socket.sms.host.direccion.ip";

	/** some crap */
	public static final String CONFIGURACION_SMS_SOCKET_PUERTO = "configuracion.siica.socket.sms.host.puerto";
	
	/** some crap */
	public static final String CONFIGURACION_SMS_URI_CONCEPTO_MOVIL = "configuracion.siica.webservices.sms.base_uri";
	
	/** some crap */
	public static final String CONFIGURACION_SMS_USUARIO_CONCEPTO_MOVIL = "configuracion.siica.webservices.sms.usuario";
	
	/** some crap */
	public transient static final String CONFIGURACION_SMS_PASSWORD_CONCEPTO_MOVIL = "configuracion.siica.webservices.sms.password";
	
	/** some crap */
	public static final String CONFIGURACION_SMS_SOCKET_NUMERO_TELEFONICO_ORIGEN_PARA_AJUSTADORES = "configuracion.siica.socket.sms.telefono.ajustadores";

	/** some crap */
	public static final String CONFIGURACION_SMS_SOCKET_NUMERO_TELEFONICO_ORIGEN_PARA_CLIENTES = "configuracion.siica.socket.sms.telefono.clientes";

	/** some crap */
	public static final String CONFIGURACION_SIICA_INTERFASE_VERSION = "configuracion.interfase.siica.version";

	/** some crap */
	public static final String cONFIGURACION_SIICA_INTERFASE_LOGO = "configuracion.interfase.siica.logo";

	/** some crap */
	public static final String CONFIGURACION_SIICA_INTERFASE_REVISION = "configuracion.interfase.siica.revision";

	/** some crap */
	public static final String CONFIGURACION_SIICA_INTERFASE_COPYRIGHT = "configuracion.interfase.siica.copyright";

	/** some crap */
	public static final String CONFIGURACION_SIICA_INTERFASE_SCROLLER = "configuracion.interfase.siica.scroller";

	/** some crap */
	public static final String CONFIGURACION_SIICA_INTERFASE_RESPONSABLE_NOMBRE = "configuracion.interfase.siica.responsable.nombre";

	/** some crap */
	public transient static final String CONFIGURACION_SIICA_INTERFASE_RESPONSABLE_EMAIL = "configuracion.interfase.siica.responsable.email";

	/** webservices resful */
	public static final String CONFIGURACION_WEBSERVICES_RESTFUL_PUSH_SERVICES = "configuracion.siica.webservices.restful.push.services";
	
	/** webservices consutarDocQContent **/
	public static final String CONFIGURACION_WEBSERVICES_WsUCMConsultaAC_WSDL = "configuracion.siica.webservices.consultaac.wsdl";
	
	// **************************************************************//
	// Constantes de Tipo de Reportes
	// **************************************************************//

	/** some crap */
	public static final String REPORTE_XML = "xml";

	/** some crap */
	public static final String REPORTE_EXCEL = "excel";

	/** some crap */
	public static final String REPORTE_PDF = "pdf";

	/** Some field */
	public static final String SOCKET_FUENTE_SISE = "SISE";

	/** Some field */
	public static final String SOCKET_FUENTE_SIICA_WEB = "SIICA Web";

	/** Some field */
	public static final String SOCKET_FUENTE_MAP_DATA = "MAPDATA";

	/** Some field */
	public static final String SOCKET_FUENTE_CELULAR = "Celular";
	
	/** Some field */
	public static final String SOCKET_FUENTE_SIICA_AV = "SIICA AV";

	/** Some field */
	public static final String SOCKET_FUENTE_BANORTE_CATALOGOS_CABINA = "Banorte CC";

	/** Some field */
	public static final String SOCKET_FUENTE_BANORTE_WS = "Banorte WS";

	/** Some field */
	public static final String TRANSACCION_FUENTE_WEB = "SIICA Web";

	/** Some field */
	public static final String TRANSACCION_FUENTE_CELULAR = "Celular";

	/** Some field */
	public static final String AVQ_REPORTE_CON_COSTO_ASEGURADO = "** C/costo Asegurado **";
	
	/*************************** Configuraciones para notificaciones **************************/
	
	public static final String CONFIGURACION_NOTIFICACIONES_PERMISO_SMS = "configuracion.aaq.aplicacion.notificaciones.permiso.sms";
	
	public static final String CONFIGURACION_NOTIFICACIONES_PERMISO_PUSH = "configuracion.aaq.aplicacion.notificaciones.permiso.push";
	
	public static final String CONFIGURACION_NOTIFICACIONES_PERMISO_CORREO = "configuracion.aaq.aplicacion.notificaciones.permiso.correo";
	
	/*************************** Variables de longitud ****************************************/
	
	public static final String CONFIGURACION_NOTIFICACIONES_TAMANO_SMS = "configuracion.aaq.aplicacion.notificaciones.tamano.sms" ;
	
	public static final String CONFIGURACION_NOTIFICACIONES_TAMANO_PUSH = "configuracion.aaq.aplicacion.notificaciones.tamano.push";	
	
	/*************************** Configuraciones para alertas **************************/
	
	// ALERTA LOGIN
	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO = "configuracion.aaq.sistema.alerta.login.activo";
	
	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO_DIRECTOR = "configuracion.aaq.sistema.alerta.login.activo.director";
	
	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.login.activo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO_GERENTE = "configuracion.aaq.sistema.alerta.login.activo.gerente";
	
	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO_COORDINADOR = "configuracion.aaq.sistema.alerta.login.activo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_LOGIN_TIEMPO = "configuracion.aaq.sistema.alerta.login.tiempo";

	public static final String CONFIGURACION_ALERTA_LOGIN_ACTIVO_SUPERVISOR = "configuracion.aaq.sistema.alerta.login.activo.supervisor";

	
	// ALERTA LOGOUT
	public static final String CONFIGURACION_ALERTA_LOGOUT_ACTIVO = "configuracion.aaq.sistema.alerta.logout.activo";
	
	public static final String CONFIGURACION_ALERTA_LOGOUT_ACTIVO_DIRECTOR = "configuracion.aaq.sistema.alerta.logout.activo.director";
	
	public static final String CONFIGURACION_ALERTA_LOGOUT_ACTIVO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.logout.activo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_LOGOUT_ACTIVO_GERENTE = "configuracion.aaq.sistema.alerta.logout.activo.gerente";
	
	public static final String CONFIGURACION_ALERTA_LOGOUT_ACTIVO_COORDINADOR = "configuracion.aaq.sistema.alerta.logout.activo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_LOGOUT_TIEMPO = "configuracion.aaq.sistema.alerta.logout.tiempo";
	
	// ALERTA TIEMPO DISPONIBLE (TIEMPO MUERTO)
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_ACTIVO = "configuracion.aaq.sistema.alerta.ajustador.disponible.activo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_INTERVALO = "configuracion.aaq.sistema.alerta.ajustador.disponible.intervalo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_INTERVALO_DIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.disponible.intervalo.director";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_INTERVALO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.disponible.intervalo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_INTERVALO_GERENTE = "configuracion.aaq.sistema.alerta.ajustador.disponible.intervalo.gerente";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_INTERVALO_COORDINADOR = "configuracion.aaq.sistema.alerta.ajustador.disponible.intervalo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_AJUS_DISPONIBLE_TIEMPO = "configuracion.aaq.sistema.alerta.ajustador.disponible.tiempo";
	
	// ALERTA TIEMPO OCUPADO
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_ACTIVO = "configuracion.aaq.sistema.alerta.ajustador.ocupado.activo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_INTERVALO = "configuracion.aaq.sistema.alerta.ajustador.ocupado.intervalo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_INTERVALO_DIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.ocupado.intervalo.director";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_INTERVALO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.ocupado.intervalo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_INTERVALO_GERENTE = "configuracion.aaq.sistema.alerta.ajustador.ocupado.intervalo.gerente";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_INTERVALO_COORDINADOR = "configuracion.aaq.sistema.alerta.ajustador.ocupado.intervalo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_AJUS_OCUPADO_TIEMPO = "configuracion.aaq.sistema.alerta.ajustador.ocupado.tiempo";
	
	// ALERTA POSTARRIBO
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_ACTIVO = "configuracion.aaq.sistema.alerta.ajustador.postarribo.activo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_ACTIVO_DIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.postarribo.activo.director";
	
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_ACTIVO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.postarribo.activo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_ACTIVO_GERENTE = "configuracion.aaq.sistema.alerta.ajustador.postarribo.activo.gerente";
	
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_ACTIVO_COORDINADOR = "configuracion.aaq.sistema.alerta.ajustador.postarribo.activo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_AJUS_POSTARRIBO_TIEMPO = "configuracion.aaq.sistema.alerta.ajustador.postarribo.tiempo";
	
	// ALERTA NO DISPONIBLE
	
	public static final String CONFIGURACION_ALERTA_AJUS_NO_DISPONIBLE_ACTIVO = "configuracion.aaq.sistema.alerta.ajustador.nodisponible.activo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_NO_DISPONIBLE_INTERVALO = "configuracion.aaq.sistema.alerta.ajustador.nodisponible.intervalo";
	
	// PERMISOS DE CORREO Y SMS PARA ALERTAS
	public static final String CONFIGURACION_ALERTAS_PERMISO_CORREO = "configuracion.aaq.sistema.alertas.permiso.correo";
	
	public static final String CONFIGURACION_ALERTAS_PERMISO_SMS = "configuracion.aaq.sistema.alertas.permiso.sms";
		
	public static final long MINUTO_A_MILISEGUNDO = 60000;
	
	public static final long METRO_A_KILOMETRO = 1000;
	
	// PERMISOS SMS Y URL GENESYS
	
	public static final String CONFIGURACION_GENESYS_PERMISO_SMS = "configuracion.aaq.sistema.genesys.permiso.sms";
	
	public static final String CONFIGURACION_GENESYS_URL_SMS = "configuracion.aaq.sistema.genesys.url.sms";
	
	// PERMISOS SMS Y PUSH ASIGNACION
	
	public static final String CONFIGURACION_PERMISO_SMS_ASIGNACION = "configuracion.aaq.sistema.asignacion.permiso.sms";
	
	public static final String CONFIGURACION_PERMISO_PUSH_ASIGNACION = "configuracion.aaq.sistema.asignacion.permiso.push";
	
	// ALERTA TERMINO DISTANCIA
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_ACTIVO = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.activo";
	
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_ACTIVO_DIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.activo.director";
	
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_ACTIVO_SUBDIRECTOR = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.activo.subdirector";
	
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_ACTIVO_GERENTE = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.activo.gerente";
	
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_ACTIVO_COORDINADOR = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.activo.coordinador";
	
	public static final String CONFIGURACION_ALERTA_AJUS_TERMINODISTANCIA_KILOMETROS = "configuracion.aaq.sistema.alerta.ajustador.terminodistancia.distancia";
	
	// TIMER CANCELAR REPORTES
	
	public static final String CONFIGURACION_TIMER_CANCELAR_REPORTE_ACTIVO = "configuracion.aaq.sistema.timer.cancelarreporte.activo";
	
	public static final String CONFIGURACION_TIMER_CANCELAR_REPORTE_INTERVALO = "configuracion.aaq.sistema.timer.cancelarreporte.intervalo";
	
	public static final String CONFIGURACION_CANCELAR_REPORTE_TIEMPO = "configuracion.aaq.sistema.cancelarreporte.tiempo";
	
	//PERMISOS PARA ACTIVAR SCHEDULER
	public static final String PERMISOS_ACTIVAR_SCHEDULER_AVISAS_AJUSTADOR ="configuracion.aaq.sistema.correo.ajustador.enviar.permiso";
	
	// ELASTIC SEARCH
	public static final String CONFIGURACION_ASIGNACION_CUNCURRENT_REPORTES_URL="configuracion.aaq.sistema.asignacion.concurrent.reportes.url";
	
	//Version Ajustador para Inicio de Sesión
	public static final String CONFIGURACION_VERSION_AJUSTADOR = "configuracion.aaq.sistema.sesion.ajustador.version";

	// **************************************************************//
			// Constantes para REST
	// **************************************************************//
	public static final  String CODIGO_ERROR = "0";
	public static final  String CODIGO_OK = "1";
	public static final  String CODIGO_NO_DATOS = "2";
			
	// Configuracion para EDUA AMIS
	public transient static final String CLI_AMIS = "configuracion.aaq.sistema.amis.cliente.id";
	public transient static final String US_NA_AMIS = "configuracion.aaq.sistema.amis.username";
	public transient static final String PWD_AMIS = "configuracion.aaq.sistema.amis.password";
	public static final String GRANT_TYPE_AMIS = "configuracion.aaq.sistema.amis.grant.type";
	public static final String CLIENT_SECRET_AMIS = "configuracion.aaq.sistema.amis.client.secret";
	public static final String CORREO_AJUSTADOR_AMIS = "configuracion.aaq.sistema.amis.folio.correo";
	
	// Configuracion para EDUA AMIS URL de Servicios
	public static final String URL_TOKEN_AMIS = "configuracion.aaq.sistema.amis.generar.token";
	public static final String URL_GENERAR_FOLIO_AMIS = "configuracion.aaq.sistema.amis.generar.folio";
	public static final String URL_VINCULAR_FOLIO_AMIS = "configuracion.aaq.sistema.amis.vincular.folio";
	public static final String URL_SINCRONIZACION_AMIS = "configuracion.aaq.sistema.amis.sincronizar.siniestro";
	public static final String URL_ENVIO_FOTOGRAFIAS_AMIS = "configuracion.aaq.sistema.amis.enviar.fotografias";
	public static final String URL_INFORMACION_CONTRAPARTE_AMIS = "configuracion.aaq.sistema.amis.informacion.contraparte";
	public static final String URL_REFOLEO_AMIS = "configuracion.aaq.sistema.amis.refoleo";
	public static final String URL_EMISION_VALE_DIGITAL_AMIS = "configuracion.aaq.sistema.amis.emision.vale.digital";
	public static final String URL_RECEPCION_VALE_DIGITAL_AMIS = "configuracion.aaq.sistema.amis.recepcion.vale.digital";
	public static final String URL_GENERAR_ORDENES_PAGO_AMIS = "configuracion.aaq.sistema.amis.generar.ordenes.pago";
	public static final String URL_TERMINO_ATENCION_AMIS = "configuracion.aaq.sistema.amis.termino.atencion";
	public static final String URL_ENVIAR_INFORME_AJUSTADOR_AMIS = "configuracion.aaq.sistema.amis.informe.ajustador";
	public static final String URL_GENERAR_FOLIO_SERVICIO_AMIS = "configuracion.aaq.sistema.amis.folio.servicio";
	public static final String URL_CANCELAR_FOLIO_AMIS = "configuracion.aaq.sistema.amis.cancelar.folio";
	public static final String URL_CONSULTAR_FOLIO_AMIS = "configuracion.aaq.sistema.amis.consultar.folio";
	public static final String URL_VINCULAR_FOLIO_CONTRAPARTE = "configuracion.aaq.sistema.amis.vincular.folio.contraparte";
	public static final String URL_SINCRONIZACION_CONTRAPARTE_AMIS = "configuracion.aaq.sistema.amis.sincronizar.siniestro.contraparte";

	
	// Servidor de catalogos para AMIS
	public static final String SERVIDOR_CATALOGOS_AMIS = "configuracion.aaq.sistema.amis.catalogos.servidor";
	public static final String USUARIO_CATALOGOS_AMIS = "configuracion.aaq.sistema.amis.catalogos.usuario";
	public transient static final String PASSWORD_CATALOGOS_AMIS = "configuracion.aaq.sistema.amis.catalogos.password";
	public static final String URL_CATALOGOS_ZIP_AMIS = "configuracion.aaq.sistema.amis.generar.catalogos.zip";
	public static final String URL_CATALOGOS_ZIP_ESPECIALES_AMIS = "configuracion.aaq.sistema.amis.generar.catalogos.zip.especiales";
	public static final String PERMISO_CATALOGOS_AMIS = "configuracion.aaq.sistema.amis.generar.catalogos.permiso";
	public static final String URL_CATALOGO_NEW_SERVICE_AMIS = "configuracion.aaq.sistema.amis.catalogos.url.servicio"; 
	public static final String PERMISO_CATALOGOS_ESPEC_AMIS = "configuracion.aaq.sistema.amis.generar.catalogos.especiales.permiso";
	
	// URL de AMIS para catalogos
	public static final String URL_METADATOS_CATALOGOS = "configuracion.aaq.sistema.amis.catalogos.url.metadatos";
	public static final String URL_DATOS_CATALOGOS = "configuracion.aaq.sistema.amis.catalogos.url.datos";
	
	// URL de AMIS para Certificados
	public static final String URL_CERFITICADO_AMIS = "configuracion.aaq.sistema.amis.llaves.publicas";
		
	public static final String SLASH = "/"; // unix
//	public static final String SLASH = "\\";// windows
	public static final String PIPE = "|"; 

	// Datos de SMS Migracion
	public transient static final String SMS_APIKEY = "configuracion.aaq.sistema.alerta.sms.apikey";
	public static final String SMS_COUNTRY = "configuracion.aaq.sistema.alerta.sms.country";
	public static final String SMS_DIAL = "configuracion.aaq.sistema.alerta.sms.dial";
	public static final String SMS_LADA = "configuracion.aaq.sistema.alerta.sms.lada";
	public transient static final String SMS_TOKEN = "configuracion.aaq.sistema.alerta.sms.token";
	public static final String SMS_URL = "configuracion.aaq.sistema.alerta.sms.url";
	
	public static final String PERMISO_ENCUESTA_CORREO_ADMIN = "configuracion.aaq.sistema.permiso.encuesta.correo.admin";
	
	public static final String TIEMPO_ESTATUS_DISPONIBLE = "configuracion.aaq.sistema.tiempo.estatus.disponible";
	
	public static final String PERMISO_ARRIBO_CERCANIA = "configuracion.aaq.sistema.arribo.cercania.permiso";
	public static final String DISTANCIA_ARRIBO_CERCANIA = "configuracion.aaq.sistema.arribo.cercania.distancia.metros";
	public static final String TIMEOUT_CAT_SEGUNDOS_AMIS = "configuracion.aaq.sistema.amis.timeout.catalogos.segundos";
	public static final String TIMEOUT_SERV_SEGUNDOS_AMIS = "configuracion.aaq.sistema.amis.timeout.servicios.segundos";
	
	// Propiedades de Link de Caja
	public transient static final String LINK_PAGO_URL = "configuracion.aaq.sistema.link.pago.url";
	public transient static final String LINK_PAGO_USUARIO = "configuracion.aaq.sistema.link.pago.usuario";
	public transient static final String LINK_PAGO_BRANCH = "configuracion.aaq.sistema.link.pago.branch";
	public transient static final String LINK_PAGO_TOKEN = "configuracion.aaq.sistema.link.pago.token";
	public static final String FUENTE_LINK_PAGO = "Link De Pago";

	public transient static final String LINK_PAGO_URL_DEDUCIBLE = "configuracion.aaq.sistema.link.pago.url.deducible";
	public transient static final String LINK_PAGO_URL_PRIMA = "configuracion.aaq.sistema.link.pago.url.prima";
	
	public static final String ICONO_UBICACION = "ubicacion";
	
	public static final String CONFIGURACION_CANCELAR_REPORTE_AUTOMATICO_ACTIVO = "configuracion.aaq.sistema.cancelar.reporte.automatico.activo";
	public static final String SOCKET_FUENTE_SIICA_AUTOMATICO= "SIICA AUTOMATICO";
	
	public static final String CONFIGURACION_QCONTENT_SERVIDOR_PUERTO_DOC = "configuracion.siica.servidor.puerto.qcontent.doc";
	public static final String CONFIGURACION_CHATGUS_URL = "configuracion.siica.webservices.chatgus.outboundmessage.url";
	public static final String CONFIGURACION_CHATGUS_USUARIO = "configuracion.siica.webservices.chatgus.outboundmessage.usuario";
	public static final String CONFIGURACION_CHATGUS_CONTRA = "configuracion.siica.webservices.chatgus.outboundmessage.contra";
	
	public static final String CONFIGURACION_NOTIF_CORREO_UNIFICADO = "configuracion.aaq.sistema.notificacion.correo.termino.unificado";
	public static final String CONFIGURACION_JNDI_SISE_ALTERNO = "configuracion.aaq.sistema.jndi.sise.alterno";
	
	public static final String RAMO_EDO_CTA = "03";
	// Caracteres de separacion para parseo de rutinas
	public static final String CHAR_PARSE1 = "|";
	public static final String CHAR_PARSE2 = "#";
	public static final String CHAR_PARESLASH = "&";
	public static final int CHAR_THORN = 254;
	public static final int CHAR_Y = 253;
	
	public static final String CONFIGURACION_POLIZA_ESPERA_SINIESTRO = "configuracion.aaq.sistema.poliza.espera.siniestro";

}

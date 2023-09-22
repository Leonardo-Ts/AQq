/**
 * 
 */
package com.aaq.col.clases.webservices.ordenes;

import java.sql.Timestamp;
import java.util.Date;
//import java.util.Date;

/**
 * @author jpestrategica6
 *
 */
public class ServicioFormatosInventarioUnicoPesado {
	

 private String usuario;
	 private String passwd;
	private String inp_folio_e;
	private String inp_serie;
	private String inp_color;
	private String inp_placas;
	private String inp_num_reporte;
	private String inp_num_siniestro;
	private String inp_num_poliza;
	private String inp_num_asegurado;
	private String inp_nombre_afectado;
	private Integer inp_llaves;
	private Timestamp inp_fecha;
	private String inp_num_endoso;
	private String inp_num_inciso;
	private String inp_marca;
	private String inp_tipo;
	private String inp_puertas;
	private String inp_modelo;
	private String inp_num_motor;
	private String inp_kilometraje;
	private Integer inp_combustible;
	private String inp_correo;
	private String inp_tractocamion_pieza;
	private String inp_originales_camion;
	private String inp_renovadas_camion;
	private String inp_daniadas_camion;
	private String inp_faltantes_camion;
	private String inp_daniadas_remolque;
	private String inp_faltantes_remolque;
	private String inp_nombre_conductor;
	private String inp_nombre_operador_grua;
	private Date inp_caso1_fecha;
	private String inp_caso1_lugar;
	private String inp_caso1_observaciones;
	private String inp_caso1_nom_entrega;
	private String inp_caso1_nom_recibe;
	private Date inp_caso2_fecha;
	private String inp_caso2_lugar;
	private String inp_caso2_observaciones;
	private String inp_caso2_nom_entrega;
	private String inp_caso2_nom_recibe;
	private Date inp_caso3_fecha;
	private String inp_caso3_lugar;
	private String inp_caso3_observaciones;
	private String inp_caso3_nom_entrega;
	private String inp_caso3_nom_recibe;
	private String firma_ajustador;
	private String firma_conductor;
	private String firma_operador_grua;
	private String firma_caso1_entrega;
	private String firma_caso1_recibe;
	private String firma_caso2_entrega;
	private String firma_caso2_recibe;
	private String firma_caso3_entrega;
	private String firma_caso3_recibe;
	private String inp_nom_ajustador;
	private String inp_clave_ajustador;
	private Integer check_1;
	private Integer check_2;
	private Integer check_3;
	private Integer check_4;
	
	private String inp_correo_grua;
	private String inp_correo_taller;
	private Integer inp_caso_1_ubicacion_flecha;
	private String inp_caso_1_a_lugar;
	private String inp_caso_1_prestador;
	private String inp_caso_1_danios_faltantes;
	private String inp_caso_1_crucero;
	private String inp_caso_1_taller;
	private String inp_caso_1_mp;
	private String inp_caso_1_ajustador;
	private Integer inp_caso_2_ubicacion_flecha;
	private String inp_caso_2_a_lugar;
	private String inp_caso_2_prestador;
	private String inp_caso_2_danios_faltantes;
	private String inp_caso_2_crucero;
	private String inp_caso_2_taller;
	private String inp_caso_2_mp;
	private String inp_caso_2_ajustador;
	private Integer inp_caso_3_ubicacion_flecha;
	private String inp_caso_3_a_lugar;
	private String inp_caso_3_prestador;
	private String inp_caso_3_danios_faltantes;
	private String inp_caso_3_crucero;
	private String inp_caso_3_taller;
	private String inp_caso_3_mp;
	private String inp_caso_3_ajustador;
	private String inp_nom_entrega_gral;
	private String inp_nom_recibe_gral;
	private String firma_recibe_gral;
	private String firma_entrega_gral;
	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getInp_num_reporte() {
		return inp_num_reporte;
	}
	public void setInp_num_reporte(String inp_num_reporte) {
		this.inp_num_reporte = inp_num_reporte;
	}
	public String getInp_num_siniestro() {
		return inp_num_siniestro;
	}
	public void setInp_num_siniestro(String inp_num_siniestro) {
		this.inp_num_siniestro = inp_num_siniestro;
	}
	public String getInp_num_poliza() {
		return inp_num_poliza;
	}
	public void setInp_num_poliza(String inp_num_poliza) {
		this.inp_num_poliza = inp_num_poliza;
	}
	public String getInp_num_asegurado() {
		return inp_num_asegurado;
	}
	public void setInp_num_asegurado(String inp_num_asegurado) {
		this.inp_num_asegurado = inp_num_asegurado;
	}
	public String getInp_nombre_afectado() {
		return inp_nombre_afectado;
	}
	public void setInp_nombre_afectado(String inp_nombre_afectado) {
		this.inp_nombre_afectado = inp_nombre_afectado;
	}
	public Integer getInp_llaves() {
		return inp_llaves;
	}
	public void setInp_llaves(Integer inp_llaves) {
		this.inp_llaves = inp_llaves;
	}
	public Timestamp getInp_fecha() {
		return inp_fecha;
	}
	public void setInp_fecha(Timestamp inp_fecha) {
		this.inp_fecha = inp_fecha;
	}
	public String getInp_num_endoso() {
		return inp_num_endoso;
	}
	public void setInp_num_endoso(String inp_num_endoso) {
		this.inp_num_endoso = inp_num_endoso;
	}
	public String getInp_num_inciso() {
		return inp_num_inciso;
	}
	public void setInp_num_inciso(String inp_num_inciso) {
		this.inp_num_inciso = inp_num_inciso;
	}
	public String getInp_marca() {
		return inp_marca;
	}
	public void setInp_marca(String inp_marca) {
		this.inp_marca = inp_marca;
	}
	public String getInp_tipo() {
		return inp_tipo;
	}
	public void setInp_tipo(String inp_tipo) {
		this.inp_tipo = inp_tipo;
	}
	public String getInp_puertas() {
		return inp_puertas;
	}
	public void setInp_puertas(String inp_puertas) {
		this.inp_puertas = inp_puertas;
	}
	public String getInp_modelo() {
		return inp_modelo;
	}
	public void setInp_modelo(String inp_modelo) {
		this.inp_modelo = inp_modelo;
	}
	public String getInp_num_motor() {
		return inp_num_motor;
	}
	public void setInp_num_motor(String inp_num_motor) {
		this.inp_num_motor = inp_num_motor;
	}
	public String getInp_kilometraje() {
		return inp_kilometraje;
	}
	public void setInp_kilometraje(String inp_kilometraje) {
		this.inp_kilometraje = inp_kilometraje;
	}
	public Integer getInp_combustible() {
		return inp_combustible;
	}
	public void setInp_combustible(Integer inp_combustible) {
		this.inp_combustible = inp_combustible;
	}
	public String getInp_correo() {
		return inp_correo;
	}
	public void setInp_correo(String inp_correo) {
		this.inp_correo = inp_correo;
	}
	public String getInp_tractocamion_pieza() {
		return inp_tractocamion_pieza;
	}
	public void setInp_tractocamion_pieza(String inp_tractocamion_pieza) {
		this.inp_tractocamion_pieza = inp_tractocamion_pieza;
	}
	public String getInp_originales_camion() {
		return inp_originales_camion;
	}
	public void setInp_originales_camion(String inp_originales_camion) {
		this.inp_originales_camion = inp_originales_camion;
	}
	public String getInp_renovadas_camion() {
		return inp_renovadas_camion;
	}
	public void setInp_renovadas_camion(String inp_renovadas_camion) {
		this.inp_renovadas_camion = inp_renovadas_camion;
	}
	public String getInp_daniadas_camion() {
		return inp_daniadas_camion;
	}
	public void setInp_daniadas_camion(String inp_daniadas_camion) {
		this.inp_daniadas_camion = inp_daniadas_camion;
	}
	public String getInp_faltantes_camion() {
		return inp_faltantes_camion;
	}
	public void setInp_faltantes_camion(String inp_faltantes_camion) {
		this.inp_faltantes_camion = inp_faltantes_camion;
	}
	public String getInp_daniadas_remolque() {
		return inp_daniadas_remolque;
	}
	public void setInp_daniadas_remolque(String inp_daniadas_remolque) {
		this.inp_daniadas_remolque = inp_daniadas_remolque;
	}
	public String getInp_faltantes_remolque() {
		return inp_faltantes_remolque;
	}
	public void setInp_faltantes_remolque(String inp_faltantes_remolque) {
		this.inp_faltantes_remolque = inp_faltantes_remolque;
	}
	public String getInp_nombre_conductor() {
		return inp_nombre_conductor;
	}
	public void setInp_nombre_conductor(String inp_nombre_conductor) {
		this.inp_nombre_conductor = inp_nombre_conductor;
	}
	public String getInp_nombre_operador_grua() {
		return inp_nombre_operador_grua;
	}
	public void setInp_nombre_operador_grua(String inp_nombre_operador_grua) {
		this.inp_nombre_operador_grua = inp_nombre_operador_grua;
	}
	public Date getInp_caso1_fecha() {
		return inp_caso1_fecha;
	}
	public void setInp_caso1_fecha(Date inp_caso1_fecha) {
		this.inp_caso1_fecha = inp_caso1_fecha;
	}
	public String getInp_caso1_lugar() {
		return inp_caso1_lugar;
	}
	public void setInp_caso1_lugar(String inp_caso1_lugar) {
		this.inp_caso1_lugar = inp_caso1_lugar;
	}
	public String getInp_caso1_observaciones() {
		return inp_caso1_observaciones;
	}
	public void setInp_caso1_observaciones(String inp_caso1_observaciones) {
		this.inp_caso1_observaciones = inp_caso1_observaciones;
	}
	public String getInp_caso1_nom_entrega() {
		return inp_caso1_nom_entrega;
	}
	public void setInp_caso1_nom_entrega(String inp_caso1_nom_entrega) {
		this.inp_caso1_nom_entrega = inp_caso1_nom_entrega;
	}
	public String getInp_caso1_nom_recibe() {
		return inp_caso1_nom_recibe;
	}
	public void setInp_caso1_nom_recibe(String inp_caso1_nom_recibe) {
		this.inp_caso1_nom_recibe = inp_caso1_nom_recibe;
	}
	public Date getInp_caso2_fecha() {
		return inp_caso2_fecha;
	}
	public void setInp_caso2_fecha(Date inp_caso2_fecha) {
		this.inp_caso2_fecha = inp_caso2_fecha;
	}
	public String getInp_caso2_lugar() {
		return inp_caso2_lugar;
	}
	public void setInp_caso2_lugar(String inp_caso2_lugar) {
		this.inp_caso2_lugar = inp_caso2_lugar;
	}
	public String getInp_caso2_observaciones() {
		return inp_caso2_observaciones;
	}
	public void setInp_caso2_observaciones(String inp_caso2_observaciones) {
		this.inp_caso2_observaciones = inp_caso2_observaciones;
	}
	public String getInp_caso2_nom_entrega() {
		return inp_caso2_nom_entrega;
	}
	public void setInp_caso2_nom_entrega(String inp_caso2_nom_entrega) {
		this.inp_caso2_nom_entrega = inp_caso2_nom_entrega;
	}
	public String getInp_caso2_nom_recibe() {
		return inp_caso2_nom_recibe;
	}
	public void setInp_caso2_nom_recibe(String inp_caso2_nom_recibe) {
		this.inp_caso2_nom_recibe = inp_caso2_nom_recibe;
	}
	public Date getInp_caso3_fecha() {
		return inp_caso3_fecha;
	}
	public void setInp_caso3_fecha(Date inp_caso3_fecha) {
		this.inp_caso3_fecha = inp_caso3_fecha;
	}
	public String getInp_caso3_lugar() {
		return inp_caso3_lugar;
	}
	public void setInp_caso3_lugar(String inp_caso3_lugar) {
		this.inp_caso3_lugar = inp_caso3_lugar;
	}
	public String getInp_caso3_observaciones() {
		return inp_caso3_observaciones;
	}
	public void setInp_caso3_observaciones(String inp_caso3_observaciones) {
		this.inp_caso3_observaciones = inp_caso3_observaciones;
	}
	public String getInp_caso3_nom_entrega() {
		return inp_caso3_nom_entrega;
	}
	public void setInp_caso3_nom_entrega(String inp_caso3_nom_entrega) {
		this.inp_caso3_nom_entrega = inp_caso3_nom_entrega;
	}
	public String getInp_caso3_nom_recibe() {
		return inp_caso3_nom_recibe;
	}
	public void setInp_caso3_nom_recibe(String inp_caso3_nom_recibe) {
		this.inp_caso3_nom_recibe = inp_caso3_nom_recibe;
	}
	public String getFirma_ajustador() {
		return firma_ajustador;
	}
	public void setFirma_ajustador(String firma_ajustador) {
		this.firma_ajustador = firma_ajustador;
	}
	public String getFirma_conductor() {
		return firma_conductor;
	}
	public void setFirma_conductor(String firma_conductor) {
		this.firma_conductor = firma_conductor;
	}
	public String getFirma_operador_grua() {
		return firma_operador_grua;
	}
	public void setFirma_operador_grua(String firma_operador_grua) {
		this.firma_operador_grua = firma_operador_grua;
	}
	public String getFirma_caso1_entrega() {
		return firma_caso1_entrega;
	}
	public void setFirma_caso1_entrega(String firma_caso1_entrega) {
		this.firma_caso1_entrega = firma_caso1_entrega;
	}
	public String getFirma_caso1_recibe() {
		return firma_caso1_recibe;
	}
	public void setFirma_caso1_recibe(String firma_caso1_recibe) {
		this.firma_caso1_recibe = firma_caso1_recibe;
	}
	public String getFirma_caso2_entrega() {
		return firma_caso2_entrega;
	}
	public void setFirma_caso2_entrega(String firma_caso2_entrega) {
		this.firma_caso2_entrega = firma_caso2_entrega;
	}
	public String getFirma_caso2_recibe() {
		return firma_caso2_recibe;
	}
	public void setFirma_caso2_recibe(String firma_caso2_recibe) {
		this.firma_caso2_recibe = firma_caso2_recibe;
	}
	public String getFirma_caso3_entrega() {
		return firma_caso3_entrega;
	}
	public void setFirma_caso3_entrega(String firma_caso3_entrega) {
		this.firma_caso3_entrega = firma_caso3_entrega;
	}
	public String getFirma_caso3_recibe() {
		return firma_caso3_recibe;
	}
	public void setFirma_caso3_recibe(String firma_caso3_recibe) {
		this.firma_caso3_recibe = firma_caso3_recibe;
	}
	public String getInp_nom_ajustador() {
		return inp_nom_ajustador;
	}
	public void setInp_nom_ajustador(String inp_nom_ajustador) {
		this.inp_nom_ajustador = inp_nom_ajustador;
	}
	public String getInp_clave_ajustador() {
		return inp_clave_ajustador;
	}
	public void setInp_clave_ajustador(String inp_clave_ajustador) {
		this.inp_clave_ajustador = inp_clave_ajustador;
	}
	public Integer getCheck_1() {
		return check_1;
	}
	public void setCheck_1(Integer check_1) {
		this.check_1 = check_1;
	}
	public Integer getCheck_2() {
		return check_2;
	}
	public void setCheck_2(Integer check_2) {
		this.check_2 = check_2;
	}
	public Integer getCheck_3() {
		return check_3;
	}
	public void setCheck_3(Integer check_3) {
		this.check_3 = check_3;
	}
	public Integer getCheck_4() {
		return check_4;
	}
	public void setCheck_4(Integer check_4) {
		this.check_4 = check_4;
	}
	public String getInp_folio_e() {
		return inp_folio_e;
	}
	public void setInp_folio_e(String inp_folio_e) {
		this.inp_folio_e = inp_folio_e;
	}
	public String getInp_serie() {
		return inp_serie;
	}
	public void setInp_serie(String inp_serie) {
		this.inp_serie = inp_serie;
	}
	public String getInp_color() {
		return inp_color;
	}
	public void setInp_color(String inp_color) {
		this.inp_color = inp_color;
	}
	public String getInp_placas() {
		return inp_placas;
	}
	public void setInp_placas(String inp_placas) {
		this.inp_placas = inp_placas;
	}
	public String getInp_correo_grua() {
		return inp_correo_grua;
	}
	public void setInp_correo_grua(String inp_correo_grua) {
		this.inp_correo_grua = inp_correo_grua;
	}
	public String getInp_correo_taller() {
		return inp_correo_taller;
	}
	public void setInp_correo_taller(String inp_correo_taller) {
		this.inp_correo_taller = inp_correo_taller;
	}
	public Integer getInp_caso_1_ubicacion_flecha() {
		return inp_caso_1_ubicacion_flecha;
	}
	public void setInp_caso_1_ubicacion_flecha(Integer inp_caso_1_ubicacion_flecha) {
		this.inp_caso_1_ubicacion_flecha = inp_caso_1_ubicacion_flecha;
	}
	public String getInp_caso_1_a_lugar() {
		return inp_caso_1_a_lugar;
	}
	public void setInp_caso_1_a_lugar(String inp_caso_1_a_lugar) {
		this.inp_caso_1_a_lugar = inp_caso_1_a_lugar;
	}
	public String getInp_caso_1_prestador() {
		return inp_caso_1_prestador;
	}
	public void setInp_caso_1_prestador(String inp_caso_1_prestador) {
		this.inp_caso_1_prestador = inp_caso_1_prestador;
	}
	public String getInp_caso_1_danios_faltantes() {
		return inp_caso_1_danios_faltantes;
	}
	public void setInp_caso_1_danios_faltantes(String inp_caso_1_danios_faltantes) {
		this.inp_caso_1_danios_faltantes = inp_caso_1_danios_faltantes;
	}
	public String getInp_caso_1_crucero() {
		return inp_caso_1_crucero;
	}
	public void setInp_caso_1_crucero(String inp_caso_1_crucero) {
		this.inp_caso_1_crucero = inp_caso_1_crucero;
	}
	public String getInp_caso_1_taller() {
		return inp_caso_1_taller;
	}
	public void setInp_caso_1_taller(String inp_caso_1_taller) {
		this.inp_caso_1_taller = inp_caso_1_taller;
	}
	public String getInp_caso_1_mp() {
		return inp_caso_1_mp;
	}
	public void setInp_caso_1_mp(String inp_caso_1_mp) {
		this.inp_caso_1_mp = inp_caso_1_mp;
	}
	public String getInp_caso_1_ajustador() {
		return inp_caso_1_ajustador;
	}
	public void setInp_caso_1_ajustador(String inp_caso_1_ajustador) {
		this.inp_caso_1_ajustador = inp_caso_1_ajustador;
	}
	public Integer getInp_caso_2_ubicacion_flecha() {
		return inp_caso_2_ubicacion_flecha;
	}
	public void setInp_caso_2_ubicacion_flecha(Integer inp_caso_2_ubicacion_flecha) {
		this.inp_caso_2_ubicacion_flecha = inp_caso_2_ubicacion_flecha;
	}
	public String getInp_caso_2_a_lugar() {
		return inp_caso_2_a_lugar;
	}
	public void setInp_caso_2_a_lugar(String inp_caso_2_a_lugar) {
		this.inp_caso_2_a_lugar = inp_caso_2_a_lugar;
	}
	public String getInp_caso_2_prestador() {
		return inp_caso_2_prestador;
	}
	public void setInp_caso_2_prestador(String inp_caso_2_prestador) {
		this.inp_caso_2_prestador = inp_caso_2_prestador;
	}
	public String getInp_caso_2_danios_faltantes() {
		return inp_caso_2_danios_faltantes;
	}
	public void setInp_caso_2_danios_faltantes(String inp_caso_2_danios_faltantes) {
		this.inp_caso_2_danios_faltantes = inp_caso_2_danios_faltantes;
	}
	public String getInp_caso_2_crucero() {
		return inp_caso_2_crucero;
	}
	public void setInp_caso_2_crucero(String inp_caso_2_crucero) {
		this.inp_caso_2_crucero = inp_caso_2_crucero;
	}
	public String getInp_caso_2_taller() {
		return inp_caso_2_taller;
	}
	public void setInp_caso_2_taller(String inp_caso_2_taller) {
		this.inp_caso_2_taller = inp_caso_2_taller;
	}
	public String getInp_caso_2_mp() {
		return inp_caso_2_mp;
	}
	public void setInp_caso_2_mp(String inp_caso_2_mp) {
		this.inp_caso_2_mp = inp_caso_2_mp;
	}
	public String getInp_caso_2_ajustador() {
		return inp_caso_2_ajustador;
	}
	public void setInp_caso_2_ajustador(String inp_caso_2_ajustador) {
		this.inp_caso_2_ajustador = inp_caso_2_ajustador;
	}
	public Integer getInp_caso_3_ubicacion_flecha() {
		return inp_caso_3_ubicacion_flecha;
	}
	public void setInp_caso_3_ubicacion_flecha(Integer inp_caso_3_ubicacion_flecha) {
		this.inp_caso_3_ubicacion_flecha = inp_caso_3_ubicacion_flecha;
	}
	public String getInp_caso_3_a_lugar() {
		return inp_caso_3_a_lugar;
	}
	public void setInp_caso_3_a_lugar(String inp_caso_3_a_lugar) {
		this.inp_caso_3_a_lugar = inp_caso_3_a_lugar;
	}
	public String getInp_caso_3_prestador() {
		return inp_caso_3_prestador;
	}
	public void setInp_caso_3_prestador(String inp_caso_3_prestador) {
		this.inp_caso_3_prestador = inp_caso_3_prestador;
	}
	public String getInp_caso_3_danios_faltantes() {
		return inp_caso_3_danios_faltantes;
	}
	public void setInp_caso_3_danios_faltantes(String inp_caso_3_danios_faltantes) {
		this.inp_caso_3_danios_faltantes = inp_caso_3_danios_faltantes;
	}
	public String getInp_caso_3_crucero() {
		return inp_caso_3_crucero;
	}
	public void setInp_caso_3_crucero(String inp_caso_3_crucero) {
		this.inp_caso_3_crucero = inp_caso_3_crucero;
	}
	public String getInp_caso_3_taller() {
		return inp_caso_3_taller;
	}
	public void setInp_caso_3_taller(String inp_caso_3_taller) {
		this.inp_caso_3_taller = inp_caso_3_taller;
	}
	public String getInp_caso_3_mp() {
		return inp_caso_3_mp;
	}
	public void setInp_caso_3_mp(String inp_caso_3_mp) {
		this.inp_caso_3_mp = inp_caso_3_mp;
	}
	public String getInp_caso_3_ajustador() {
		return inp_caso_3_ajustador;
	}
	public void setInp_caso_3_ajustador(String inp_caso_3_ajustador) {
		this.inp_caso_3_ajustador = inp_caso_3_ajustador;
	}
	public String getInp_nom_entrega_gral() {
		return inp_nom_entrega_gral;
	}
	public void setInp_nom_entrega_gral(String inp_nom_entrega_gral) {
		this.inp_nom_entrega_gral = inp_nom_entrega_gral;
	}
	public String getInp_nom_recibe_gral() {
		return inp_nom_recibe_gral;
	}
	public void setInp_nom_recibe_gral(String inp_nom_recibe_gral) {
		this.inp_nom_recibe_gral = inp_nom_recibe_gral;
	}
	public String getFirma_recibe_gral() {
		return firma_recibe_gral;
	}
	public void setFirma_recibe_gral(String firma_recibe_gral) {
		this.firma_recibe_gral = firma_recibe_gral;
	}
	public String getFirma_entrega_gral() {
		return firma_entrega_gral;
	}
	public void setFirma_entrega_gral(String firma_entrega_gral) {
		this.firma_entrega_gral = firma_entrega_gral;
	}
	
	
}

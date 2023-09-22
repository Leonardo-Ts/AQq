package com.aaq.col.system.beans.extensibles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Calle;
import com.aaq.col.clases.database.entidades.CalleCruce;
import com.aaq.col.clases.database.entidades.Cartografia;
import com.aaq.col.clases.database.entidades.Colonia;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.util.TiempoDeLlegada;
import com.aaq.col.system.beans.aplicacion.monitoreo.mapa.JMMotorDeMapas1;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPoligonoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
//import com.jmfg.jmlib.sistema.fabricas.mapas.JMMotorDeMapas;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

public abstract class JMBeanExtensibleMapa<T extends JMEntidad> extends JMBeanExtensiblePrincipal<T> {
	private static final long serialVersionUID = -2645614975417422752L;

	// Busquedas
	private List<Calle> listaDeCalles = new Vector<>();
	private List<CalleCruce> listaDeCruces = new Vector<>();
	private String idColonia;
	private String txtNombreCalleUno;
	private String txtNombreCalleDos;
	
	// Mapas Satelitales
//	private final JMMotorDeMapas motorDeMapas;
	private final JMMotorDeMapas1 motorDeMapas;
	private String mapaSatelitalX;
	private String mapaSatelitalY;
	private String zoom;
	private String mapaSatelitalX2;
	private String mapaSatelitalY2;
	
	// Propiedades booleanas
	private Boolean mostrarObjetosActualizables = Boolean.FALSE;
	private Boolean mostrarPuntosInteres = Boolean.FALSE;
	private Boolean mostrarGeocercas = Boolean.FALSE;
	private Boolean soporteGeocerca = Boolean.FALSE;
	private Boolean mostrarEtiqueta = Boolean.TRUE;
	private Boolean mostrarTraza = Boolean.TRUE;
	private Boolean mostrarPosicionAlterna = Boolean.FALSE;

	// Propiedades String
	private String formaBusqueda = "formaBusqueda";
	
	// Propiedades Status
	private String estatus = null;
	private Boolean bDisponibles = Boolean.FALSE;
	private Boolean bDesconectados = Boolean.FALSE;
	private Boolean bOcupados = Boolean.FALSE;
	private Boolean bTodos = Boolean.FALSE;
	
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		if (estatus.equals("0")){
			this.estatus = null;
			this.bTodos = Boolean.TRUE;
			this.bOcupados = Boolean.FALSE;
			this.bDisponibles = Boolean.FALSE;
			this.bDesconectados = Boolean.FALSE;
		}else if (estatus.equals("1")){
			this.estatus = estatus;
			this.bTodos = Boolean.FALSE;
			this.bOcupados = Boolean.FALSE;
			this.bDisponibles = Boolean.TRUE;
			this.bDesconectados = Boolean.FALSE;
		} else if (estatus.equals("2")){
			this.estatus = "Ocupado";
			this.bTodos = Boolean.FALSE;
			this.bOcupados = Boolean.TRUE;
			this.bDisponibles = Boolean.FALSE;
			this.bDesconectados = Boolean.FALSE;
		} else if (estatus.equals("3")){
			this.estatus = "Desconectado";
			this.bTodos = Boolean.FALSE;
			this.bOcupados = Boolean.FALSE;
			this.bDisponibles = Boolean.FALSE;
			this.bDesconectados = Boolean.TRUE;
		} 
		
	}
	
	
	public Boolean getbDisponibles() {
		return bDisponibles;
	}

	public void setbDisponibles(Boolean bDispobibles) {
		this.bDisponibles = bDispobibles;
	}

	public Boolean getbDesconectados() {
		return bDesconectados;
	}

	public void setbDesconectados(Boolean bDesconectados) {
		this.bDesconectados = bDesconectados;
	}

	public Boolean getbOcupados() {
		return bOcupados;
	}

	public void setbOcupados(Boolean bOcupados) {
		this.bOcupados = bOcupados;
	}

	public Boolean getbTodos() {
		return bTodos;
	}

	public void setbTodos(Boolean bTodos) {
		this.bTodos = bTodos;
	}

	public JMBeanExtensibleMapa() {
		super();
//		this.motorDeMapas = new JMMotorDeMapas();
		this.motorDeMapas = new JMMotorDeMapas1();
		Cartografia c = null;
		try {
			c = this.getCartografiaService().objetoCartografia(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					JMConstantesComunes.CARTOGRAFIA_METROPOLITANA);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "Constructor => ObjetoCartografia");
		}
		if (c != null) {
			this.alejarMapa(Objects.toString(c.getLatitud(), ""), Objects.toString(c.getLongitud(), ""));
		}

	}

	@Override
	public void actualizarListado() {

	}

	public String getImagenSatelital(final Vector<JMPuntoGeografico> listaPuntosEstaticos, final Vector<JMPuntoGeografico> listaPuntosTrazables) {
		return this.getImagenSatelital(null, listaPuntosEstaticos, listaPuntosTrazables);
	}
	
//	public String getImagenSatelitalUnico(final Vector<JMPuntoGeografico> listaPuntosEstaticos, final Vector<JMPuntoGeografico> listaPuntosTrazables, String latitud, String longitud) {
//		return this.getImagenSatelitalUnico(null, listaPuntosEstaticos, listaPuntosTrazables, latitud, longitud);
//	}

	@SuppressWarnings("static-access")
	public String getImagenSatelital(final Vector<JMPuntoGeografico> listaPuntosActualizacionManual,
			final Vector<JMPuntoGeografico> listaPuntosEstaticos, final Vector<JMPuntoGeografico> listaPuntosTrazables) {

		return this.getMotorDeMapas().mapaSatelitalObtenerMapa(
						BooleanUtils.isTrue(this.getMostrarObjetosActualizables()) ? this.obtenerListaPuntosActualizacionAutomatica(
								this.getIdEstado(), this.getIdBase(), Boolean.TRUE, Boolean.FALSE)
								: null,
						listaPuntosActualizacionManual,
						listaPuntosEstaticos,
						BooleanUtils.isTrue(this.getMostrarPuntosInteres()) ? this.obtenerListaPuntosInteres() : null,
						listaPuntosTrazables,
						this.obtenerListaIconosSatelitales(),
						BooleanUtils.isTrue(this.getMostrarGeocercas()) ? this.obtenerListaGeograficaDeGeocercas()
								: null,
								this.getMapaSatelitalY(), this.getMapaSatelitalX(),
								this.getZoom(),
						this.getFormaBusqueda(), BooleanUtils.isTrue(this.getSoporteGeocerca()),
						this.mostrarTraza.booleanValue(), this.mostrarEtiqueta.booleanValue());

	}
	
//	public String getImagenSatelitalUnico(final Vector<JMPuntoGeografico> listaPuntosActualizacionManual,
//			final Vector<JMPuntoGeografico> listaPuntosEstaticos, final Vector<JMPuntoGeografico> listaPuntosTrazables, String latitud ,String longitud) {
//		if (latitud != null) {
//			this.setMapaSatelitalX2(latitud);
//			this.setMapaSatelitalY2(longitud);
//		}
//		return this.getMotorDeMapas()
//				.mapaSatelitalObtenerMapa(
//						BooleanUtils.isTrue(this.getMostrarObjetosActualizables()) ? this.obtenerListaPuntosActualizacionAutomatica(
//								this.getIdEstado(), this.getIdBase(), Boolean.TRUE, Boolean.FALSE)
//								: null,
//						listaPuntosActualizacionManual,
//						listaPuntosEstaticos,
//						BooleanUtils.isTrue(this.getMostrarPuntosInteres()) ? this.obtenerListaPuntosInteres() : null,
//						listaPuntosTrazables,
//						this.obtenerListaIconosSatelitales(),
//						BooleanUtils.isTrue(this.getMostrarGeocercas()) ? this.obtenerListaGeograficaDeGeocercas()
//								: null, this.getMapaSatelitalY2(), this.getMapaSatelitalX2(), this.getZoom(),
//						this.getFormaBusqueda(), BooleanUtils.isTrue(this.getSoporteGeocerca()),
//						this.mostrarTraza.booleanValue(), this.mostrarEtiqueta.booleanValue());
//	}
		
	
	public void acercarMapa(final String latitud, final String longitud) {
		this.setMapaSatelitalX(latitud);
		this.setMapaSatelitalY(longitud);
		this.setMapaSatelitalX2(latitud);
		this.setMapaSatelitalY2(longitud);
		this.setZoom(JMConstantesComunes.GOOGLE_ZOOM_ACERCADO);
	}
	
	public void acercarMapa2(final String latitud, final String longitud) {
		this.setMapaSatelitalX2(latitud);
		this.setMapaSatelitalY2(longitud);
		this.setZoom(JMConstantesComunes.GOOGLE_ZOOM_ACERCADO);
	}

	
	public void alejarMapa(final String latitud, final String longitud) {
//		this.setMapaSatelitalX(latitud);
//		this.setMapaSatelitalY(longitud);
//		this.setMapaSatelitalX2(latitud);
//		this.setMapaSatelitalY2(longitud);
		this.setMapaSatelitalX(longitud);
		this.setMapaSatelitalY(latitud);
		this.setMapaSatelitalX2(longitud);
		this.setMapaSatelitalY2(latitud);
		this.setZoom(JMConstantesComunes.GOOGLE_ZOOM_ALEJADO);
	}

	public void doAccionMostrarAjustadores(final ActionEvent e) {
		this.setMostrarObjetosActualizables(Boolean.TRUE);
	}

	public void doAccionOcultarAjustadores(final ActionEvent e) {
		this.setMostrarObjetosActualizables(Boolean.FALSE);
	}

	public void doAccionMostrarPuntosInteres(final ActionEvent e) {
		this.setMostrarPuntosInteres(Boolean.TRUE);
	}

	public void doAccionOcultarPuntosInteres(final ActionEvent e) {
		this.setMostrarPuntosInteres(Boolean.FALSE);
	}

	public void doAccionMostrarGeocercas(final ActionEvent e) {
		this.setMostrarGeocercas(Boolean.TRUE);
	}

	public void doAccionOcultarGeocercas(final ActionEvent e) {
		this.setMostrarGeocercas(Boolean.FALSE);
	}

	public void doAccionOcultarTraza(final ActionEvent e) {
		this.setMostrarTraza(Boolean.FALSE);
	}

	public void doAccionMostrarTraza(final ActionEvent e) {
		this.setMostrarTraza(Boolean.TRUE);
	}

	public void doAccionOcultarEtiquetas(final ActionEvent e) {
		this.setMostrarEtiqueta(Boolean.FALSE);
	}

	public void doAccionMostrarEtiquetas(final ActionEvent e) {
		this.setMostrarEtiqueta(Boolean.TRUE);
	}

	public void doAccionOcultarPosicionAlterna(final ActionEvent e) {
		this.setMostrarPosicionAlterna(Boolean.FALSE);
	}

	public void doAccionMostrarPosicionAlterna(final ActionEvent e) {
		this.setMostrarPosicionAlterna(Boolean.TRUE);
	}

	public String getMarcadoresActualizacionManual() {
		final StringBuilder marcadores = new StringBuilder("{markers}");
		final List<JMPuntoGeografico> l = this.obtenerListaGeograficaDeCallesYCruces();
		if ((l != null) && (l.size() > 0)) {
			for (final JMPuntoGeografico pt : l) {
				marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLongitud()
						+ "\" lng=\"" + pt.getLatitud() + "\" html=\""
						+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
						+ "\" labelContent=\"" + pt.getEtiqueta() + "\" /}");
			}
		}
		marcadores.append("{/markers}");
		return Objects.toString(marcadores, "");
	}
	
	public String getMarcadoresActualizacionManualUnico() {
		final StringBuilder marcadores = new StringBuilder("{markers}");

		final List<JMPuntoGeografico> l = this.obtenerListaGeograficaDeCallesYCruces();
		if ((l != null) && (l.size() > 0)) {
			for (final JMPuntoGeografico pt : l) {
				marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLongitud()
						+ "\" lng=\"" + pt.getLatitud() + "\" html=\""
						+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
						+ "\" labelContent=\"" + pt.getEtiqueta() + "\" /}");

			}
		}
		marcadores.append("{/markers}");

		return Objects.toString(marcadores, "");
	}

	public String getMarcadoresActualizacionAutomatica() {
		final List<JMPuntoGeografico> lista = this.obtenerListaPuntosActualizacionAutomatica(this.getIdEstado(),this.getIdBase(),
				Boolean.TRUE, Boolean.FALSE);
		final StringBuilder marcadores = new StringBuilder("{markers}");
		for (final JMPuntoGeografico pt : lista) {
//			marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLongitud()
//					+ "\" lng=\"" + pt.getLatitud() + "\" html=\""
//					+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
//					+ "\" labelContent=\"" + JMUtileriaString.quitarNoXML(pt.getEtiqueta()) + "\" /}");
			marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLatitud()
			+ "\" lng=\"" + pt.getLongitud() + "\" html=\""
			+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
			+ "\" labelContent=\"" + JMUtileriaString.quitarNoXML(pt.getEtiqueta()) + "\" /}");
		}
		marcadores.append("{/markers}");
		String retorno = StringUtils.replace(marcadores.toString(), "\r", "");
		retorno = StringUtils.replace(retorno, "\n", "");

		return retorno;
	}
	
	public String getMarcadoresActualizacionAutomaticaUnico() {
				final List<JMPuntoGeografico> lista = this.obtenerListaPuntosActualizacionAutomatica(this.getIdEstado(),this.getIdBase(),
						Boolean.TRUE, Boolean.FALSE);
				final StringBuilder marcadores = new StringBuilder("{markers}");
				for (final JMPuntoGeografico pt : lista) {
//					marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLongitud()
//							+ "\" lng=\"" + pt.getLatitud() + "\" html=\""
//							+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
//							+ "\" labelContent=\"" + JMUtileriaString.quitarNoXML(pt.getEtiqueta()) + "\" /}");
					marcadores.append("{marker id=\"" + pt.getIdentificadorUnico() + "\"  lat=\"" + pt.getLatitud()
					+ "\" lng=\"" + pt.getLongitud() + "\" html=\""
					+ JMUtileriaString.quitarNoXML(pt.getDescripcionHTML()) + "\"  label=\"" + pt.getIconoNombre()
					+ "\" labelContent=\"" + JMUtileriaString.quitarNoXML(pt.getEtiqueta()) + "\" /}");
				}
				marcadores.append("{/markers}");
				String retorno = StringUtils.replace(marcadores.toString(), "\r", "");
				retorno = StringUtils.replace(retorno, "\n", "");
				return retorno;
			}
	
	public List<Terminal> getListaAutomaticaDeTerminal(final String latitud, final String longitud) {

		if ((StringUtils.isNotBlank(latitud) && StringUtils.isNotBlank(longitud))) {
			List<Terminal> lista = null;
			try {
				lista = this.getTerminalService().listaDeTerminalParaCoordenadas(longitud, latitud, false);
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"getListaAutomaticaDeTerminal => listaDeTerminalParaCoordenadas");
			}

			if ((lista != null) && (lista.size() > 0)) {
				final List<Terminal> retorno = new Vector<>();
				for (final Terminal t : lista) {
					try {
						t.setDistanciaCalculada(new Double (TiempoDeLlegada.distanciaCoordenadas(latitud, longitud, t.getLongitud(),
		                           t.getLatitud())/1000));

					} catch (final Exception ex) {
						this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
								"getListaAutomaticaDeTerminal", latitud, longitud);
					}
					retorno.add(t);
				}
				return retorno;
			}
		}
		return new Vector<>();
	}

	public Vector<JMPuntoGeografico> obtenerListaPuntosInteres() {
		return this.obtenerListaPuntosInteres(null);
	}

	public Vector<JMPuntoGeografico> obtenerListaPuntosInteres(final String estado) {
		final Vector<JMPuntoGeografico> listaRetorno = new Vector<>();

		List<PuntoInteres> lpi = null;
		try {
			lpi = this.getPuntoInteresService().listaDePuntoInteres(this.getEstadoService().objetoEstado(estado),
					this.getPuntoInteresTipoService().listaDePuntoInteresTipo("1,2,3,4,5,6,7", null));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"obtenerListaPuntosInteres => listaDePuntoInteres");
		}

		if (lpi != null) {
			listaRetorno.addAll(lpi.stream().map(PuntoInteres::toJMPuntoGeografico).collect(Collectors.toList()));
		}

		return listaRetorno;

	}

	public Vector<JMPuntoGeografico> obtenerListaPuntosActualizacionAutomatica(final String estado, final String base,
			final Boolean validezCoordenadas, final Boolean validezFecha) {
		final Vector<JMPuntoGeografico> listaRetorno = new Vector<>();

		final List<Terminal> lista = this.obtenerListaDeTerminalesConEstadoYValidez(estado, base, validezCoordenadas,
				validezFecha, this.estatus);
		if ((lista != null) && (lista.size() > 0)) {
			for (final Terminal terminal : lista) {
				listaRetorno.add(terminal.toJMPuntoGeografico());
				if (BooleanUtils.isTrue(getMostrarPosicionAlterna())
						&& StringUtils.isNotBlank(terminal.getLatitudAlterna())
						&& StringUtils.isNotBlank(terminal.getLongitudAlterna())) {
					listaRetorno.add(terminal.toJMPuntoGeograficoAlt());
				}
			}
			// lista de usuarios
			listaRetorno.addAll(this.obtenerListaDeUsuarioConEstadoYValidez(estado, validezCoordenadas).stream().map(Usuario::toJMPuntoGeografico).collect(Collectors.toList()));
		}
		return listaRetorno;
	}
	
	public List<Terminal> obtenerListaDeTerminalesConEstadoYValidez(final String estado, final String base, final Boolean posicionValida,
			final Boolean fechaValida, final String estatus) {
		List <Terminal> auxiliar = new ArrayList<Terminal>();
		List <Terminal> auxiliar2 = new ArrayList<Terminal>();
		try {
			if(base.isEmpty() || base.equals("0") || base == null){
				if(getPermisoTodosBases() && getPermisoTodosEstados()){
					
					if(StringUtils.isBlank(estatus)){
						return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado), null,
								posicionValida, fechaValida);
					}else {
						auxiliar =  this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado), null,
								posicionValida, fechaValida);
						
						for (Terminal terminal : auxiliar) {
							if( estatus.equals("1")){
								if ( terminal.getEstatusMapa().equals("Disponible") || terminal.getEstatusMapa().equals("VPosicion")){
									auxiliar2.add(terminal);
								}
							}else{								
								if ( terminal.getEstatusMapa().equals(estatus)){
									auxiliar2.add(terminal);
								}
							}
						}
						return auxiliar2;						
					}
					
					
				}else{
					List <Terminal> todasTerminales = this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado), null,
							posicionValida, fechaValida);
					List <Base> basesFrecuencia = this.getListaDeBasesPorFrecuencia();
					List <Terminal> terminalesFrec = new ArrayList<Terminal>();
					
					for ( final Base base1 : basesFrecuencia){
						for (final Terminal terminalFre : todasTerminales){
							if (StringUtils.isBlank(estatus)){
								if(terminalFre.getBase().getId().equals(base1.getId())){
									terminalesFrec.add(terminalFre);
								}
								
							} else {
								if(estatus.equals("1")){
									if(terminalFre.getBase().getId().equals(base1.getId()) && (terminalFre.getEstatusMapa().equals("VPosicion") || terminalFre.getEstatusMapa().equals("Disponible"))){
										terminalesFrec.add(terminalFre);
									}
								} else {
									
									if(terminalFre.getBase().getId().equals(base1.getId()) && terminalFre.getEstatusMapa().equals(estatus)){
										terminalesFrec.add(terminalFre);
									}									
								}
							}
						}
					}
					
					return terminalesFrec;
				}
			}else{
				
				if(StringUtils.isBlank(estatus)){
					return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado), this.getBaseService().objetoBase(base),
							posicionValida, fechaValida);
				}else {
					auxiliar =  this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(estado), this.getBaseService().objetoBase(base),
							posicionValida, fechaValida);
					
					for (Terminal terminal : auxiliar) {
						if( estatus.equals("1")){
							if ( terminal.getEstatusMapa().equals("Disponible") || terminal.getEstatusMapa().equals("VPosicion")){
								auxiliar2.add(terminal);
							}
						}else{								
							if ( terminal.getEstatusMapa().equals(estatus)){
								auxiliar2.add(terminal);
							}
						}
					}
					return auxiliar2;						
				}
			}
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"obtenerListaDeTerminalesConEstadoYValidez");
		}
		return new Vector<>();
	}

	public List<Usuario> obtenerListaDeUsuarioConEstadoYValidez(final String estado, final Boolean posicionValida) {
		try {
			return this.getUsuarioService().listaDeUsuario(this.getEstadoService().objetoEstado(estado), null, null,
					null, posicionValida, null,null);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "obtenerListaDeUsuarioConEstadoYValidez");
		}
		return new Vector<>();
	}
	
	public Vector<JMPuntoGeografico> obtenerListaIconosSatelitales() {
		final Vector<JMPuntoGeografico> listaRetorno = new Vector<>();
		final String ruta = this.obtenerRequest().getScheme() + "://" + this.obtenerRequest().getServerName() + ":"
				+ this.obtenerRequest().getServerPort() + this.obtenerRequest().getContextPath()
				+ "/diseno/imagenes/mapa/iconos/";

		List<PuntoInteresTipo> lpit = null;
		try {
			lpit = this.getPuntoInteresTipoService().listaDePuntoInteresTipo();
			if (lpit != null) {
				listaRetorno.addAll(lpit.stream().map(p -> p.toJMPuntoGeografico(ruta)).collect(Collectors.toList()));
			}
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "obtenerListaIconosSatelitales");

		}
		return listaRetorno;
	}

	public Vector<JMPoligonoGeografico> obtenerListaGeograficaDeGeocercas() {
		final Vector<JMPoligonoGeografico> toReturn = new Vector<>();

		List<Geocerca> lg = null;
		try {
			lg = this.getGeocercaService().listaDeGeocerca(this.getEstadoService().objetoEstado(this.getIdEstado()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "obtenerListaGeograficaDeGeocercas");
		}

		if (lg != null) {
			for (final Geocerca geocerca : lg) {
				toReturn.add(geocerca.toPoligonoGeografico());
			}
		}

		return toReturn;
	}

	public Vector<JMPuntoGeografico> obtenerListaGeograficaDeCallesYCruces() {
		final Vector<JMPuntoGeografico> listaRetorno = new Vector<>();

		if ((this.getListaDeCalles() != null) && (this.getListaDeCalles().size() > 0)) {
			listaRetorno.addAll(this.listaDeCalles.stream().map(Calle::toJMPuntoGeografico).collect(Collectors.toList()));
		}

		if ((this.getListaDeCruces() != null) && (this.getListaDeCruces().size() > 0)) {
			listaRetorno.addAll(this.listaDeCruces.stream().map(CalleCruce::toJMPuntoGeografico).collect(Collectors.toList()));
		}

		return listaRetorno;

	}

	public List<Colonia> getListaDeColonias() {
		if (StringUtils.isNotBlank(this.getIdMunicipio())) {
			try {
				return this.getColoniaService().listaDeColonia(
						this.getEstadoService().objetoEstado(this.getIdEstado()), this.getIdMunicipio());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeColonias");
			}

		}
		return new Vector<>();
	}


	public boolean getEsBusquedaCalle() {
		return StringUtils.isNotBlank(this.getTxtNombreCalleUno()) && StringUtils.isBlank(this.getTxtNombreCalleDos());
	}

	public boolean getEsBusquedaCruce() {
		return StringUtils.isNotBlank(this.getTxtNombreCalleUno())
				&& StringUtils.isNotBlank(this.getTxtNombreCalleDos());

	}

	public void doBuscarCalleOCruce(final ActionEvent e) {
		this.setListaDeCalles(new Vector<Calle>());
		this.setListaDeCruces(new Vector<CalleCruce>());
		if (this.getEsBusquedaCalle()) {
			try {
				this.setListaDeCalles(this.getCalleService().listaDeCalle(
						this.getEstadoService().objetoEstado(this.getIdEstado()), this.getIdMunicipio(),
						this.getIdColonia(), this.getTxtNombreCalleUno()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion()
						.manejarExcepcion(ex, this.getClass(), "doBuscarCalleOCruce => listaDeCalle");
			}
		}

		if (this.getEsBusquedaCruce()) {
			try {
				this.setListaDeCruces(this.getCalleCruceService().listaDeCalleCruce(
						this.getEstadoService().objetoEstado(this.getIdEstado()), this.getIdMunicipio(),
						this.getIdColonia(), this.getTxtNombreCalleUno(), this.getTxtNombreCalleDos()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doBuscarCalleOCruce => listaDeCalleCruce");
			}

		}

	}

	public void doCambiarEstadoSeleccionado(final ActionEvent e) {
		Cartografia c = null;
		try {
			c = this.getCartografiaService().objetoCartografia(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					JMConstantesComunes.CARTOGRAFIA_METROPOLITANA);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doCambiarEstadoSeleccionado");
		}
		if (c != null) {
			this.alejarMapa(Objects.toString(c.getLatitud(), ""), Objects.toString(c.getLongitud(), ""));

		}
	}

	public void doAccionPonerCalle(final ActionEvent e) {
		final String ord = this.obtenerParametroDeRequest("ordinal");

		final Calle c = this.getListaDeCalles().get(NumberUtils.toInt(ord));
		if (c != null) {
			this.setIdEstado(Objects.toString(c.getEstado().getId(), ""));
			this.setIdMunicipio(Objects.toString(c.getIdmunicipio(), ""));
			this.setIdColonia(Objects.toString(c.getIdcolonia(), ""));
			this.setTxtNombreCalleUno(c.getNombre());

			this.acercarMapa(Objects.toString(c.getLatitud(), ""), Objects.toString(c.getLongitud(), ""));
		}
	}

	public void doAccionPonerCruce(final ActionEvent e) {
		final String ord = this.obtenerParametroDeRequest("ordinal");

		final CalleCruce c = this.getListaDeCruces().get(NumberUtils.toInt(ord));
		if (c != null) {
			this.setIdEstado(Objects.toString(c.getEstado().getId(), ""));
			this.setIdMunicipio(Objects.toString(c.getIdmunicipioUno(), ""));
			this.setIdColonia(Objects.toString(c.getIdcoloniaUno(), ""));
			this.setTxtNombreCalleUno(c.getNombreCalleUno());
			this.setTxtNombreCalleDos(c.getNombreCalleDos());

			this.acercarMapa(Objects.toString(c.getLatitud(), ""), Objects.toString(c.getLongitud(), ""));
		}
	}

	public PuntoInteresTipo obtenerIconoParaTipoDePuntoDeInteres(final String tipo) {
		try {
			return this.getPuntoInteresTipoService().objetoPuntoInteresTipoParaNombre(tipo);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "obtenerIconoParaTipoDePuntoDeInteres");
			return null;
		}
	}

	public void limpiarBusquedaGeografica() {
		this.setTxtNombreCalleDos(null);
		this.setTxtNombreCalleUno(null);
		this.setListaDeCalles(new Vector<Calle>());
		this.setListaDeCruces(new Vector<CalleCruce>());
	}

	public List<Calle> getListaDeCalles() {
		return this.listaDeCalles;
	}

	
	public void setListaDeCalles(final List<Calle> listaDeCalles) {
		this.listaDeCalles = listaDeCalles;
	}

	public List<CalleCruce> getListaDeCruces() {
		return this.listaDeCruces;
	}

	
	public void setListaDeCruces(final List<CalleCruce> listaDeCruces) {
		this.listaDeCruces = listaDeCruces;
	}

	public String getTxtNombreCalleUno() {
		return this.txtNombreCalleUno;
	}

	public void setTxtNombreCalleUno(final String txtNombreCalleUno) {
		this.txtNombreCalleUno = txtNombreCalleUno;
	}

	public String getTxtNombreCalleDos() {
		return this.txtNombreCalleDos;
	}

	public void setTxtNombreCalleDos(final String txtNombreCalleDos) {
		this.txtNombreCalleDos = txtNombreCalleDos;
	}

	public String getMapaSatelitalX() {
		return this.mapaSatelitalX;
	}

	private void setMapaSatelitalX(final String mapaSatelitalX) {
		this.mapaSatelitalX = mapaSatelitalX;
	}

	public String getMapaSatelitalY() {
		return this.mapaSatelitalY;
	}

	private void setMapaSatelitalY(final String mapaSatelitalY) {
		this.mapaSatelitalY = mapaSatelitalY;
	}

//	/**
//	 * @return the motorDeMapas
//	 */
//	public JMMotorDeMapas getMotorDeMapas() {
//		return this.motorDeMapas;
//	}

	public String getZoom() {
		return this.zoom;
	}

	public void setZoom(final String zoom) {
		this.zoom = zoom;
	}

	/**
	 * @return the idColonia
	 */
	public String getIdColonia() {
		return this.idColonia;
	}

	/**
	 * @param idColonia
	 *            the idColonia to set
	 */
	public void setIdColonia(final String idColonia) {
		this.idColonia = idColonia;
	}

	/**
	 * @return the mostrarObjetosActualizables
	 */
	public Boolean getMostrarObjetosActualizables() {
		return this.mostrarObjetosActualizables;
	}

	/**
	 * @param mostrarObjetosActualizables
	 *            the mostrarObjetosActualizables to set
	 */
	public void setMostrarObjetosActualizables(final Boolean mostrarObjetosActualizables) {
		this.mostrarObjetosActualizables = mostrarObjetosActualizables;
	}

	/**
	 * @return the mostrarPuntosInteres
	 */
	public Boolean getMostrarPuntosInteres() {
		return this.mostrarPuntosInteres;
	}

	/**
	 * @param mostrarPuntosInteres
	 *            the mostrarPuntosInteres to set
	 */
	public void setMostrarPuntosInteres(final Boolean mostrarPuntosInteres) {
		this.mostrarPuntosInteres = mostrarPuntosInteres;
	}

	/**
	 * @return the mostrarGeocercas
	 */
	public Boolean getMostrarGeocercas() {
		return this.mostrarGeocercas;
	}

	/**
	 * @param mostrarGeocercas
	 *            the mostrarGeocercas to set
	 */
	public void setMostrarGeocercas(final Boolean mostrarGeocercas) {
		this.mostrarGeocercas = mostrarGeocercas;
	}


	public Boolean getSoporteGeocerca() {
		return this.soporteGeocerca;
	}

	public void setSoporteGeocerca(final Boolean soporteGeocerca) {
		this.soporteGeocerca = soporteGeocerca;
	}

	public String getFormaBusqueda() {
		return this.formaBusqueda;
	}

	public void setFormaBusqueda(final String formaBusqueda) {
		this.formaBusqueda = formaBusqueda;
	}

	public Boolean getMostrarEtiqueta() {
		return this.mostrarEtiqueta;
	}

	public void setMostrarEtiqueta(final Boolean mostrarEtiqueta) {
		this.mostrarEtiqueta = mostrarEtiqueta;
	}

	public Boolean getMostrarTraza() {
		return this.mostrarTraza;
	}

	public void setMostrarTraza(final Boolean mostrarTraza) {
		this.mostrarTraza = mostrarTraza;
	}

	public Boolean getMostrarPosicionAlterna() {
		return this.mostrarPosicionAlterna;
	}

	public void setMostrarPosicionAlterna(Boolean mostrarPosicionAlterna) {
		this.mostrarPosicionAlterna = mostrarPosicionAlterna;
	}
	
	
	// **************************************************************//
	// Permisos
	// **************************************************************//
	public boolean getPermisoTodosEstados() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todosLosEstados.siica");
	}

	public boolean getPermisoTodosBases() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todasLasBases.siica");
	}

	public JMMotorDeMapas1 getMotorDeMapas() {
		return motorDeMapas;
	}

	public String getMapaSatelitalX2() {
		return mapaSatelitalX2;
	}

	public void setMapaSatelitalX2(String mapaSatelitalX2) {
		this.mapaSatelitalX2 = mapaSatelitalX2;
	}

	public String getMapaSatelitalY2() {
		return mapaSatelitalY2;
	}

	public void setMapaSatelitalY2(String mapaSatelitalY2) {
		this.mapaSatelitalY2 = mapaSatelitalY2;
	}

}

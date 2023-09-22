package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuario;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.web.geocode.JMMapQuestGeocode;
import com.jmfg.jmlib.sistema.classes.web.xml.mapquest.Response;
import com.jmfg.jmlib.sistema.fabricas.mapas.JMMotorDeMapas;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@ManagedBean(name = "usuario")
@RequestScoped
@Entity(name = "Usuario")
@Access(AccessType.FIELD)
@Table(name = "usuario")
public class Usuario extends AbstractUsuario {
	private static final long serialVersionUID = -7735123625062135230L;

	@Transient
	private String _idEstado;

	@Transient
	private String _idFrecuencia;

	@Transient
	private String _idBase;

	@Transient
	private String _idPerfil;

	@Transient
	private String _idEstadoFrecuenciaAV;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	/** default constructor */
	public Usuario() {
		super();
		this.setHabilitado(Boolean.TRUE);
	}

	private static UsuarioServiceInterfase usuarioService;

	public static UsuarioServiceInterfase getUsuarioService() {
		if (Usuario.usuarioService == null) {
			Usuario.usuarioService = JMSIICAServerServiceSingleton.getInstance().getUsuarioService();
		}
		return Usuario.usuarioService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Estado,estado", "Base,base", "Nombre,nombre", "Usuario,username",
				"Perfil,perfil", "Frecuencia,frecuencia" }).getLista();
	}

	public JMPuntoGeografico toJMPuntoGeografico(){
		final JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setEsArrastable(false);

		punto.setIconoNombre(this.getIcono());
		punto.setIconoArchivo(this.getIcono());

		punto.setLatitud(this.getLatitud());
		punto.setLongitud(this.getLongitud());
		punto.setEtiqueta(this.getNombre());
		punto.setDescripcionHTML(this.getHTML());
		punto.setIdentificadorUnico(Objects.toString(this.getId(), ""));
		return punto;
	}

	public void procesarLatitudLongitudFecha(final String longitud, final String latitud, final Date fecha) {
		String direccion = "Sin Direccion";

		final double velocidadKMHR = 0;

		// buscar la direccion solo si la posicion es valida
		if (StringUtils.isNotBlank(latitud) && StringUtils.isNotBlank(longitud)) {
			final String latitud4 = StringUtils.substring(latitud, 0, 8);
			final String longitud4 = StringUtils.substring(longitud, 0, 6);

			CalleDireccion direccionDB = null;
			try {
				direccionDB = CalleDireccion.getCalleDireccionService().objetoCalleDireccionParaCoordenadas(latitud4,
						longitud4);
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("procesarLatitudLongitudFecha => objetoCalleDireccionParaCoordenadas", ex);
			}

			if (direccionDB != null) {
				direccion = direccionDB.getDireccion();
			} else {
				final Response res = JMMapQuestGeocode.geocodificarCoordenadas(latitud,longitud);
				if ((res != null) && (res.getInfo() != null)
						&& StringUtils.equalsIgnoreCase(res.getInfo().getStatusCode(), "0")
						&& (res.getResults() != null) && (res.getResults().length > 0) && (res.getResults()[0] != null)
						&& (res.getResults()[0].getLocations() != null)
						&& (res.getResults()[0].getLocations().length > 0)
						&& (res.getResults()[0].getLocations()[0] != null)

				) {

					direccionDB = new CalleDireccion();
					direccion = StringUtils.replace(

							res.getResults()[0].getLocations()[0].getStreet() + " "
									+ res.getResults()[0].getLocations()[0].getAdminArea5() + " "
									+ res.getResults()[0].getLocations()[0].getAdminArea4() + " "
									+ res.getResults()[0].getLocations()[0].getAdminArea3() + " "
									+ res.getResults()[0].getLocations()[0].getAdminArea2() + " "
									+ res.getResults()[0].getLocations()[0].getAdminArea1()

							, "[^\\x20-\\x7e]", "");

					direccionDB.setPrec(new Integer(8));
					direccionDB.setLatitud(latitud4);
					direccionDB.setLongitud(longitud4);
					direccionDB.setDireccion(direccion);
					direccionDB.guardarObjeto();

				}
			}

		}

		final UsuarioLog reg = new UsuarioLog();

		reg.setUsuario(this);
		reg.setFecha(fecha != null ? fecha : new Date());
		reg.setLatitud(latitud);
		reg.setLongitud(longitud);
		reg.setValida(Boolean.TRUE);
		reg.setDireccion(direccion);
		reg.setVelocidad(new Double(velocidadKMHR));
		if (this.getUltimaLocalizacion() != null) {
			reg.setSegundosTranscurridos(new Double((System.currentTimeMillis() - this.getUltimaLocalizacion()
					.getTime()) / 1000));
		} else {
			reg.setSegundosTranscurridos(new Double(0));
		}
		try {
			reg.setMetrosRecorridos(new Double(JMMotorDeMapas.obtenerDistanciaEntreDosCoordenadas(this.getLatitud(),
					this.getLongitud(), latitud, longitud)));
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("procesarLatitudLongitudFecha", ex);
		}

		reg.guardarObjeto();

		this.setUltimaLocalizacion(fecha != null ? fecha : new Date());
		this.setUltimaLocalizacionValida(Boolean.TRUE);
		this.setVelocidad(new Double(velocidadKMHR));
		this.setDireccion(direccion);
		this.setLatitud(latitud);
		this.setLongitud(longitud);

		try {
			Usuario.getUsuarioService().guardarObjeto(this);
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("procesarLatitudLongitudFecha => guardarObjeto", ex);
		}

	}

	public String getIcono() {
		return "usuario_siica";
	}

	public String getHTML() {
		final StringBuilder builder = new StringBuilder();

		builder.append("<b>Nombre:</b> " + JMUtileriaString.quitarNoXML(this.getNombre()));
		builder.append("<br /><b>Fecha:</b> "
				+ JMUtileriaString.quitarNoXML(Objects.toString(this.getUltimaLocalizacion(), "")));

		return Objects.toString(builder, "");
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getEstado() != null) {
			this.set_idEstado(Objects.toString(this.getEstado().getId(), ""));
		}
		if (this.getBase() != null) {
			this.set_idBase(Objects.toString(this.getBase().getId(), ""));

		}
		if (this.getFrecuencia() != null) {
			this.set_idFrecuencia(Objects.toString(this.getFrecuencia().getId(), ""));
		}
		if (this.getPerfil() != null) {
			this.set_idPerfil(Objects.toString(this.getPerfil().getId(), ""));
		}

		return null;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);

			}
		}
		if (StringUtils.isNotBlank(this.get_idBase())) {
			try {
				this.setBase(Base.getBaseService().objetoBase(this.get_idBase()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoBase", ex);
			}
		}
		if (StringUtils.isNotBlank(this.get_idFrecuencia())) {
			try {
				this.setFrecuencia(Frecuencia.getFrecuenciaService().objetoFrecuencia(this.get_idFrecuencia()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoFrecuencia", ex);
			}
		}
		if (StringUtils.isNotBlank(this.get_idPerfil())) {
			try {
				this.setPerfil(Perfil.getPerfilService().objetoPerfil(this.get_idPerfil()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto => objetoPerfil", ex);
			}
		}

		try {
			return Usuario.getUsuarioService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		this.setNombre(this.getNombre() + " Eliminada: " + new Date());
		this.setUsername(this.getNombre() + " Eliminada: " + new Date());

		try {
			return Usuario.getUsuarioService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	public String get_idEstado() {
		return this._idEstado;
	}

	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

	public String get_idFrecuencia() {
		return this._idFrecuencia;
	}

	public void set_idFrecuencia(final String _idFrecuencia) {
		this._idFrecuencia = _idFrecuencia;
	}

	public String get_idBase() {
		return this._idBase;
	}

	public void set_idBase(final String _idBase) {
		this._idBase = _idBase;
	}

	public String get_idPerfil() {
		return this._idPerfil;
	}

	public void set_idPerfil(final String _idPerfil) {
		this._idPerfil = _idPerfil;
	}

	public String get_idEstadoFrecuenciaAV() {
		return this._idEstadoFrecuenciaAV;
	}

	public void set_idEstadoFrecuenciaAV(final String _idEstadoFrecuenciaAV) {
		this._idEstadoFrecuenciaAV = _idEstadoFrecuenciaAV;
	}

}
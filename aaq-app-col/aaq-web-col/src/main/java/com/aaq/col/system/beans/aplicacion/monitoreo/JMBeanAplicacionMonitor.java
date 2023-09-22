package com.aaq.col.system.beans.aplicacion.monitoreo;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.pojo.EstadisticaMonitorDataModel;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.TerminalLogDataModel;


@ManagedBean(name = "beanAplicacionMonitor")
@SessionScoped
public class JMBeanAplicacionMonitor extends JMBeanExtensibleMapa<TerminalLog> {
	private static final long serialVersionUID = 3562143229039220740L;
	private String txtRadioProveedor;
	private Terminal objetoTerminal;
	private EstadisticaMonitorDataModel est;

	private boolean entreBase = false;
	private boolean entreEstado = true;
	private Integer tmpIdEntidad;
	private Integer tmpIdBase;
	
	public JMBeanAplicacionMonitor() {
		super();

		try {
			if(!getPermisoTodosEstados() && !getPermisoTodosBases()){
				setIdEstado(""+this.getEstadoFrecuencia().get(0).getId());
			}
			setIdBase("0");
			this.tmpIdBase = 0;
			this.tmpIdEntidad = Integer.parseInt(this.getIdEstado());
			this.setMostrarGeocercas(Boolean.TRUE);
			this.setMostrarObjetosActualizables(Boolean.TRUE);
			this.setMostrarPuntosInteres(Boolean.TRUE);
			this.setSoporteGeocerca(Boolean.TRUE);
			this.actualizarListado();
			if(getPermisoTodosEstados() && getPermisoTodosBases()){
				this.actualizaEstadisticas();
			}
			this.setEstatus("0");
			
		} catch (Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"constructor");
		}
	}

	public void actualizarListado() {
		try {
			if(getPermisoTodosEstados() && getPermisoTodosBases()){
				this.obtenerEst(Integer.parseInt(this.getIdEstado()),null);
				this.actualizaEstadisticas();
			}else{
				if(getIdBase().equals("0") || StringUtils.isBlank(getIdBase())){
					
					this.obtenerEstFrecuencia(Integer.parseInt(this.getIdEstado()), null);
				} else {
					this.obtenerEstFrecuencia(Integer.parseInt(this.getIdEstado()), Integer.parseInt(this.getIdBase()));
				}
			}
			
			this.setListado(new TerminalLogDataModel(this
					.getTerminalLogService().listaDeTerminalLog(
							this.getListaDeTerminalesParaMapa(),
							DateUtils.addDays(new Date(), -1), new Date(),
							true, false, new Integer(100))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"actualizarListado");
		}
	}

	public void actualizaEstadisticas() {
		
			try {
				if (this.tmpIdEntidad == null  ||  this.tmpIdEntidad == 0) {
					this.obtenerEst(Integer.parseInt(this.getIdEstado()), null);
				} else {
					
					
					if (this.tmpIdBase == null || this.tmpIdBase == 0) {
						this.obtenerEst(this.tmpIdEntidad, null);
					} else {
						this.obtenerEst(this.tmpIdEntidad, this.tmpIdBase);
					}
				}
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"actualizarListado");
			}
	}


	public List<Terminal> getListaDeTerminalesParaPanel(final String idBase) {
		if (idBase != null	&& (entreEstado || Integer.parseInt(this.getIdBase()) == 0)) {
			try {
				this.entreEstado = true;
				return this.getTerminalService().listaDeTerminal(
						this.getEstadoService()
								.objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(idBase),
						Boolean.FALSE, Boolean.FALSE);

			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex,
						this.getClass(), "getListaDeTerminalesParaPanel");
			}

		}
		return new Vector<>();
	}
	
	public List<Terminal> getListaDeTerminalesDisponibles(final String idBase) {
		if (idBase != null)  {
			try {
				
				return this.getTerminalService().listaDeTerminal(
						this.getEstadoService()
								.objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(idBase),
						Boolean.FALSE, Boolean.FALSE);

			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex,
						this.getClass(), "getListaDeTerminalesParaPanel");
			}

		}
		return new Vector<>();
	}

	public List<Terminal> getListaDeTerminalesParaPanelB() {
		if (this.getIdBase() != null && this.entreBase) {
			this.entreBase = true;
			try {
				return this.getTerminalService().listaDeTerminal( this.getEstadoService().objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(this.getIdBase()),Boolean.FALSE, Boolean.FALSE);
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex,
						this.getClass(), "getListaDeTerminalesParaPanel");

			}
		}
		return new Vector<>();

	}

	
	public void onSelectEdo(ValueChangeEvent vc) {
		this.tmpIdEntidad = Integer.parseInt(String.valueOf(vc.getNewValue()));
		tmpIdBase = 0;
		this.entreEstado = true;
		this.entreBase = false;
		this.obtenerEst(this.tmpIdEntidad,null);
		this.setIdBase("0");
	}

	public void onSelectBase(ValueChangeEvent vc) {
		this.tmpIdBase = Integer.parseInt(String.valueOf(vc.getNewValue()));
		if(tmpIdBase == 0) this.tmpIdBase = null; 
		this.entreBase = true;
		this.entreEstado = false;
		this.obtenerEst(this.tmpIdEntidad, this.tmpIdBase);
	}

	public void obtenerEst(Integer idEntidad, Integer idBase) {
		EstadisticaMonitorDataModel est1 = null;
		try {
			if (this.entreBase) {
				est1 = this.getTerminalService().obtenerEstadisticas(idEntidad, idBase);
				
			} else{
				est1 = this.getTerminalService().obtenerEstadisticas(idEntidad, null);
			}
			this.setEst(est1);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"obtenerEstadisticas");
		}
	}

	public List<Usuario> getListaDeUsuariosParaPanel() {
		try {
			return this.getUsuarioService().listaDeUsuario(
					this.getEstadoService().objetoEstado(this.getIdEstado()),
					null, null, null, Boolean.TRUE, null, null);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"getListaDeUsuariosParaPanel");

		}
		return new Vector<>();
	}

	public void obtenerEstFrecuencia(Integer idEntidad, Integer idBase) {
		EstadisticaMonitorDataModel est1 = null;
		try {

			if (this.entreBase && idBase != null) {
				est1 = this.getTerminalService().obtenerEstadisticas(idEntidad,
						idBase);
			} else {
				String cadenaTerminales = "";
				for(Base base : this.getObtenerBasesFrecuencia()){
					cadenaTerminales=cadenaTerminales+""+base.getId()+"|";
				}
				est1 = this.getTerminalService().obtenerEstadisticasFrecuencia(idEntidad, cadenaTerminales);
			}
			this.setEst(est1);
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"obtenerEstadisticas");
		}
	}
	
	public void onSelectBaseListener() {
		if (this.getIdBase() != null)
			this.tmpIdBase = Integer.parseInt(this.getIdBase());
		if (this.getIdBase() != null && Integer.parseInt(this.getIdBase()) == 0) {
			this.tmpIdBase = null;
		}
		if (this.getIdBase() == null)
			this.tmpIdBase = null;

		this.entreBase = true;
		this.entreEstado = false;
		if(this.tmpIdBase ==  null){
			this.obtenerEstFrecuencia(Integer.parseInt(this.getIdEstado()), this.tmpIdBase);
		}else{
			this.obtenerEst(Integer.parseInt(this.getIdEstado()), this.tmpIdBase);
		}
	}
	
	public void onSelectEdoListener() {
		this.tmpIdEntidad = Integer.parseInt(this.getIdEstado());
		this.entreEstado = true;
		this.entreBase = false;
		setIdBase("0");
		this.obtenerEstFrecuencia(this.tmpIdEntidad, this.tmpIdBase);
		setIdEstado(String.valueOf(this.tmpIdEntidad));
	}
	
	public List<Terminal> getListaDeTerminalesParaPanelFrecuencia(String idBase) {
		if(this.tmpIdBase==null){
			 idBase = "0";
		}
		if (idBase != null && (entreEstado || Integer.parseInt(this.getIdBase()) == 0)) {
			try {
				this.entreEstado = true;
				return this.getTerminalService().listaDeTerminal(
						this.getEstadoService()
								.objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(idBase),
						Boolean.FALSE, Boolean.FALSE);

			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex,
						this.getClass(), "getListaDeTerminalesParaPanel");
			}

		}
		return new Vector<>();
	}
	public String getImagenSatelital() {
		return super.getImagenSatelital(null, null);
	}

	public void doAccionBuscarAjustador(final ActionEvent e) {
		
		if (StringUtils.isNotBlank(this.getTxtRadioProveedor())) {
			Terminal terminal = null;
			try {
				terminal = this.getTerminalService().objetoTerminalParaNumeroRadio(
								this.getEstadoService().objetoEstado(
										this.getIdEstado()),
								this.getTxtRadioProveedor());
				
				
			} catch (final Exception ex) {
				this.getUtileriaExcepcion()
						.manejarExcepcion(ex, this.getClass(),
								"doAccionBuscarAjustador => objetoTerminalParaNumeroRadio");
			}
			
			if (terminal == null) {
				try {
					terminal = this.getTerminalService()
							.objetoTerminalParaNumeroProveedor(
									this.getEstadoService().objetoEstado(
											this.getIdEstado()),
									this.getTxtRadioProveedor());
				} catch (final Exception ex) {
					this.getUtileriaExcepcion()
							.manejarExcepcion(ex, this.getClass(),
									"doAccionBuscarAjustador => objetoTerminalParaNumeroProveedor");
				}
			}

			if (terminal != null) {
				this.setObjetoTerminal(terminal);
			} else {
				this.ponerMensajeError("El ajustador no fue encontrado en la base de datos con numero de radio o proveedor: "
						+ this.getTxtRadioProveedor());
			}
			
		}
	}

	public void doAccionRegistroVisualizarMapa(final ActionEvent e) {
		if ((this.getListado() != null)
				&& (this.getListado().getDataSource() != null)) {
			this.setObjetoABM(this
					.getListado()
					.getDataSource()
					.get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		}
	}

	private int obtenerNumeroDeTerminalesParaBaseConEstatus(
			final String idbase, final String status) {

		if (StringUtils.equals(status, "99")) {
			return this.getListaDeTerminalesParaPanel(idbase).size();
		}

		int contador = 0;
		for (final Terminal terminal : this
				.getListaDeTerminalesParaPanel(idbase)) {
			if (terminal.getBase().getId().intValue() == NumberUtils
					.toInt(idbase)) {
				if (StringUtils.equals(terminal.getEstatusMapa(), status)) {
					contador++;
				}
			}
		}

		return contador;

	}

	public String getEstaBaseOnline(final String idbase) {
		return Integer.toString(this
				.obtenerNumeroDeTerminalesParaBaseConEstatus(idbase,
						"Disponible"));
	}

	public String getEstaBaseOffline(final String idbase) {
		final int total = this.obtenerNumeroDeTerminalesParaBaseConEstatus(
				idbase, "Desconectado");

		return Integer.toString(total);
	}

	public String getEstaBaseBusy(final String idbase) {
		final int total = this.obtenerNumeroDeTerminalesParaBaseConEstatus(
				idbase, "Ocupado");

		return Integer.toString(total);
	}

	public String getEstaBaseTotal(final String idbase) {
		return Integer.toString(this
				.obtenerNumeroDeTerminalesParaBaseConEstatus(idbase, "99"));
	}

	@Override
	public String getIdEstado() {
		if (this.obtenerParametroDeRequest("estado") != null) {
			String estado = null;
			try {
				estado = this.getConfiguracionService().obtenerCadena(
						JMConstantes.CONFIGURACION_MAPAS_EQUIVALENCIAS_ESTADO
								+ this.obtenerParametroDeRequest("estado"));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex,
						this.getClass(), "getIdEstado");
			}
			if (StringUtils.isNotBlank(estado)) {
				return estado;
			}
		}

		return super.getIdEstado();

	}

	public boolean getPermisoTodosEstados() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todosLosEstados.siica");
	}

	public boolean getPermisoTodosBases() {
		return this
				.getTienePermisoParaPagina("/SIICAGlobal/todasLasBases.siica");
	}

	public String getTxtRadioProveedor() {
		return this.txtRadioProveedor;
	}

	public void setTxtRadioProveedor(final String txtRadioProveedor) {
		this.txtRadioProveedor = txtRadioProveedor;
	}

	public Terminal getObjetoTerminal() {
		return this.objetoTerminal;
	}

	public void setObjetoTerminal(final Terminal objetoTerminal) {
		this.objetoTerminal = objetoTerminal;
	}

	public boolean getEntreBase() {
		return this.entreBase;
	}

	public boolean getEntreEstado() {
		return this.entreEstado;
	}

	public Integer getTmpIdEntidad() {
		return tmpIdEntidad;
	}

	public void setTmpIdEntidad(Integer tmpIdEntidad) {
		this.tmpIdEntidad = tmpIdEntidad;
	}

	public Integer getTmpIdBase() {
		return tmpIdBase;
	}

	public void setTmpIdBase(Integer tmpIdBase) {
		this.tmpIdBase = tmpIdBase;
	}

	public EstadisticaMonitorDataModel getEst() {
		return est;
	}

	public void setEst(EstadisticaMonitorDataModel est) {
		this.est = est;
	}

	
}

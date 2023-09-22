package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractSessionExterna;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "sessionExterna")
@RequestScoped
@Entity(name = "SessionExterna")
@Access(AccessType.FIELD)
@Table(name = "session_externa")
public class SessionExterna extends AbstractSessionExterna {
	private static final long serialVersionUID = 2465534279471774173L;

	@Transient
	private Boolean estaConectado;

	@Transient
	private String estatus;

	@Transient
	private String proveedorTelefonia;

	@Transient
	private String horarioEntrada;
    @Transient
    private String horarioSalida;

	@Transient
	private Date fechaPrimerInicioSession;

    @Transient
    private Date fechaUltimoInicioSession;

    @Transient
    private String ajustadoresEnFalta;
    
    @Transient
    private String reportesEsteDia;
    
    @Transient
    private String razonEstatus;
    
    
    
    /** default constructor */
	public SessionExterna() {
		super();
		this.setFecha(new Date());
	}

	private static SessionExternaServiceInterfase sessionExternaService;

	public static SessionExternaServiceInterfase getSessionExternaService() {
		if (SessionExterna.sessionExternaService == null) {
			SessionExterna.sessionExternaService = JMSIICAServerServiceSingleton.getInstance()
					.getSessionExternaService();
		}
		return SessionExterna.sessionExternaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Ajustador,terminal",
				"Operacion,operacion", "Conectado,estaConectado" }).getLista();
	}

	public Boolean getEstaConectado() {
		return this.estaConectado;
	}

	public void setEstaConectado(final Boolean estaConectado) {
		this.estaConectado = estaConectado;
	}

	@Override
	public String getEstatus() {
		return this.estatus;
	}

	@Override
	public void setEstatus(final String estatus) {
		this.estatus = estatus;
	}

	public String getProveedorTelefonia() {
		return this.proveedorTelefonia;
	}

	public void setProveedorTelefonia(final String proveedorTelefonia) {
		this.proveedorTelefonia = proveedorTelefonia;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return SessionExterna.getSessionExternaService().eliminarObjeto(this);
		} catch (IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch ( DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return SessionExterna.getSessionExternaService().guardarObjeto(this);
		} catch (IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch ( DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}

    public String getHorarioEntrada () {
        return horarioEntrada;
    }

    public void setHorarioEntrada (final String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSalida () {
        return horarioSalida;
    }

    public void setHorarioSalida (final String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public Date getFechaPrimerInicioSession () {
        return fechaPrimerInicioSession;
    }

    public void setFechaPrimerInicioSession (final Date fechaPrimerInicioSession) {
        this.fechaPrimerInicioSession = fechaPrimerInicioSession;
    }

    public Date getFechaUltimoInicioSession () {
        return fechaUltimoInicioSession;
    }

    public void setFechaUltimoInicioSession (final Date fechaUltimoInicioSession) {
        this.fechaUltimoInicioSession = fechaUltimoInicioSession;
    }

	public String getAjustadoresEnFalta() {
		return ajustadoresEnFalta;
	}

	public void setAjustadoresEnFalta(String ajustadoresEnFalta) {
		this.ajustadoresEnFalta = ajustadoresEnFalta;
	}

	public String getReportesEsteDia() {
		return reportesEsteDia;
	}

	public void setReportesEsteDia(String reportesEsteDia) {
		this.reportesEsteDia = reportesEsteDia;
	}

	public String getRazonEstatus() {
		return razonEstatus;
	}

	public void setRazonEstatus(String razonEstatus) {
		this.razonEstatus = razonEstatus;
	}
	
    
    
}

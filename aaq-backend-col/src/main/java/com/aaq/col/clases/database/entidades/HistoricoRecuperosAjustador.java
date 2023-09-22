package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractHistoricoRecuperosAjustador;
import com.aaq.col.clases.database.servicios.interfase.HistoricoRecuperosAjustadorServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "historicoRecuperosAjustador")
@RequestScoped
@Entity(name = "HistoricoRecuperosAjustador")
@Access(AccessType.FIELD)
@Table(name = "historico_recuperos_ajus")
public class HistoricoRecuperosAjustador extends AbstractHistoricoRecuperosAjustador {

	private static final long serialVersionUID = 4824585755783160990L;

	/** default constructor */
	public HistoricoRecuperosAjustador() {
		super();
	}

	/**
	 * @param usuario
	 * @param terminal
	 * @param fecha
	 * @param reporte
	 * @param fuente
	 * @param operacion
	 * @param detalles
	 */
	public HistoricoRecuperosAjustador(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado,
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto) {
		super(claveRecupero, descripcionRecupero, totalVales, claveAseguradora, 
				descripcionAseguradora, claveAjustador, reporte, afectado,
				numeroSiniestro, folioVale, monto, descripcionMonto);
	}

	private static HistoricoRecuperosAjustadorServiceInterfase historicoRecuperosAjustadorService;

	public static HistoricoRecuperosAjustadorServiceInterfase getHistoricoRecuperosAjustadorService() {
		if (HistoricoRecuperosAjustador.historicoRecuperosAjustadorService == null) {
			HistoricoRecuperosAjustador.historicoRecuperosAjustadorService = JMSIICAServerServiceSingleton.getInstance().getHistoricoRecuperosAjustadorService();
		}
		return HistoricoRecuperosAjustador.historicoRecuperosAjustadorService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Perito-abogado,terminal",
				"Reporte,reporte", "Operacion,operacion", "Fuente,fuente", "Usuario,usuario", "Detalles,detalles" })
				.getLista();
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return HistoricoRecuperosAjustador.getHistoricoRecuperosAjustadorService().eliminarObjeto(this);
		} catch (RollbackException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch ( Exception e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return HistoricoRecuperosAjustador.getHistoricoRecuperosAjustadorService().guardarObjeto(this);
		} catch ( IndexOutOfBoundsException | RollbackException e) {
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

}

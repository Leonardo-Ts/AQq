package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporteDocumento;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteDocumentoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "terminalReporteDocumento")
@RequestScoped
@Entity(name = "TerminalReporteDocumento")
@Access(AccessType.FIELD)
@Table(name = "terminal_reporte_documento")
public class TerminalReporteDocumento extends AbstractTerminalReporteDocumento {
	private static final long serialVersionUID = -2456097843296427769L;

	/** default constructor */
	public TerminalReporteDocumento() {
		super();
		this.setValor(Boolean.FALSE);

	}

	private static TerminalReporteDocumentoServiceInterfase terminalReporteDocumentoService;

	public static TerminalReporteDocumentoServiceInterfase getTerminalReporteDocumentoService() {
		if (TerminalReporteDocumento.terminalReporteDocumentoService == null) {
			TerminalReporteDocumento.terminalReporteDocumentoService = JMSIICAServerServiceSingleton.getInstance()
					.getTerminalReporteDocumentoService();
		}
		return TerminalReporteDocumento.terminalReporteDocumentoService;
	}

	public String getValorDeDocumento() {
		return BooleanUtils.isTrue(this.getValor()) ? "SI" : "NO";
	}

	@Override
	public String toString() {
		if ((this.getValor() != null) && (this.getTerminalReporteDocumentoTipo() != null)) {
			return this.getTerminalReporteDocumentoTipo().getClave() + ": " + this.getValorDeDocumento();
		}
		return super.toString();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return TerminalReporteDocumento.getTerminalReporteDocumentoService().eliminarObjeto(this);
		} catch ( RollbackException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalReporteDocumento.getTerminalReporteDocumentoService().guardarObjeto(this);
		} catch ( IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}
}

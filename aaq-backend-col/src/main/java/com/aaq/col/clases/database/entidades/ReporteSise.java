package com.aaq.col.clases.database.entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteSise;
import com.aaq.col.clases.database.servicios.interfase.ReporteSiseServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import org.apache.commons.lang3.time.DateUtils;
import org.eclipse.persistence.exceptions.DatabaseException;


@ManagedBean(name = "reporteSise")
@RequestScoped
@Entity(name = "ReporteSise")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "reporte_sise")
public class ReporteSise extends AbstractReporteSise {

	private static final long serialVersionUID = 5470859271382634373L;

	public ReporteSise() {
		super();

	}

	private static ReporteSiseServiceInterfase reporteSiseService;

	public static ReporteSiseServiceInterfase getReporteSiseService() {
		if (ReporteSise.reporteSiseService == null) {
			ReporteSise.reporteSiseService = JMSIICAServerServiceSingleton.getInstance().getReporteSiseService();
		}
		return ReporteSise.reporteSiseService;
	}

	@JMReporteOmitirMetodo
	public JMPuntoGeografico toJMPuntoGeografico() {
		final JMPuntoGeografico p = new JMPuntoGeografico();
		p.setDescripcionHTML(this.getHTML());
		p.setEsArrastable(false);
		p.setIconoArchivo("traza_punto.png");
		p.setIconoNombre("traza_punto");
		p.setLatitud(this.getCoordLatitudArribo());
		p.setLongitud(this.getCoordLongitudArribo());
		p.setIdentificadorUnico(this.getId().toString());
		p.setEtiqueta(this.getGeneralNumeroReporte());
		return p;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Reporte,generalNumeroReporte",
				"Siniestro,generalNumeroSiniestro", "Poliza,generalNumeroPoliza", "Cabinista,generalUsuario",
				"Vehiculo,vehiculoMarca", "Placas,vehiculoPlacas", "Serie,vehiculoSerie" }).getLista();
	}

	@JMReporteOmitirMetodo
	public String getDatosUbicacion() {
		return this.getUbicacionDireccion() + " " + this.getUbicacionColoniaDesc() + " " + this.getUbicacionMunicipio()
				+ " " + this.getUbicacionEntidad() + " " + this.getEstado();
	}

	@JMReporteOmitirMetodo
	public String getDatosVehiculo() {
		return this.getVehiculoMarca() + " " + this.getVehiculoTipo() + " " + this.getVehiculoModelo() + " "
				+ this.getVehiculoColor();
	}

    @JMReporteOmitirMetodo
    public Date getFechaCreacion(){
        if (StringUtils.isNotBlank(getUbicacionDireccion())){
            try{
                try {
					return DateUtils.parseDate(StringUtils.left(getUbicacionDireccion(),16),"dd/MM/yyyy HH:mm");
				} catch (ParseException e) {
				}
            } catch (ClassCastException | NoResultException | IllegalArgumentException | DatabaseException | RollbackException ex){
                // nada
            } catch (PersistenceException  ex){
                // nada
            }
        }

        return null;
    }

	@JMReporteOmitirMetodo
	public String getHTML() {
		final StringBuilder b = new StringBuilder("<b>Reporte: </b> " + this.getGeneralNumeroReporte());
		b.append("<br/><b>Fecha: </b> " + DateFormatUtils.format(this.getFecha(), "yyyy/MM/dd HH:mm:ss"));
		b.append("<br/><b>Poliza: </b> " + this.getGeneralNumeroPoliza());

		return b.toString();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return ReporteSise.getReporteSiseService().eliminarObjeto(this);
		} catch (final ClassCastException | NoResultException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ReporteSise.getReporteSiseService().guardarObjeto(this);
		} catch (final ClassCastException | NoResultException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			return new JMResultadoOperacion(ex);
		}  catch (final PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public String toString() {
		return super.getGeneralNumeroReporte();
	}

}

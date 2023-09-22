package com.aaq.col.system.beans.catalogos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.CatClaseVehDataModel;

@ManagedBean(name = "beanCatClaseVeh")
@ViewScoped
public class BeanCatClaseVeh extends JMBeanExtensiblePrincipal<CatalogoClaseVeh> {

	private static final long serialVersionUID = 8770485090842673734L;
	private final Log4JLogger logCargaMasiva = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.carga");

	private UploadedFile file;
	private String txtClave;
	private String txtDescripcion;
	private String txtNombre;
	
	
	public BeanCatClaseVeh() {
		super();
		this.actualizarListado();
	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new CatClaseVehDataModel(this.getCatalogoClaseVehService().listaDeCatalogoClaseVeh(this.getTxtClave(), this.getTxtDescripcion())) );
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new CatalogoClaseVeh());
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {

		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("ERROR: El objeto actual es NULO. Fecha: " + this.getFechaHoraActual());
			return;
		}
		super.doAccionRegistroGuardar(e);
	}
	

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		try {
			Map<String, Object>  salida = null;
	        this.setFile(event.getFile());
	        String name = file.getFileName();

	        InputStream inputStream = file.getInputstream();
	        OutputStream outputStream = null;
	        try {
	        FacesContext context = FacesContext.getCurrentInstance();
	        ServletContext servletContext = (ServletContext) context
	                .getExternalContext().getContext();
	        String path = servletContext.getRealPath("");
	        File file = new File(path+"/"+ name);
	       
	        outputStream = new FileOutputStream(file);
	      
	      int read = 0;
	        byte[] bytes = new byte[1024];
			     try  {
			        while ((read = inputStream.read(bytes)) != -1) {
			            outputStream.write(bytes, 0, read);
			        }
				} catch (ArrayIndexOutOfBoundsException e) {
					this.logCargaMasiva.info("Ocurrio un error: "+e);
					this.ponerMensajeError("Ocurrio un error a subir al leer el archivo: "+e);
				}
	        
	        salida = this.getCargaDatosService().cargarDatosClaseVeh(file);
	        String  error = (String) salida.get("error");
		     if (error != null) {
				this.ponerMensajeError("Verificar contenido del archivo. " +error);
			} else {
		       this.actualizarListado();
		    	   this.ponerMensajeInfo("Se añadieron nuevos datos.");
			}
	        }catch (ClassCastException | Error e) {
				this.logCargaMasiva.info("Ocurrio un error -> "+e);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.info("Ocurrio un error -> "+e);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
			}  catch (IOException ex) {
				this.logCargaMasiva.info("Ocurrio un error -> "+ex);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+ex);
			} finally {
				outputStream.close();
			} 
		     try {
		    	 outputStream.close();
		     }catch (Exception e) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> Cerrar archivo " + e.getMessage()), (Throwable)e);
			}
		}catch (Exception e) {
            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> " + e.getMessage()), (Throwable)e);
            this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);

		}
	        
	    }
		

	
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogacion/catalogosABM.siica");

	}
	
	@Override
	public CatalogoClaseVeh getObjetoABM() {
		return super.getObjetoABM();
	}

	public String getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(String txtClave) {
		this.txtClave = txtClave;
	}

	public String getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre = txtNombre;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}

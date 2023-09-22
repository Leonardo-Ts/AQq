package com.aaq.col.clases.database.entidades;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTransaccion;
import com.aaq.col.clases.database.servicios.interfase.TransaccionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.xml.link2b.JMLinkMotoContenedor;
import com.aaq.col.clases.xml.link2b.JMLinkResultadoTransaccion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaNumerosLetras;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaRC4;

@ManagedBean(name = "transaccion")
@RequestScoped
@Entity(name = "Transaccion")
@Access(AccessType.FIELD)
@Table(name = "transaccion")
public class Transaccion extends AbstractTransaccion {
	private static final long serialVersionUID = -2259249305678348147L;

	public Transaccion() {
		super();
		this.setFecha(new Date());
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Fecha,fecha,fecha,,claseCSSFila",
				"Ajustador,terminal,,,claseCSSFila", "Reporte,numeroReporte,,,claseCSSFila",
				"Estado,estatusDeTransaccion,,,claseCSSColumnaEstatus", "Tipo,tipoDeCobro,,,claseCSSFila",
				"Fuente,fuente,,,claseCSSFila", "Monto,monto,,,claseCSSFila",
				"Operación,numeroOperacion,,,claseCSSFila", "Autorización,numeroAutorizacion,,,claseCSSFila",
				"Oficina,claveOficina,,,claseCSSFila", "Cobertura Af.,coberturaAfectada,,,claseCSSFila" }).getLista();
	}

	private static TransaccionServiceInterfase transaccionService;

	public static TransaccionServiceInterfase getTransaccionService() {
		if (Transaccion.transaccionService == null) {
			Transaccion.transaccionService = JMSIICAServerServiceSingleton.getInstance().getTransaccionService();
		}
		return Transaccion.transaccionService;
	}

	public String getEstatusDeTransaccion() {

		if (BooleanUtils.isTrue(this.getTransaccionAprobada())) {
			if (this.getXmlRespuesta() != null) {
				if (this.getXmlRespuesta().contains("N/A")) {
					if (this.getTransaccionAprobada()) {
						return "Enviado";
					}
					return "Error";
				}
			}
			return "Aprobada";
		}
		if (StringUtils.containsIgnoreCase(this.getXmlRespuesta(), "<response>error</response>") || this.getDatosAdicionales().contains("error") ) {
			return "Error";
		}
		if (StringUtils.containsIgnoreCase(this.getXmlRespuesta(), "<response>denied</response>")) {
			return "Declinada";
		}
		try {
			if (BooleanUtils.isFalse(this.getTransaccionAprobada())) {
				if (this.getXmlRespuesta() != null) {
					if (this.getXmlRespuesta().contains("N/A")) {
						return "Error";
					}
				}
			}
		} catch (ClassCastException | IllegalArgumentException | IllegalStateException e) {
		}
		
		return "Declinada!";
	}

	@JMReporteOmitirMetodo
	public String getClaseCSSColumnaEstatus() {
		return BooleanUtils.isTrue(this.getTransaccionAprobada()) ? this.getClaseCSSFila() : "transaccion_declinada";
	}

	@JMReporteOmitirMetodo
	public String getClaseCSSFila() {
		if (StringUtils.containsIgnoreCase(this.getTipoDeCobro(), "r")) {
			return "transaccion_pago_recuperacion";
		}
		return "transaccion_pago_poliza";
	}

	@JMReporteOmitirMetodo
	private JMLinkMotoContenedor obtenerLinkMotoContenedor() {
		try {
			if (StringUtils.isNotBlank(this.getXmlTarjeta())) {
				return new JMXMLObjectFactory().obtenerJMLinkMotoContenedorParaString(this.getXmlTarjeta().replaceAll(
						"cvv-csc", "cvv_csc"));
			}
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("obtenerLinkMotoContenedor", ex);
		}
		return null;
	}

	@JMReporteOmitirMetodo
	private JMLinkResultadoTransaccion obtenerLinkResultadoTransaccion() {
		try {
			if (StringUtils.isNotBlank(this.getXmlRespuesta())) {
				return new JMXMLObjectFactory().obtenerJMLink2bResultadoTransaccionParaString(this.getXmlRespuesta());
			}
		} catch (final Exception ex) {
			JMEntidad.getLogger().error("obtenerLinkResultadoTransaccion", ex);
		}
		return null;
	}

	@JMReporteOmitirMetodo
	public String getTarjetaTipo() {
		final JMLinkResultadoTransaccion r = this.obtenerLinkResultadoTransaccion();

		if (r != null) {
			return r.getCc_type();
		}

		return null;
	}

	@JMReporteOmitirMetodo
	public String getTarjetaNombre() {
		final JMLinkMotoContenedor r = this.obtenerLinkMotoContenedor();
		if ((r != null) && (r.getTransacction() != null) && (r.getTransacction().getCreditcard() != null)) {
			if (this.mostrarCadenaCifrada()) {
				try {
					return new JMUtileriaRC4(this.getChecksum()).desencriptar(r.getTransacction().getCreditcard()
							.getName());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("getTarjetaNombre", ex);
					return r.getTransacction().getCreditcard().getName();
				}
			}
			return r.getTransacction().getCreditcard().getName();
		}
		return null;
	}
	

	
	@JMReporteOmitirMetodo
	public String getTarjetaNumero() {
	  if (this.getXmlRespuesta() != null) {
		if (this.getXmlRespuesta().contains("N/A")) {
			return "N/A";
		}
	 }
		if(this.getXmlTarjeta().length() <= 35 && this.getChecksum() != null) {
			String numTarjetaE = new JMUtileriaRC4(this.getChecksum()).desencriptar(this.getXmlTarjeta());
			if(numTarjetaE.contains("************")) {
				return numTarjetaE.toString(); 
				}
		} else {
		final JMLinkMotoContenedor r = this.obtenerLinkMotoContenedor();
		if ((r != null) && (r.getTransacction() != null) && (r.getTransacction().getCreditcard() != null)) {
			if (this.mostrarCadenaCifrada()) {
				try {
					
					String numTarjeta = new JMUtileriaRC4(this.getChecksum()).desencriptar(r.getTransacction().getCreditcard()
							.getNumber());
					
					if ( numTarjeta.contains("***") ) {
						return numTarjeta;
					} else {
						
						return "************ " + numTarjeta.subSequence(numTarjeta.length() - 4, numTarjeta.length());
					}
					
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("getTarjetaNumeor", ex);
					return r.getTransacction().getCreditcard().getNumber();
				}
			}
			return r.getTransacction().getCreditcard().getNumber();
		}
		}
		return null;
	}

	@JMReporteOmitirMetodo
	public String getTarjetaExpMes() {
		final JMLinkMotoContenedor r = this.obtenerLinkMotoContenedor();
		if ((r != null) && (r.getTransacction() != null) && (r.getTransacction().getCreditcard() != null)) {
			if (this.mostrarCadenaCifrada()) {
				try {
					return new JMUtileriaRC4(this.getChecksum()).desencriptar(r.getTransacction().getCreditcard()
							.getExpmonth());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("getTarjetaExpMes", ex);
					return r.getTransacction().getCreditcard().getExpmonth();
				}
			}
			return r.getTransacction().getCreditcard().getExpmonth();
		}
		return null;
	}
	
	@JMReporteOmitirMetodo
	public String getTarjetaExpYear() {
		final JMLinkMotoContenedor r = this.obtenerLinkMotoContenedor();
		if ((r != null) && (r.getTransacction() != null) && (r.getTransacction().getCreditcard() != null)) {
			if (this.mostrarCadenaCifrada()) {
				try {
					return new JMUtileriaRC4(this.getChecksum()).desencriptar(r.getTransacction().getCreditcard()
							.getExpyear());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("getTarjetaExpYear", ex);
					return r.getTransacction().getCreditcard().getExpyear();
				}
			}
			return r.getTransacction().getCreditcard().getExpyear();
		}
		return null;
	}

	@JMReporteOmitirMetodo
	public String getTarjetaCvv2() {
		final JMLinkMotoContenedor r = this.obtenerLinkMotoContenedor();
		if ((r != null) && (r.getTransacction() != null) && (r.getTransacction().getCreditcard() != null)) {
			if (this.mostrarCadenaCifrada()) {
				try {
					String cvv = new JMUtileriaRC4(this.getChecksum()).desencriptar(r.getTransacction().getCreditcard()
							.getCvv_csc());
					
					if (cvv.contains("**")) {
						return cvv;
					}else {
						return "***";
					}
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("getTarjetaCvv2", ex);
					return r.getTransacction().getCreditcard().getCvv_csc();
				}
			}
			return r.getTransacction().getCreditcard().getCvv_csc();
		}
		return null;
	}

	@JMReporteOmitirMetodo
	public String getUltimos4Tarjeta() {
		return "*****************" + StringUtils.right(this.getTarjetaNumero(), 4);
	}

	public String getImporteConLetra() {
		if (StringUtils.isNotBlank(this.getMonto())) {
			try {
				return JMUtileriaNumerosLetras.toLetras(NumberUtils.toDouble(this.getMonto()));
			} catch (final NumberFormatException e) {
				JMEntidad.getLogger().error("getImporteConLetra ==> " + "Monto : " + this.getMonto(), e);
			}
		}
		return "";
	}

	@JMReporteOmitirMetodo
	public byte[] getVoucher()  {
		if (this.getXmlTarjeta() != null) {
			if (this.getXmlTarjeta().contains("N/A")) {
				return null;
			}
		}
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
		  String ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
          Image img = Image.getInstance(ruta+"25_qualitas.png");
          
          img.setBorder(0);
          img.setAlignment(Element.ALIGN_CENTER);
          float percentage = 0.0f;
          percentage = 150 / img.getWidth();
          img.scalePercent(percentage * 100);
           
         
          
		final Font fuenteNormal = FontFactory.getFont(FontFactory.HELVETICA, 10);
		final Font fuenteBold = FontFactory.getFont(FontFactory.HELVETICA, 10);
		fuenteBold.setStyle(FontStyle.BOLD.getValue());

		final Document document = new Document();
		PdfWriter.getInstance(document, out);
		document.open();

		 // Insertamos la imagen en el documento
		document.add(img);
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		
		final PdfPTable tablavoucher = new PdfPTable(1);

		tablavoucher.setSpacingAfter(20f);
		tablavoucher.getDefaultCell().setBorderColor(BaseColor.BLACK);
		tablavoucher.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		
		if (StringUtils.isNotBlank(this.getVoucherGeneral())) {
			
			final String[] lineas = StringUtils.splitPreserveAllTokens(this.getVoucherGeneral(), "@");

			int i = 0;

			for (final String string : lineas) {
				tablavoucher.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				
				if (i == (lineas.length - 1)) {
					tablavoucher.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);

				}

				if (StringUtils.contains(string, "cnb")) {
					tablavoucher.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
					tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
					tablavoucher.addCell(new Phrase(StringUtils.replace(string, "cnb", ""), fuenteBold));
				}
				if (StringUtils.contains(string, "cnn")) {
					tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
					tablavoucher.addCell(new Phrase(StringUtils.replace(string, "cnn", ""), fuenteNormal));
				}
				if (StringUtils.contains(string, "lnn")) {
					tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
					tablavoucher.addCell(new Phrase(StringUtils.replace(string, "lnn", ""), fuenteNormal));
				}
				if (StringUtils.contains(string, "br")) {
					tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
					tablavoucher.addCell(new Phrase("", fuenteNormal));
					tablavoucher.addCell(new Phrase("", fuenteNormal));
				}
				i++;
			}

		} else {
			if (StringUtils.isNotBlank(this.getXmlRespuesta())) {
		
					try {
						final JMLinkResultadoTransaccion resultado = new JMXMLObjectFactory()
								.obtenerJMLink2bResultadoTransaccionParaString(this.getXmlRespuesta());

						if (resultado != null) {
							tablavoucher.addCell(new Phrase("Respuesta: " + resultado.getResponse(), fuenteNormal));
							tablavoucher.addCell(new Phrase("Numero Autorizacion: " + resultado.getAuth(), fuenteNormal));
							tablavoucher.addCell(new Phrase("Numero Folio: " + resultado.getFoliocpagos(), fuenteNormal));
							tablavoucher.addCell(new Phrase("Codigo Error: " + resultado.getCd_error(), fuenteNormal));
							tablavoucher.addCell(new Phrase("Descripcion Error: " + resultado.getNb_error(), fuenteNormal));
							tablavoucher
									.addCell(new Phrase("Codigo Respuesta: " + resultado.getCd_response(), fuenteNormal));
							tablavoucher.addCell(new Phrase("Descripcion Respuesta: " + resultado.getFriendly_response(),
									fuenteNormal));

						}
					} catch (final ClassCastException | IndexOutOfBoundsException ex) {
						JMEntidad.getLogger().error("getVoucher", ex);
					} catch (final  Exception ex) {
						JMEntidad.getLogger().error("getVoucher", ex);
					}
			}
		}

		document.add(tablavoucher);

		final Phrase fraserespuesta = new Phrase("Respuesta del Banco: "
				+ Objects.toString(this.getCatalogoCodigoRespuestaBancario(), " CODIGO NO IDENTIFICADO "), fuenteNormal);
		Phrase fraseMesesIntereses = null;
		if(StringUtils.isNotBlank(this.getMesesSinIntereses())){
			fraseMesesIntereses = new Phrase("Pago a meses sin intereses ( "
					+ Objects.toString(this.getMesesSinIntereses()) + " ) ", fuenteNormal);
		}
		final PdfPTable tablarespuesta = new PdfPTable(1);
		tablarespuesta.addCell(fraserespuesta);
		tablarespuesta.addCell(fraseMesesIntereses);

		document.add(tablarespuesta);

		document.close();
		} catch ( ClassCastException | IndexOutOfBoundsException e) {
		} catch (DocumentException e) {
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}

		return out.toByteArray();
		
	}

	@JMReporteOmitirMetodo
	private boolean mostrarCadenaCifrada() {
		return StringUtils.isNotBlank(this.getChecksum())
				&& !StringUtils.containsIgnoreCase(this.getXmlTarjeta(), "<crypto>0</crypto>");

	}

	// **************************************************************//
	// Overriders
	// **************************************************************//

	/**
	 * auto generated
	 * 
	 * @es_generated
	 */
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
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
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Transaccion.getTransaccionService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	@JMReporteOmitirMetodo
	public String getXmlTarjeta() {
		return super.getXmlTarjeta();
	}

	@Override
	@JMReporteOmitirMetodo
	public String getXmlRespuesta() {
		return super.getXmlRespuesta();
	}

	@Override
	@JMReporteOmitirMetodo
	public String getChecksum() {
		return super.getChecksum();
	}

}

package com.aaq.col.clases.util.avisos;

import java.util.HashMap;
import java.util.Map;

public class CuerpoMail {
	
	 public String body(String referencia, String nombreBanco, String monto, String numReporte, boolean todosBancos) {
		 if (!todosBancos) {
			 Map<String, String> conveniosClaves = this.convenioClaves(nombreBanco);
			 String cuerpoCorreo = "<div><center>\r\n" + 
						"<p style=\"margin: 0cm;\"> <img src='cid:logoAAQ' align=\"left\"> &nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
						"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 22px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
						"<div style=\"color: #008c99; font-size: 18px; font-weight: 900;\">&nbsp;</div>\r\n\n\n\n\n" + 
						"</center>\r\n\n\n" + 
						"<div>\r\n\n\n\n\n" + 
						"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
						"<tbody>\r\n\n\n" + 
						"<tr>\r\n\n" + 
						"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">Número de Referencia: "+referencia+
						" \r\n" + 
						"\r\n" + 
						"<!-- o ignored --></p>\r\n" +  
						"</td>\r\n" + 
						"</tr>\r\n" + 
						"</tbody>\r\n" + 
						"</table>\r\n" + 
						"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Número de Reporte:&nbsp; </span> "+numReporte +"</p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Monto:&nbsp;&nbsp; </span> "+monto+" </p>\r\n" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:12pt;\"><span style=\"color: #008C99;\">&nbsp;&nbsp;BANCO&nbsp;&nbsp; </span></p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del Banco:&nbsp;&nbsp; </span> "+nombreBanco+" </p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Convenio:&nbsp;&nbsp; </span> "+conveniosClaves.get("convenio")+" </p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Cuenta:&nbsp;&nbsp; </span> "+conveniosClaves.get("cuenta")+" </p>\r\n" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<center>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:14pt;\"><span style=\"color: #ad1683;\">Utiliza esta referencia solo para el pago de tu Deducible de RC o Recupero.</span></p>\r\n" +
						"<ul>\r\n" + 
						"<li ><span style=\"color: #000000; font-size:14pt;\"><strong>NO SE ACEPTAN PAGOS CON CHEQUES.</strong></span></li>\r\n" + 
						"</ul>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">Favor de no responder sobre el mismo correo.</div>\r\n" + 
						"</center>\r\n" + 
						"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
						"</div>\r\n" + 
						"</div>";
			 return cuerpoCorreo;
		}
			String cuerpoCorreo = "<div><center>\r\n" + 
					"<p style=\"margin: 0cm;\"> <img src='cid:logoAAQ' align=\"left\"> &nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
					"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 22px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
					"<div style=\"color: #008c99; font-size: 18px; font-weight: 900;\">&nbsp;</div>\r\n\n\n\n\n\n" + 
					"</center>\r\n\n\n\n" + 
					"<div>\r\n\n\n\n\n\n" + 
					"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
					"<tbody>\r\n\n\n" + 
					"<tr>\r\n\n" + 
					"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">Número de Referencia: "+referencia+
					" \r\n" + 
					"\r\n" + 
					"<!-- o ignored --></p>\r\n" +  
					"</td>\r\n" + 
					"</tr>\r\n" + 
					"</tbody>\r\n" + 
					"</table>\r\n" + 
					"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Número de Reporte:&nbsp; </span> "+numReporte +"</p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Monto:&nbsp;&nbsp; </span> "+monto+" </p>\r\n" +
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:12pt;\"><span style=\"color: #008C99;\">&nbsp;&nbsp;BANCOS&nbsp;&nbsp; </span></p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del Banco:&nbsp;&nbsp; </span> "+"BBVA Bancomer"+" </p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Convenio CIE:&nbsp;&nbsp; </span> "+"1267620"+" </p>\r\n" +
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del Banco:&nbsp;&nbsp; </span> "+"Santander"+" </p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Convenio:&nbsp;&nbsp; </span> "+"5241"+" </p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Cuenta:&nbsp;&nbsp; </span> "+"65504441542"+" </p>\r\n" +
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del Banco:&nbsp;&nbsp; </span> "+"HSBC"+" </p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Convenio:&nbsp;&nbsp; </span> "+"8808"+" </p>\r\n" +
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Cuenta:&nbsp;&nbsp; </span> "+"4056388515"+" </p>\r\n" +
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<center>\r\n" + 
					"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:14pt;\"><span style=\"color: #ad1683;\">Utiliza esta referencia solo para el pago de tu Deducible de RC o Recupero.</span></p>\r\n" +
					"<ul>\r\n" + 
					"<li ><span style=\"color: #000000; font-size:14pt;\"><strong>NO SE ACEPTAN PAGOS CON CHEQUES.</strong></span></li>\r\n" + 
					"</ul>\r\n" + 
					"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
					"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">Favor de no responder sobre el mismo correo.</div>\r\n" + 
					"</center>\r\n" + 
					"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
					"</div>\r\n" + 
					"</div>";
			return cuerpoCorreo;
		}
	 
	 private Map<String, String> convenioClaves(String nombreBanco) {
		 Map<String, String> datos =  new HashMap<>();
		 if (nombreBanco.contains("BBVA")) {
			datos.put("convenio", "1267620");
			datos.put("cuenta", "");
			return datos;
		}
		 if (nombreBanco.contains("Santander")) {
				datos.put("convenio", "5241");
				datos.put("cuenta", "65504441542");
				return datos;
			}
		 if (nombreBanco.contains("HSBC")) {
				datos.put("convenio", "8808");
				datos.put("cuenta", "4056388515");
				return datos;
			}
		 return datos;
	 }
	 

}

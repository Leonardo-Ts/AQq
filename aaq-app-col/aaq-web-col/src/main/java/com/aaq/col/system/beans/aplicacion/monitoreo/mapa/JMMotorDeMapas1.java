package com.aaq.col.system.beans.aplicacion.monitoreo.mapa;

import java.io.*;
import org.apache.commons.logging.impl.*;
import org.apache.commons.logging.*;
import org.apache.commons.lang3.math.*;
import com.jmfg.jmlib.sistema.classes.jmlibreria.*;
import org.apache.commons.lang3.text.*;
import org.apache.commons.lang3.*;
import com.jmfg.jmlib.sistema.utilerias.*;
import java.util.*;

public class JMMotorDeMapas1 implements Serializable
{
	
	private static final long serialVersionUID = -5539100027516199858L;
	
	@SuppressWarnings("unused")
	private final Log4JLogger logger;
    
    public JMMotorDeMapas1() {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.fabricas");
    }
    
    public static String mapaSatelitalObtenerMapa(final Vector<JMPuntoGeografico> listaPuntosActualizacionAutomatica, final Vector<JMPuntoGeografico> listaPuntosActualizacionManual, final Vector<JMPuntoGeografico> listaPuntosEstaticos, final Vector<JMPuntoGeografico> listaPuntosInteres, final Vector<JMPuntoGeografico> listaPuntosTraza, final Vector<JMPuntoGeografico> listaIconos, final Vector<JMPoligonoGeografico> listaDeGeocercas, final String centrox, final String centroy, final String zoom, final String formaBusqueda, final boolean soporteGeocerca, final boolean mostrarEsthela, final boolean mostrarEtiqueta) {
        final StrBuilder motor = new StrBuilder();
        motor.append(' ');
        motor.append("\n var mapa = null;");
        motor.append("\n var geocodificador  = null;");
        motor.append("\n var infowindow  = null;");
        motor.append("\n var listaPoligonos = [];");
        motor.append("\n var listaIconos = new Hashtable();");
        motor.append("\n var listaPuntosActualizacionAutomatica = new Hashtable();");
        motor.append("\n var listaPuntosActualizacionManual = new Hashtable();");
        motor.append("\n var listaPuntosEstaticos = new Hashtable();");
        motor.append("\n var listaPuntosInteres = new Hashtable();");
        motor.append("\n var encontrado = false;");
        motor.append("\n function centrarMapa(ltlng) {");
        motor.append("\n mapa.setCenter(new google.maps.LatLng(ltlng));}");
        motor.append("\n function localizarPunto(ident) {");
        motor.append("\n if (typeof listaPuntosActualizacionAutomatica.get(ident) !== 'undefined') ");
        motor.append("{ google.maps.event.trigger(listaPuntosActualizacionAutomatica.get(ident), 'dblclick');  encontrado =  true; }");
        motor.append("\n if (typeof listaPuntosActualizacionManual.get(ident) !== 'undefined') ");
        motor.append("{ google.maps.event.trigger(listaPuntosActualizacionManual.get(ident), 'dblclick');  encontrado =  true; }");
        motor.append("\n if (typeof listaPuntosEstaticos.get(ident) !== 'undefined')");
        motor.append("{ google.maps.event.trigger(listaPuntosEstaticos.get(ident), 'dblclick');  encontrado =  true; }");
        motor.append("\n if(!encontrado){ alert(\"El parametro solicitado no se encuentra en el mapa\"); }");
        motor.append("\n }");
        motor.append("\n function actualizarIdentificador(valor) { ");
        motor.append("\n $(\"#").append(formaBusqueda).append("\\\\:satelitalId\").val(valor) ; realizarActualizacion(); }");
        motor.append("\n function cargarListaPuntosActualizacionAutomatica() { ");
        motor.append("\n  var obj = $(\"#formaMapa\\\\:marcadoresActualizacionAutomatica\").html(); ");
        motor.append("\n  obj = obj?.replace(new RegExp('{', 'g'),'<'); obj = obj.replace(new RegExp('}', 'g'),'>');  ");
        motor.append("\n  var data = $.parseXML(obj); ");
        motor.append("\n  jQuery(data).find('marker').each(function() { ");
        motor.append("\n  var marker = jQuery(this);");
        motor.append("\n  var point = new google.maps.LatLng(parseFloat(marker.attr(\"lat\")),parseFloat(marker.attr(\"lng\")));");
        motor.append("\n  var html = marker.attr(\"html\");");
        motor.append("\n  var icono = marker.attr(\"label\");");
        motor.append("\n  var contenido = marker.attr(\"labelContent\");");
        motor.append("\n  var ident = marker.attr(\"id\"); ");
        motor.append("\n  if (typeof listaPuntosActualizacionAutomatica.get(ident) !== 'undefined') {");
        motor.append("\n     listaPuntosActualizacionAutomatica.get(ident).tooltip = html; ");
        motor.append("\n     listaPuntosActualizacionAutomatica.get(ident).setIcon(listaIconos.get(icono)); ");
        motor.append("\n     if (!listaPuntosActualizacionAutomatica.get(ident).getPosition().equals(point)  ||  listaPuntosActualizacionAutomatica.get(ident).tooltip !== html ) { ");
        if (mostrarEsthela) {
            motor.append("\n        var estela = [ listaPuntosActualizacionAutomatica.get(ident).getPosition(), point]; ");
            motor.append("\n        var esthel = new google.maps.Polyline({path: estela, map:mapa,strokeColor:'#000000'});");
        }
        motor.append("\n          listaPuntosActualizacionAutomatica.get(ident).setPosition(point);  ");
        motor.append("\n      }");
        motor.append("\n  }");
        motor.append("\n  else {  var marc = obtenerMarcador(point,html,icono,false,ident,contenido);  if (marc !== null) {  listaPuntosActualizacionAutomatica.put(ident, marc); } }");
        motor.append("\n  });");
        motor.append("\n  }");
        motor.append("\n function reCargarListaPuntosActualizacionAutomatica() { ");
        motor.append("\n   $.each(listaPuntosActualizacionAutomatica.keys(), function(key, value) { listaPuntosActualizacionAutomatica.get(value).setMap(null);});");
        motor.append("\n  var obj = $(\"#formaMapa\\\\:marcadoresActualizacionAutomatica\").html(); ");
        motor.append("\n  obj = obj?.replace(new RegExp('{', 'g'),'<'); obj = obj.replace(new RegExp('}', 'g'),'>');  ");
        motor.append("\n  var data = $.parseXML(obj); var i=0; ");
        motor.append("\n  jQuery(data).find('marker').each(function() { ");
        motor.append("\n    var marker = jQuery(this);");
        motor.append("\n    var point = new google.maps.LatLng(parseFloat(marker.attr(\"lat\")),parseFloat(marker.attr(\"lng\")));");
        motor.append("\n    var html = marker.attr(\"html\");");
        motor.append("\n    var icono = marker.attr(\"label\");");
        motor.append("\n    var ident = marker.attr(\"id\"); ");
        motor.append("\n    var contenido = marker.attr(\"labelContent\");");
        motor.append("\n    var marc = obtenerMarcador(point,html,icono,false,ident,contenido);  if (i==0){mapa.setCenter(point);} i++;  if (marc !== null) {  listaPuntosActualizacionAutomatica.put(ident, marc); }");
        motor.append("\n  });");
        motor.append("\n  }");
        motor.append("\n function cargarListaPuntosActualizacionManual() { ");
        motor.append("\n   $.each(listaPuntosActualizacionManual.keys(), function(key, value) { listaPuntosActualizacionManual.get(value).setMap(null);});");
        motor.append("\n  listaPuntosActualizacionManual = new Hashtable();");
        motor.append("\n  var obj = $(\"#formaMapa\\\\:marcadoresActualizacionManual\").html(); ");
        motor.append("\n  obj = obj.replace(new RegExp('{', 'g'),'<'); obj = obj.replace(new RegExp('}', 'g'),'>');  ");
        motor.append("\n  var data = $.parseXML(obj); ");
        motor.append("\n  jQuery(data).find('marker').each(function() { ");
        motor.append("\n   var marker = jQuery(this);");
        motor.append("\n   var point = new google.maps.LatLng(parseFloat(marker.attr(\"lat\")),parseFloat(marker.attr(\"lng\")));");
        motor.append("\n   var html = marker.attr(\"html\");");
        motor.append("\n   var icono = marker.attr(\"label\");");
        motor.append("\n   var contenido = marker.attr(\"labelContent\");");
        motor.append("\n   var ident = marker.attr(\"id\"); ");
        motor.append("\n   var marc = obtenerMarcador(point,html,icono,false,ident,contenido);");
        motor.append("\n   if (marc !== null){ listaPuntosActualizacionManual.put(ident, marc); }");
        motor.append("\n   \t\t  });");
        motor.append("\n  }");
        motor.append("\n function insertarNuevasCoordenadas(punto) { ");
        motor.append("\n   var coordx= document.getElementById(\"").append(formaBusqueda).append(":satelitalOX\");");
        motor.append("\n   var coordy= document.getElementById(\"").append(formaBusqueda).append(":satelitalOY\");");
        motor.append("\n   if (typeof coordx !== 'undefined' && coordx)  {coordx.value = punto.lng();}");
        motor.append("\n   if (typeof coordy !== 'undefined' && coordy)  {coordy.value = punto.lat();}");
        motor.append("\n }");
        motor.append("\n function moverObjetoArrastrable(punto){");
        motor.append("\n var puntoNuevo = new google.maps.LatLng(punto.lat() + 0.001, punto.lng() + 0.001);");
        motor.append("\n insertarNuevasCoordenadas(puntoNuevo);");
        motor.append("\n if (typeof listaPuntosEstaticos.get(\"objetoArrastrable\") !== 'undefined') {");
        motor.append("\n     listaPuntosEstaticos.get(\"objetoArrastrable\").setPosition(puntoNuevo);");
        motor.append("\n   }");
        motor.append("\n }");
        motor.append("\n function obtenerMarcador(punto, htmlinterno, icono, arrastrable, identificador, contenido) {");
        motor.append("\n  var opciones ={ ");
        if (mostrarEtiqueta) {
            motor.append("\n \tlabelContent: contenido, ");
            motor.append("\n \tlabelAnchor: new google.maps.Point(12, 0), ");
            motor.append("\n \tlabelClass: \"etiquetasMapa\", ");
        }  else {
        	motor.append("\n \tlabelContent: \" \", ");
            motor.append("\n \tlabelStyle: {opacity: 0.100}, ");
        }
        motor.append("\n \ticon: listaIconos.get(icono), ");
        motor.append("\n \tposition: punto, ");
        motor.append("\n \tmap: mapa, ");
        motor.append("\n \tdraggable: arrastrable");
        motor.append("\n };");
        motor.append("\n var marcador = new  MarkerWithLabel(opciones); ");
        
        motor.append("\n  marcador.tooltip = htmlinterno;");
        motor.append("\n google.maps.event.addListener(marcador, \"click\", function(e) {");
        motor.append("\n geocodificar(marcador.getPosition()); ");
        motor.append("\n if (esNumerico(identificador) && typeof realizarActualizacion === 'function') ");
        motor.append("\n { actualizarIdentificador(identificador); } ");
        motor.append("\n infowindow.setContent(marcador.tooltip); ");
        motor.append("\n infowindow.setPosition(punto); ");
        motor.append("\n infowindow.setZIndex(2); ");
        motor.append("\n infowindow.open(mapa, marcador); ");
        motor.append("\n });");
        motor.append("\n google.maps.event.addListener(marcador, \"dblclick\", function(e) { ");
        motor.append("\n geocodificar(marcador.getPosition());");
        motor.append("\n mapa.setCenter(marcador.getPosition());");
        motor.append("\n mapa.setZoom(16);");
        motor.append("\n moverObjetoArrastrable(marcador.getPosition()); ");
        motor.append("\n infowindow.setContent(marcador.tooltip); ");
        motor.append("\n infowindow.setPosition(punto); ");
        motor.append("\n infowindow.setZIndex(2); ");
        motor.append("\n infowindow.open(mapa, marcador); ");
        motor.append("\n });");
        motor.append("\n if (arrastrable) { google.maps.event.addListener(marcador, \"dragend\", function(e) {");
        motor.append("\n  insertarNuevasCoordenadas(marcador.getPosition());  ");
        motor.append("\n  geocodificar(marcador.getPosition());");
        motor.append("\n if (typeof actualizarCoordenadas ==='function') {actualizarCoordenadas(marcador.getPosition().lng(),marcador.getPosition().lat()); }");
        motor.append("\n });");
        motor.append("\n }");
        motor.append("\n return marcador;");
        motor.append("\n }");
        //PROBAR SIN JS
        motor.append("\n function geocodificar(pos) { ");
        motor.append("\n  geocodificador.geocode({ latLng: pos }, function(responses) { ");
        motor.append("\n  if (responses && responses.length > 0) { ");
        motor.append("\n    if (typeof $(\"#formaMapa\\\\:liga_direccion\") !== 'undefined') {");
        motor.append("\n        $(\"#formaMapa\\\\:liga_direccion\").html(responses[0].formatted_address) ;");
        motor.append("\n     }");
        motor.append("\n    }");
        motor.append("\n });");
        motor.append("\n }");
        motor.append("\n function inicializarMapa() {");
        motor.append("\n \t\t  var mapOptions = {");
        motor.append("\n \t\t\t    mapTypeId: google.maps.MapTypeId.ROADMAP");
        motor.append("\n \t\t\t  }");
        motor.append("\n mapa = new google.maps.Map(document.getElementById(\"imagenSatelital\"),mapOptions);");
        motor.append("\n mapa.setCenter(new google.maps.LatLng(").append(NumberUtils.toDouble(centrox)).append(',').append(NumberUtils.toDouble(centroy)).append("));");
        motor.append("\n mapa.setZoom(").append(zoom).append(");");
        motor.append("\n mapa.setMapTypeId(google.maps.MapTypeId.ROADMAP); ");
        motor.append("\n infowindow = new google.maps.InfoWindow();");
        motor.append("\n geocodificador = new google.maps.Geocoder();");
        for (final JMPuntoGeografico icono : listaIconos) {
            String tamano = icono.getLatitud() + ',' + icono.getLongitud();
            if (StringUtils.isBlank((CharSequence)icono.getLatitud()) || StringUtils.isBlank((CharSequence)icono.getLongitud())) {
                tamano = "32,32";
            }
            motor.append("\n var ").append(icono.getIconoNombre()).append("= new google.maps.MarkerImage(\"").append(icono.getIconoArchivo()).append("\", new google.maps.Size(").append(tamano).append("));");
            motor.append("\n listaIconos.put(\"").append(icono.getIconoNombre()).append("\",").append(icono.getIconoNombre()).append(");");
        }
        if (listaPuntosActualizacionAutomatica != null && listaPuntosActualizacionAutomatica.size() > 0) {
            motor.append("\n cargarListaPuntosActualizacionAutomatica();");
        }
        if (listaPuntosActualizacionManual != null && listaPuntosActualizacionManual.size() > 0) {
            final StrBuilder strBuilder = new StrBuilder();
            listaPuntosActualizacionManual.stream().filter(puntoGeografico -> JMUtileriaString.validarPosicion(puntoGeografico.getLatitud()) && JMUtileriaString.validarPosicion(puntoGeografico.getLongitud())).forEach(puntoGeografico -> {
                strBuilder.append("\n listaPuntosActualizacionManual.put(\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
//                strBuilder.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(')');
                strBuilder.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(')');
                strBuilder.append(",\"").append(puntoGeografico.getDescripcionHTML()).append('\"');
                strBuilder.append(",\"").append(puntoGeografico.getIconoNombre()).append('\"');
                strBuilder.append(',').append(puntoGeografico.getEsArrastable()).append("");
                strBuilder.append(",\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
                strBuilder.append(",\"").append(puntoGeografico.getEtiqueta()).append("\"));");
                return;
            });
        }
        if (listaPuntosEstaticos != null && listaPuntosEstaticos.size() > 0) {
            final StrBuilder strBuilder2= new StrBuilder();
            listaPuntosEstaticos.stream().filter(puntoGeografico -> JMUtileriaString.validarPosicion(puntoGeografico.getLatitud()) && JMUtileriaString.validarPosicion(puntoGeografico.getLongitud())).forEach(puntoGeografico -> {
                strBuilder2.append("\n listaPuntosEstaticos.put(\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
//                strBuilder2.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(')');
                strBuilder2.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(')');
                strBuilder2.append(",\"").append(puntoGeografico.getDescripcionHTML()).append('\"');
                strBuilder2.append(",\"").append(puntoGeografico.getIconoNombre()).append('\"');
                strBuilder2.append(',').append(puntoGeografico.getEsArrastable()).append("");
                strBuilder2.append(",\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
                strBuilder2.append(",\"").append(puntoGeografico.getEtiqueta()).append("\"));");
                return;
            });
        }
        if (listaPuntosInteres != null && listaPuntosInteres.size() > 0) {
            final StrBuilder strBuilder3 = new StrBuilder();
            listaPuntosInteres.stream().filter(puntoGeografico -> JMUtileriaString.validarPosicion(puntoGeografico.getLatitud()) && JMUtileriaString.validarPosicion(puntoGeografico.getLongitud())).forEach(puntoGeografico -> {
                strBuilder3.append("\n listaPuntosInteres.put(\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
//                strBuilder3.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(')');
                strBuilder3.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico.getLatitud())).append(',').append(NumberUtils.toDouble(puntoGeografico.getLongitud())).append(')');
                strBuilder3.append(",\"").append(puntoGeografico.getDescripcionHTML()).append('\"');
                strBuilder3.append(",\"").append(puntoGeografico.getIconoNombre()).append('\"');
                strBuilder3.append(',').append(puntoGeografico.getEsArrastable()).append("");
                strBuilder3.append(",\"").append(puntoGeografico.getIdentificadorUnico()).append('\"');
                strBuilder3.append(",\"").append(puntoGeografico.getEtiqueta()).append("\"));");
                return;
            });
        }
        if (listaPuntosTraza != null && listaPuntosTraza.size() > 0) {
            final JMPuntoGeografico puntoInicio = listaPuntosTraza.get(0);
//            motor.append("\n obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoInicio.getLongitud())).append(',').append(NumberUtils.toDouble(puntoInicio.getLatitud())).append(')');
            motor.append("\n obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoInicio.getLatitud())).append(',').append(NumberUtils.toDouble(puntoInicio.getLongitud())).append(')');
            motor.append(",\"Inicio de la Traza\"");
            motor.append(",\"traza_inicio\"");
            motor.append(",false");
            motor.append(",\"inicio\",\"").append(puntoInicio.getEtiqueta()).append("\");");
//            motor.append("\n mapa.setCenter(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoInicio.getLongitud())).append(',').append(NumberUtils.toDouble(puntoInicio.getLatitud())).append("));");
            motor.append("\n mapa.setCenter(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoInicio.getLatitud())).append(',').append(NumberUtils.toDouble(puntoInicio.getLongitud())).append("));");
            motor.append("\n mapa.setZoom(11);");
            final JMPuntoGeografico puntoFin = listaPuntosTraza.get(listaPuntosTraza.size() - 1);
//            motor.append("\n obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoFin.getLongitud())).append(',').append(NumberUtils.toDouble(puntoFin.getLatitud())).append(')');
            motor.append("\n obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoFin.getLatitud())).append(',').append(NumberUtils.toDouble(puntoFin.getLongitud())).append(')');
            motor.append(",\"Fin de la Traza\"");
            motor.append(",\"traza_fin\"");
            motor.append(",false");
            motor.append(",\"fin\",\"").append(puntoFin.getEtiqueta()).append("\");");
            int i = 0;
            for (final JMPuntoGeografico puntoGeografico2 : listaPuntosTraza) {
                motor.append("\n listaPuntosEstaticos.put(\"").append(puntoGeografico2.getIdentificadorUnico()).append('\"');
//                motor.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico2.getLongitud())).append(',').append(NumberUtils.toDouble(puntoGeografico2.getLatitud())).append(')');
                motor.append(",obtenerMarcador(new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico2.getLatitud())).append(',').append(NumberUtils.toDouble(puntoGeografico2.getLongitud())).append(')');
                motor.append(",\"").append(puntoGeografico2.getDescripcionHTML()).append('\"');
                motor.append(",\"traza_punto\"");
                motor.append(",false");
                motor.append(",\"").append(puntoGeografico2.getIdentificadorUnico()).append("\",\"").append(puntoGeografico2.getEtiqueta()).append("\")");
                motor.append(");");
//                motor.append("\n listaPoligonos[").append(i).append("] = new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico2.getLongitud())).append(',').append(NumberUtils.toDouble(puntoGeografico2.getLatitud())).append(");");
                motor.append("\n listaPoligonos[").append(i).append("] = new google.maps.LatLng(").append(NumberUtils.toDouble(puntoGeografico2.getLatitud())).append(',').append(NumberUtils.toDouble(puntoGeografico2.getLongitud())).append(");");
                ++i;
            }
            motor.append("\n var poligonos = new google.maps.Polyline({path:listaPoligonos, map:mapa,strokeColor:'#008C99', strokeOpacity: 1.0, strokeWeight: 2, geodesic: true});");
        }
        if (listaDeGeocercas != null && listaDeGeocercas.size() > 0) {
            int j = 0;
            for (final JMPoligonoGeografico geocerca : listaDeGeocercas) {
                if (geocerca.getListaDePuntos() != null) {
                    motor.append("\n var pts_").append(j).append(" = new google.maps.MVCArray; ");
                    for (final JMPuntoGeografico punto : geocerca.getListaDePuntos()) {
//                        motor.append("pts_").append(j).append(".insertAt(pts_").append(j).append(".length, new google.maps.LatLng(").append(NumberUtils.toDouble(punto.getLongitud())).append(',').append(NumberUtils.toDouble(punto.getLatitud())).append("));");
                    	motor.append("pts_").append(j).append(".insertAt(pts_").append(j).append(".length, new google.maps.LatLng(").append(NumberUtils.toDouble(punto.getLatitud())).append(',').append(NumberUtils.toDouble(punto.getLongitud())).append("));");
                    }
                    motor.append(" var geocerca_").append(j).append(" = new google.maps.Polygon({strokeWeight: 0.7, fillColor: '").append(geocerca.getColor()).append("', fillOpacity: 0.5 });");
                    motor.append(" geocerca_").append(j).append(".setMap(mapa);");
                    motor.append(" geocerca_").append(j).append(".setPaths(new google.maps.MVCArray([pts_").append(j).append("]));");
                    ++j;
                }
            }
        }
        if (soporteGeocerca) {
            motor.append("\n var markers = [];");
            motor.append("\n var path = new google.maps.MVCArray;");
            motor.append("\n function addPoint(event) {");
            motor.append("\n  insertarNuevasCoordenadas(event.latLng); insertarPunto(); path.insertAt(path.length, event.latLng);");
            motor.append("\n var marker = new google.maps.Marker({");
            motor.append("\n position: event.latLng,");
            motor.append("\n map: mapa");
            motor.append("\n });");
            motor.append("\n markers.push(marker);");
            motor.append("\n marker.setTitle('#' + path.length) };");
            motor.append("\n  poly = new google.maps.Polygon({ strokeWeight: 3, fillColor: '#5555FF'});");
            motor.append("\n  poly.setMap(mapa);");
            motor.append("\n  poly.setPaths(new google.maps.MVCArray([path]));");
            motor.append("\n  google.maps.event.addListener(mapa, 'rightclick', addPoint);");
        }
        motor.append("\n ");
        motor.append("\n }");
        motor.append("\n ");
        return "<script type='text/javascript'>\n" + Objects.toString(motor, "") + "</script>";
    }
}
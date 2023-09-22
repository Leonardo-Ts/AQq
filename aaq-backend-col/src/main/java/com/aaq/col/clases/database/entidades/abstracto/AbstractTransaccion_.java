package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractTransaccion.class)
public abstract class AbstractTransaccion_ { 

    public static volatile SingularAttribute<AbstractTransaccion, String> numeroAutorizacion;
    public static volatile SingularAttribute<AbstractTransaccion, String> fuente;
    public static volatile SingularAttribute<AbstractTransaccion, String> numeroSiniestro;
    public static volatile SingularAttribute<AbstractTransaccion, String> numeroPoliza;
    public static volatile SingularAttribute<AbstractTransaccion, String> numeroReferencia;
    public static volatile SingularAttribute<AbstractTransaccion, String> checksum;
    public static volatile SingularAttribute<AbstractTransaccion, Integer> id;
    public static volatile SingularAttribute<AbstractTransaccion, String> numeroReporte;
    public static volatile SingularAttribute<AbstractTransaccion, CatalogoCodigoRespuestaBancario> catalogoCodigoRespuestaBancario;
    public static volatile SingularAttribute<AbstractTransaccion, String> voucherCliente;
    public static volatile SingularAttribute<AbstractTransaccion, Boolean> transaccionAprobada;
    public static volatile SingularAttribute<AbstractTransaccion, String> voucherGeneral;
    public static volatile SingularAttribute<AbstractTransaccion, String> numeroOperacion;
    public static volatile SingularAttribute<AbstractTransaccion, String> tipoDeCobro;
    public static volatile SingularAttribute<AbstractTransaccion, String> xmlRespuesta;
    public static volatile SingularAttribute<AbstractTransaccion, String> respuestaAmigable;
    public static volatile SingularAttribute<AbstractTransaccion, Terminal> terminal;
    public static volatile SingularAttribute<AbstractTransaccion, String> voucherComercio;
    public static volatile SingularAttribute<AbstractTransaccion, String> xmlTarjeta;
    public static volatile SingularAttribute<AbstractTransaccion, String> claveOficina;
    public static volatile SingularAttribute<AbstractTransaccion, Date> fecha;
    public static volatile SingularAttribute<AbstractTransaccion, String> monto;
    public static volatile SingularAttribute<AbstractTransaccion, String> coberturaAfectada;
    public static volatile SingularAttribute<AbstractTransaccion, Usuario> usuario;
    public static volatile SingularAttribute<AbstractTransaccion, String> datosAdicionales;
    public static volatile SingularAttribute<AbstractTransaccion, String> mesesSinInteres;
    public static volatile SingularAttribute<AbstractTransaccion, Integer> claveAbogado;


}
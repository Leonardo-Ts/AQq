package com.aaq.col.clases.database.entidades.abstracto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractHistoricoTerminal.class)
public abstract class AbstractHistoricoTerminal_ { 

    public static volatile SingularAttribute<AbstractHistoricoTerminal, Date> fecha;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, String> fuente;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, String> detalles;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, Usuario> usuario;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, Integer> id;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, String> operacion;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, Terminal> terminal;
    public static volatile SingularAttribute<AbstractHistoricoTerminal, String> reporte;

}
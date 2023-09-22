package com.aaq.col.clases.database.entidades.abstracto;


import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Grupo;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractHorarioGrupo.class)
public abstract class AbstractHorarioGrupo_ { 

    public static volatile SingularAttribute<AbstractHorarioGrupo, String> claveHorario;
    public static volatile SingularAttribute<AbstractHorarioGrupo, Integer> id;
    public static volatile SingularAttribute<AbstractHorarioGrupo, Grupo> grupo;
    public static volatile SingularAttribute<AbstractHorarioGrupo, Date> fechaInicio;
    public static volatile SingularAttribute<AbstractHorarioGrupo, Date> fechaFin;
}
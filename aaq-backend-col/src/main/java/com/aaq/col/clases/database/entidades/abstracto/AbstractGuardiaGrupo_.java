package com.aaq.col.clases.database.entidades.abstracto;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.aaq.col.clases.database.entidades.Grupo;

@Generated(value="JMMetamodelGeneratorSuperUltraEclipse-2.6.0.v20150309-rNA")
@StaticMetamodel(AbstractGuardiaGrupo.class)
public abstract class AbstractGuardiaGrupo_ { 

    public static volatile SingularAttribute<AbstractGuardiaGrupo, Integer> id;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Grupo> grupo;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> lunesGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> martesGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> miercolesGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> juevesGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> viernesGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> sabadoGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> domingoGuardia;
    public static volatile SingularAttribute<AbstractGuardiaGrupo, Boolean> activaGuardia;
}
package ucab.dsw.accesodatos;

import ucab.dsw.entidades.EjecutaEncuesta;

import javax.persistence.EntityManager;

public class DaoEjecutaEncuesta extends Dao<EjecutaEncuesta>{
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoEjecutaEncuesta( )
    {
        super( _handler );
    }
}

package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Ejecucionencuesta;
import ucab.dsw.entidades.categoria;

import javax.persistence.EntityManager;

public class DaoEjecucionEncuesta extends Dao<Ejecucionencuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoEjecucionEncuesta( )
    {
        super( _handler );
    }

}

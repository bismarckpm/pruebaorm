package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Ejecucionencuesta;

import javax.persistence.EntityManager;

public class DaoEjecucionencuesta extends Dao<Ejecucionencuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEjecucionencuesta( ) {
        super( _handler );
    }

}

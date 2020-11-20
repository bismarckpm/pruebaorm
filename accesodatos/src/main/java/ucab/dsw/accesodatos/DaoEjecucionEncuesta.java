package ucab.dsw.accesodatos;

import ucab.dsw.entidades.EjecucionEncuesta;

/**
 *
 * @author Omar David
 */
public class DaoEjecucionEncuesta extends Dao<EjecucionEncuesta>{
    
    static DaoHandler _handler = new DaoHandler();

    public DaoEjecucionEncuesta( )
    {
        super( _handler );
    }
}
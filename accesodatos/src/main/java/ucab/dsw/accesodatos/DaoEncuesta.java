package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Encuesta;

/**
 *
 * @author Omar David
 */
public class DaoEncuesta extends Dao<Encuesta>{
    static DaoHandler _handler = new DaoHandler();

    public DaoEncuesta( )
    {
        super( _handler );
    }
}

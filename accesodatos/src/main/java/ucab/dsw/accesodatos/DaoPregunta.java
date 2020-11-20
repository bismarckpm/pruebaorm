package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Pregunta;

/**
 *
 * @author Omar David
 */
public class DaoPregunta extends Dao<Pregunta>{

    static DaoHandler _handler = new DaoHandler();

    public DaoPregunta( )
    {
        super( _handler );
    }
}

package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Estudio;

/**
 *
 * @author Omar David
 */
public class DaoEstudio extends Dao<Estudio>{
    
    static DaoHandler _handler = new DaoHandler();

    public DaoEstudio( )
    {
        super( _handler );
    }
}
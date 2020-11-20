package ucab.dsw.accesodatos;

import ucab.dsw.entidades.TipoUsuario;

/**
 *
 * @author Omar David
 */
public class DaoTipoUsuario extends Dao<TipoUsuario>{
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoUsuario( )
    {
        super( _handler );
    }
}

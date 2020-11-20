package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Usuario;

public class DaoUsuario extends Dao<Usuario>
{
    static DaoHandler _handler = new DaoHandler();

    public DaoUsuario( )
    {
        super( _handler );
    }
}
package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Solicitud;

/**
 *
 * @author Omar David
 */
public class DaoSolicitud extends Dao<Solicitud>{
    static DaoHandler _handler = new DaoHandler();

    public DaoSolicitud( )
    {
        super( _handler );
    }

}

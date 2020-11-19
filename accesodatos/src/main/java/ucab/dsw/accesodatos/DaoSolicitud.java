package ucab.dsw.accesodatos;

import ucab.dsw.entidades.solicitud;

import javax.persistence.EntityManager;

public class DaoSolicitud extends Dao<solicitud> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoSolicitud( )
    {
        super( _handler );
    }
}

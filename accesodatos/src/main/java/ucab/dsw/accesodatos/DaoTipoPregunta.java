package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Tipopregunta;
import ucab.dsw.entidades.solicitud;

import javax.persistence.EntityManager;

public class DaoTipoPregunta extends Dao<Tipopregunta> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoPregunta( )
    {
        super( _handler );
    }
}
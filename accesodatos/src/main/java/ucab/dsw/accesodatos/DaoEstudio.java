package ucab.dsw.accesodatos;

import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoHandler;
import ucab.dsw.entidades.EstudioEnt;

import javax.persistence.EntityManager;

public class DaoEstudio extends Dao<EstudioEnt>
{
    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoEstudio( )
    {
        super( _handler );
    }
}

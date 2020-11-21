package ucab.dsw.accesodatos;

import ucab.dsw.entidades.SubCategoria;

import javax.persistence.EntityManager;

public class DaoSubCategoria extends Dao<SubCategoria> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoSubCategoria( )
    {
        super( _handler );
    }
}

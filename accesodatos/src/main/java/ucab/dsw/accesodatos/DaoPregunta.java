package ucab.dsw.accesodatos;

import javax.persistence.EntityManager;

public class DaoPregunta extends Dao<DaoPregunta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoPregunta( )
    {
        super( _handler );
    }
}

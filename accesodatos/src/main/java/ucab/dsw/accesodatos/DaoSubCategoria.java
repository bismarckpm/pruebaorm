package ucab.dsw.accesodatos;

import ucab.dsw.entidades.categoria;
import ucab.dsw.entidades.subCategoria;
import javax.persistence.EntityManager;


public class DaoSubCategoria extends Dao<subCategoria>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoSubCategoria( )
    {
        super( _handler );
    }
}

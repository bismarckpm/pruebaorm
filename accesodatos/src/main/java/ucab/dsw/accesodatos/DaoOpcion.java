package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import javax.persistence.EntityManager;

public class DaoOpcion extends Dao<Opcion>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoOpcion( )
    {
        super( _handler );
    }
}

package ucab.dsw.accesodatos;

import javax.persistence.EntityManager;
import ucab.dsw.entidades.Pregunta;

public class DaoPregunta extends Dao<Pregunta>
{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPregunta( )
    {
        super( _handler );
    }
}

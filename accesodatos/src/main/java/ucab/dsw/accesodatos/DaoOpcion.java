package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Opcion;

/**
 *
 * @author Omar David
 */
public class DaoOpcion extends Dao<Opcion>{
    static DaoHandler _handler = new DaoHandler();

    public DaoOpcion() {
        super(_handler);
    }
    
}

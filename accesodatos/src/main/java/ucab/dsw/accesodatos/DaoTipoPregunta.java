package ucab.dsw.accesodatos;

import ucab.dsw.entidades.TipoPregunta;

/**
 *
 * @author Omar David
 */
public class DaoTipoPregunta extends Dao<TipoPregunta>{
     static DaoHandler _handler = new DaoHandler();

    public DaoTipoPregunta() {
        super(_handler);
    }
}

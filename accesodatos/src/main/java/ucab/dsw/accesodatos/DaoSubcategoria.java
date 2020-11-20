package ucab.dsw.accesodatos;

import ucab.dsw.entidades.SubcategoriaEnt;
import javax.persistence.EntityManager;

public class DaoSubcategoria extends Dao<SubcategoriaEnt> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoSubcategoria() {
        super( _handler );
    }

}

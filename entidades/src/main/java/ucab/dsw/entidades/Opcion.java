package ucab.dsw.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase{
    public Opcion( long id )
    {
        super( id );
    }

    public Opcion()
    {

    }
}

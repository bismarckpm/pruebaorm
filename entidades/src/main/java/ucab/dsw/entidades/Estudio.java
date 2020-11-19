package ucab.dsw.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "estudio" )
public class Estudio extends EntidadBase {
    public Estudio( long id )
    {
        super( id );
    }

    public Estudio()
    {

    }
}

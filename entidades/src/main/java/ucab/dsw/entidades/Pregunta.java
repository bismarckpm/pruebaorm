package ucab.dsw.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{
    public Pregunta( long id )
    {
        super( id );
    }

    public Pregunta()
    {

    }
}

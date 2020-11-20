package ucab.dsw.dtos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class CategoriaDto extends DtoBase{

    private String descripcion;

    private String estatus;

    public CategoriaDto()
    {
    }

    public CategoriaDto( long id ) throws Exception
    {
        super( id );
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }


    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

}

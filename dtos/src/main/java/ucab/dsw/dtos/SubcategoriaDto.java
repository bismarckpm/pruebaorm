package ucab.dsw.dtos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class SubcategoriaDto extends DtoBase{
    private String descripcion;
    private String estatus;

    public SubcategoriaDto()
    {
    }

    public SubcategoriaDto( long id ) throws Exception
    {
        super( id );
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


}

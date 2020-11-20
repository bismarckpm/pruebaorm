package ucab.dsw.dtos;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class CategoriaDto extends DtoBase {

    private String descripcion;

    private String estatus;

    private List<SubcategoriaDto> subcategorias;

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

    public List<SubcategoriaDto> getSubcategorias() {
        return subcategorias;
    }

    public CategoriaDto(long id) throws Exception {
        super(id);
    }

    public CategoriaDto() {
    }

    public void setSubcategorias(List<SubcategoriaDto> subcategorias) {
        this.subcategorias = subcategorias;
    }
}

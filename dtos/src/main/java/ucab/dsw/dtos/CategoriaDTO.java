package ucab.dsw.dtos;

public class CategoriaDTO extends DtoBase {
    private String descripcion;
    private String estatus;

    public CategoriaDTO(String descripcion, String estatus) {
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public CategoriaDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaDTO() {
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

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "descripcion='" + descripcion + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}

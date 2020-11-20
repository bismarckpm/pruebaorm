
package ucab.dsw.dtos;

public class TipoPreguntaDto extends DtoBase{


    public TipoPreguntaDto()
    { }

    public TipoPreguntaDto( long id ) throws Exception
    { super( id ); }

    private String descripcion;
    private String estatus;

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String _descripcion) { this.descripcion = _descripcion; }

    public String getEstatus()
    {
        return estatus;
    }
    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }


}

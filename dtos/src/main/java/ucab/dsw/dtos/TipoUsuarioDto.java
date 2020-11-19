package ucab.dsw.dtos;

public class TipoUsuarioDto extends DtoBase {

    private String estatus;
    private String descripcion;

    public TipoUsuarioDto() { }

    public TipoUsuarioDto( long id ) throws Exception { super( id ); }

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

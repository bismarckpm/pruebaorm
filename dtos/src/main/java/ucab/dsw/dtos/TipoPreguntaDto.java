package ucab.dsw.dtos;

public class TipoPreguntaDto extends DtoBase{

    //Contructor
    public TipoPreguntaDto(long id) throws Exception { super(id); }
    public TipoPreguntaDto() { }

    //Columnas
    private String descripcion;
    private String estatus;

    //Getter and Setter
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

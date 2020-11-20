package ucab.dsw.dtos;

public class OpcionDto extends DtoBase{
    //Contructor
    public OpcionDto(long id) throws Exception { super(id); }
    public OpcionDto() { }

    //Columnas
    private String descripcion;
    private String estatus;
    private PreguntaDto idPregunta;

    //Getter and Setter
    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstatus() { return estatus; }

    public void setEstatus(String estatus) { this.estatus = estatus; }

    public PreguntaDto getIdPregunta() { return idPregunta; }

    public void setIdPregunta(PreguntaDto idPregunta) { this.idPregunta = idPregunta; }
}

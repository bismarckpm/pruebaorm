package ucab.dsw.dtos;

public class PreguntaDto extends DtoBase{

    //Contructor
    public PreguntaDto(long id) throws Exception { super(id); }
    public PreguntaDto() { }

    //Columnas
    private String pregunta;
    private String fechacreacion;
    private String estatus;
    private TipoPreguntaDto idTipoPregunta;
    private SubCategoriaDto idSubCategoria;
    private UsuarioDto idUsuario;

    //Getter and Setter

    public String getPregunta() { return pregunta; }

    public void setPregunta(String pregunta) { this.pregunta = pregunta; }

    public String getFechacreacion() { return fechacreacion; }

    public void setFechacreacion(String fechacreacion) { this.fechacreacion = fechacreacion; }

    public String getEstatus() { return estatus; }

    public void setEstatus(String estatus) { this.estatus = estatus; }

    public TipoPreguntaDto getIdTipoPregunta() { return idTipoPregunta; }

    public void setIdTipoPregunta(TipoPreguntaDto idTipoPregunta) { this.idTipoPregunta = idTipoPregunta; }

    public SubCategoriaDto getIdSubCategoria() { return idSubCategoria; }

    public void setIdSubCategoria(SubCategoriaDto idSubCategoria) { this.idSubCategoria = idSubCategoria; }

    public UsuarioDto getIdUsuario() { return idUsuario; }

    public void setIdUsuario(UsuarioDto idUsuario) { this.idUsuario = idUsuario; }
}

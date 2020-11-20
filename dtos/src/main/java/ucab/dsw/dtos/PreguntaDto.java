package ucab.dsw.dtos;

public class PreguntaDto extends DtoBase{
    private String pregunta;
    private String fechacreacion;
    private String estatus;
    private TipoPreguntaDto tipoPreguntaDto;

    public PreguntaDto() {

    }
    //private Subcategoria subcategoria;


    public String getEstatus() {
        return estatus;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    //public Subcategoria getSubcategoria() {
    //    return subcategoria;
    //}

    public TipoPreguntaDto getTipoPreguntaDto() {
        return tipoPreguntaDto;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    //public void setSubcategoria(Subcategoria subcategoria) {
    //    this.subcategoria = subcategoria;
    //}

    public void setTipoPreguntaDto(TipoPreguntaDto tipoPreguntaDto) {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    public PreguntaDto(long id) throws Exception {
        super(id);
    }
}

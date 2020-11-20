package ucab.dsw.dtos;

public class OpcionDto extends DtoBase {

    private String descricion;
    private String estatus;
    private PreguntaDto pregunta;

    public OpcionDto(long id) throws Exception {
        super(id);
    }

    public OpcionDto() {
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public PreguntaDto getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaDto pregunta) {
        this.pregunta = pregunta;
    }
}

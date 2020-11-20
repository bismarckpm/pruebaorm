package ucab.dsw.dtos;

public class EjecucionEncuestaDTO {
    private int id;
    private int idEncuesta;
    private int idPregunta;
    private int idUsuario;
    private int idOpcion;
    private EncuestaDTO encuestaDTO;
    private PreguntaDTO preguntaDTO;
    private UsuarioDto usuarioDto;
    private OpcionDTO opcionDTO;
    private String respuesta;
    private String estatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EncuestaDTO getEncuestaDTO() {
        return encuestaDTO;
    }

    public void setEncuestaDTO(EncuestaDTO encuestaDTO) {
        this.encuestaDTO = encuestaDTO;
    }

    public PreguntaDTO getPreguntaDTO() {
        return preguntaDTO;
    }

    public void setPreguntaDTO(PreguntaDTO preguntaDTO) {
        this.preguntaDTO = preguntaDTO;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public OpcionDTO getOpcionDTO() {
        return opcionDTO;
    }

    public void setOpcionDTO(OpcionDTO opcionDTO) {
        this.opcionDTO = opcionDTO;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    @Override
    public String toString() {
        return "EjecucionEncuestaDTO{" +
                "id=" + id +
                ", idEncuesta=" + idEncuesta +
                ", idPregunta=" + idPregunta +
                ", idUsuario=" + idUsuario +
                ", idOpcion=" + idOpcion +
                ", respuesta='" + respuesta + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}

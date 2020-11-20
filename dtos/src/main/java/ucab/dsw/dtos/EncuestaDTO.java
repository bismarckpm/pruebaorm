package ucab.dsw.dtos;

public class EncuestaDTO {
    private int id;
    private int idEstudio;
    private int idUsuarioAnalista;
    private int idUsuarioCreador;
    private UsuarioDto usuarioCreador;
    private UsuarioDto usuarioAnalista;
    private EstudioDTO estudioDTO;
    private String fechaCreacion;
    private String estatus;

    public EncuestaDTO() {
    }

    public EncuestaDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioDto getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(UsuarioDto usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public UsuarioDto getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(UsuarioDto usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }

    public EstudioDTO getEstudioDTO() {
        return estudioDTO;
    }

    public void setEstudioDTO(EstudioDTO estudioDTO) {
        this.estudioDTO = estudioDTO;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }

    public int getIdUsuarioAnalista() {
        return idUsuarioAnalista;
    }

    public void setIdUsuarioAnalista(int idUsuarioAnalista) {
        this.idUsuarioAnalista = idUsuarioAnalista;
    }

    public int getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public void setIdUsuarioCreador(int idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }
}

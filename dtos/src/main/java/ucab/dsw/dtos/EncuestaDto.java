package ucab.dsw.dtos;

import java.sql.Date;

public class EncuestaDto extends DtoBase{
    private Date fechaCreacion;
    private String status;
    private UsuarioDto idUsuario_Creador;
    private UsuarioDto idUsuario_Analista;
    private EstudioDto idEstudio;

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsuarioDto getIdUsuario_Creador() {
        return idUsuario_Creador;
    }

    public void setIdUsuario_Creador(UsuarioDto idUsuario_Creador) {
        this.idUsuario_Creador = idUsuario_Creador;
    }

    public UsuarioDto getIdUsuario_Analista() {
        return idUsuario_Analista;
    }

    public void setIdUsuario_Analista(UsuarioDto idUsuario_Analista) {
        this.idUsuario_Analista = idUsuario_Analista;
    }

    public EstudioDto getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(EstudioDto idEstudio) {
        this.idEstudio = idEstudio;
    }
}

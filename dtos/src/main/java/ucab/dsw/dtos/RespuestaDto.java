package ucab.dsw.dtos;

public class RespuestaDto<T> extends DtoBase{
    public String token;
    public String estado;
    public Object objecto;
    public String mensaje;
    public String mensajesoporte;

    public RespuestaDto()  {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Object getObjecto() {
        return objecto;
    }

    public void setObjecto(Object objecto) {
        this.objecto = objecto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensajesoporte() {
        return mensajesoporte;
    }

    public void setMensaje_soporte(String mensaje_soporte) {
        this.mensajesoporte = mensaje_soporte;
    }

    public void setObjeto(T resultado) {
        this.objecto=resultado;
    }

    public void setMensajesoporte(String localizedMessage) {
        this.mensajesoporte=localizedMessage;
    }
}

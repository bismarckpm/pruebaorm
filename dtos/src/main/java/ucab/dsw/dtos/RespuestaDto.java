package ucab.dsw.dtos;

public class RespuestaDto<T> extends DtoBase {

    private String token;
    private String mensaje;
    private String estado;
    private Object objeto;
    private String mensajesoporte;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public String getMensajesoporte() {
        return mensajesoporte;
    }

    public void setMensajesoporte(String mensajesoporte) {
        this.mensajesoporte = mensajesoporte;
    }
}


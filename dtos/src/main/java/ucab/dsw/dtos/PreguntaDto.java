package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase {

    private String pregunta;
    private Date fechacreacion;
    private String estatus;

    public String getPregunta()
    {
        return pregunta;
    }

    public void setPregunta( String pregunta )
    {
        this.pregunta = pregunta;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
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

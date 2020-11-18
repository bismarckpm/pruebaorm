package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDto extends DtoBase {

    private Date fechacreacion;
    private String estatus;

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public Date getFechacreacion()
    {
        return fechacreacion;
    }

    public void setFechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }

}

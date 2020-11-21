package ucab.dsw.dtos;

public class DtoEjecucionEncuesta extends DtoBase{
    private String id;
    private String estatus;
    private String respuesta;

    public String getestatus()
    {
        return estatus;
    }
    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public String getRespuesta()
    {
        return respuesta;
    }
    public void setrespuesta( String respuesta )
    {
        this.respuesta = respuesta;
    }

    public DtoEjecucionEncuesta getejecucionencuesta()
    {
        return ejecucionencuestadto;
    }

    public void setEjecucionEncuesta( DtoEjecucionEncuesta ejecucion )
    {
        this.ejecucionencuestadto= ejecucion;
    }


    private DtoEjecucionEncuesta ejecucionencuestadto;








}



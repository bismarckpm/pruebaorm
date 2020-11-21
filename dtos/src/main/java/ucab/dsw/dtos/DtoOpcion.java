package ucab.dsw.dtos;

public class DtoOpcion extends DtoBase {
    private String id;
    private String estatus;
    private String descripcion;

    public DtoOpcion() {

    }

    public DtoOpcion(long id) throws Exception {
        super(id);
    }

    public String getestatus()
    {
        return estatus;
    }

    public void setestatus( String estatus )
    {
        this.estatus = estatus;
    }

    public DtoOpcion getTipoPregunta()
    {
        return opcion;
    }

    public void setOpcionDto( DtoEjecucionEncuesta ejecucion )
    {
        this.opcion= opcion;
    }


    private DtoOpcion opcion;



    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

}

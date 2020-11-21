package ucab.dsw.dtos;



public class DtoTipoPregunta extends DtoBase{
    private String id;
    private String estatus;
    private String descripcion;

    public DtoTipoPregunta() {

    }

    public DtoTipoPregunta(long id) throws Exception {
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

    public DtoTipoPregunta getTipoPregunta()
    {
        return tipopregunta;
    }

    public void setTipoUsuarioDto( DtoEjecucionEncuesta ejecucion )
    {
        this.tipopregunta= tipopregunta;
    }


    private DtoTipoPregunta tipopregunta;



    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }


}

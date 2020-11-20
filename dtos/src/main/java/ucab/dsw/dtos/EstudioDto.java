package ucab.dsw.dtos;

import java.util.Date;

public class EstudioDto extends DtoBase {

    public EstudioDto(){}

    public EstudioDto(long id) throws Exception{
        super(id);
    }

    private UsuarioDto usuarioDto;
    private SolicitudDto solicitudDto;
    private Date fechaCreacion;
    private String estatus;

    public void setFechaCreacion(Date FC){this.fechaCreacion=FC;}
    public Date getFechaCreacion(){return this.fechaCreacion;}

    public void setEstatus(String E){this.estatus=E;}
    public String getEstatus(){return this.estatus;}

    public void setUsuarioDto(UsuarioDto U){this.usuarioDto=U;}
    public UsuarioDto getUsuarioDto(){return this.usuarioDto;}

    public void setSolicitudDto(SolicitudDto S){this.solicitudDto=S;}
    public SolicitudDto getSolicitudDto(){return this.solicitudDto;}







}

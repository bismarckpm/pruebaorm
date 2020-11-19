package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDto extends DtoBase{

    public EncuestaDto(){}

    public EncuestaDto(long id) throws Exception{
        super(id);
    }

    private UsuarioDto usuarioDtoAnalista;
    private UsuarioDto usuarioDtoCreador;
    private EstudioDto estudioDto;
    private Date fechaCreacion;
    private String estatus;

    public void setFechaCreacion(Date FC){this.fechaCreacion=FC;}
    public Date getFechaCreacion(){return this.fechaCreacion;}

    public void setEstatus(String E){this.estatus=E;}
    public String getEstatus(){return this.estatus;}

    public void setEstudio(EstudioDto E){this.estudioDto=E;}
    public EstudioDto getEstudio(){return this.estudioDto;}

    public void setUsuarioDtoAnalista(UsuarioDto UA){this.usuarioDtoAnalista=UA;}
    public UsuarioDto getUsuarioDtoAnalista(){return this.usuarioDtoAnalista;}

    public void setUsuarioDtoCreador(UsuarioDto UC){this.usuarioDtoCreador=UC;}
    public UsuarioDto getUsuarioDtoCreador(){return this.usuarioDtoCreador;}
}

package ucab.dsw.dtos;

import java.util.List;

public class EstudioDto extends DtoBase{

    public EstudioDto( long id ) throws Exception{
        super( id );
    }
  
    public EstudioDto(){
    }
    
    private String fechacreacion;
    private UsuarioDto usuarioDto;
    private solicitudDto solicitudDto;
    private List<EncuestaDto> encuestas;
    private String estatus;

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public solicitudDto getSolicitudDto() {
        return solicitudDto;
    }

    public void setSolicitudDto(solicitudDto solicitudDto) {
        this.solicitudDto = solicitudDto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public List<EncuestaDto> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<EncuestaDto> encuestas) {
        this.encuestas = encuestas;
    }
    
}

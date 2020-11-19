package ucab.dsw.dtos;

import java.util.List;

public class EncuestaDto extends DtoBase{
    
    public EncuestaDto( long id ) throws Exception{
        super( id );
    }
  
    public EncuestaDto(){
    }
    
    private UsuarioDto usuarioCreadorDto;
    private solicitudDto solicitudAnalistaDto;
    private EstudioDto estudioDto;
    private List<EjecucionEncuestaDto> ejecucionesEncuestas;
    private String fechacreacion;
    private String estatus;

    public UsuarioDto getUsuarioCreadorDto() {
        return usuarioCreadorDto;
    }

    public void setUsuarioCreadorDto(UsuarioDto usuarioCreadorDto) {
        this.usuarioCreadorDto = usuarioCreadorDto;
    }

    public solicitudDto getSolicitudAnalistaDto() {
        return solicitudAnalistaDto;
    }

    public void setSolicitudAnalistaDto(solicitudDto solicitudAnalistaDto) {
        this.solicitudAnalistaDto = solicitudAnalistaDto;
    }

    public EstudioDto getEstudioDto() {
        return estudioDto;
    }

    public void setEstudioDto(EstudioDto estudioDto) {
        this.estudioDto = estudioDto;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public List<EjecucionEncuestaDto> getEjecucionesEncuestas() {
        return ejecucionesEncuestas;
    }

    public void setEjecucionesEncuestas(List<EjecucionEncuestaDto> ejecucionesEncuestas) {
        this.ejecucionesEncuestas = ejecucionesEncuestas;
    }
    
}

package ucab.dsw.dtos;

import java.util.Date;

public class PreguntaDto extends DtoBase {

    public PreguntaDto() {
    }

    public PreguntaDto(long id) throws Exception {
        super(id);
    }

    private DtoEjecucionEncuesta EjecucionEncuestaDto;
    private DtoTipoPregunta preguntaDto;
    private CategoriaDto CategoriaDto;
    private Date fechaCreacion;
    private String estatus;

    public void setFechaCreacion(Date FC) {
        this.fechaCreacion = FC;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setEstatus(String E) {
        this.estatus = E;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setTipoPreguntaDto(DtoTipoPregunta U) {
        this.preguntaDto = U;
    }

    public DtoTipoPregunta gettipopregunta() {
        return this.preguntaDto;
    }

    public void setCategoriaDto(CategoriaDto S) {
        this.CategoriaDto = S;
    }

    public CategoriaDto getCategoriaDto() {
        return this.CategoriaDto;

        public void setDtoEjecucionEncuesta(DtoEjecucionEncuesta S) {
            this.EjecucionEncuestaDto = S;
        }

        public DtoEjecucionEncuesta getDtoEjecucionEncuesta() {
            return this.EjecucionEncuestaDto;
    }
}



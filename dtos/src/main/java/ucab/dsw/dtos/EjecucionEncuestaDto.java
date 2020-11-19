package ucab.dsw.dtos;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EjecucionEncuestaDto extends DtoBase{

    private String respuesta;

    private String estatus;

    private EncuestaDto encuesta;

    //private PreguntaDto pregunta;

    private UsuarioDto usuarioEncuestado;

    //private OpcionDto opcion;

    public EjecucionEncuestaDto( long id ) throws Exception
    {
        super( id );
    }

    public EjecucionEncuestaDto()
    {

    }

    public String getRespuesta()
    {
        return respuesta;
    }

    public void setRespuesta( String respuesta )
    {
        this.respuesta = respuesta;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public EncuestaDto getEncuesta()
    {
        return encuesta;
    }

    public void setEncuesta( EncuestaDto encuesta )
    {
        this.encuesta = encuesta;
    }

  /*public PreguntaDto getPregunta()
    {
        return pregunta;
    }*/
/*
    public void setPregunta( PreguntaDto pregunta )
    {
        this.pregunta = pregunta;
    }
*/
    public UsuarioDto get_usuarioEncuestado()
    {
        return usuarioEncuestado;
    }

    public void setUsuarioEncuestado( UsuarioDto usuarioEncuestado )
    {
        this.usuarioEncuestado = usuarioEncuestado;
    }
<<<<<<< HEAD
/*
    public OpcionDto getPpcion()
=======

    public OpcionDto getOpcion()
>>>>>>> b410740f8880e4db90945d2c5edc0041412c4332
    {
        return opcion;
    }

    public void setOpcion( OpcionDto opcion )
    {
        this.opcion = opcion;
    }*/
}

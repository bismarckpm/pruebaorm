package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "encuesta" )
public class Encuesta extends EntidadBase{

    @Column( name = "fechacreacion" )
    private Date fechacreacion;

    public Date get_fechacreacion()
    {
        return fechacreacion;
    }

    public void set_fechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }

    public Usuario get_usuariocreador()
    {
        return usuariocreador;
    }

    public void set_usuariocreador( Usuario usuariocreador )
    {
        this.usuariocreador = usuariocreador;
    }

    public Usuario get_usuarioanalista()
    {
        return usuarioanalista;
    }

    public void set_usuarioanalista( Usuario usuarioanalista )
    {
        this.usuarioanalista = usuarioanalista;
    }

    public EstudioEnt get_estudio()
    {
        return estudio;
    }

    public void set_estudio( EstudioEnt estudio )
    {
        this.estudio = estudio;
    }


    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario usuariocreador;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario usuarioanalista;

    @ManyToOne
    @JoinColumn( name = "idEstudio" )
    private EstudioEnt estudio;

    public Encuesta(){

    }

    public Encuesta( long id )
    {
        super( id );
    }
}

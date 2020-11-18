package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "opcion" )
public class Encuesta extends EntidadBase{

    @Column( name = "fechacreacion" )
    private Date _fechacreacion;

    public Date get_fechacreacion()
    {
        return _fechacreacion;
    }

    public void set_fechacreacion( Date _fechacreacion )
    {
        this._fechacreacion = _fechacreacion;
    }

    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _usuariocreador;

    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _usuarioanalista;

    /*@ManyToOne
    @JoinColumn( name = "idEstudio" )
    private Estudio _estudio;*/

    public Encuesta(){

    }

    public Encuesta( long id )
    {
        super( id );
    }
}

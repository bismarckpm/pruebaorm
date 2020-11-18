package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{

    @Column( name = "pregunta" )
    private String _pregunta;

    public String get_pregunta()
    {
        return _pregunta;
    }

    public void set_pregunta( String _pregunta )
    {
        this._pregunta = _pregunta;
    }

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
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    /*@ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subcategoria;*/

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    public Pregunta(){ }

    public Pregunta( long id )
    {
        super( id );
    }
}

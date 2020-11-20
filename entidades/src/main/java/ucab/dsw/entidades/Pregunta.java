package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{

    public Pregunta( long id )
    {
        super( id );
    }

    public Pregunta( )
    {

    }

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

    @Column( name = "estatus" )
    private String _estatus;

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    public SubCategoria get_subCategoria()
    {
        return _subCategoria;
    }

    public void set_subCategoria( SubCategoria _subCategoria )
    {
        this._subCategoria = _subCategoria;
    }

    public Usuario get_usuario()
    {
        return _usuario;
    }

    public void set_usuario( Usuario _usuario )
    {
        this._usuario = _usuario;
    }

    public TipoPregunta get_tipoPregunta()
    {
        return _tipoPregunta;
    }

    public void set_tipoPregunta( TipoPregunta _tipoPregunta )
    {
        this._tipoPregunta = _tipoPregunta;
    }

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipoPregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subCategoria;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;


}

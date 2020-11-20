package ucab.dsw.entidades;
import javax.persistence.*;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase {

    @Column( name = "pregunta" )
    private String _pregunta;

    @Column( name = "fechacreacion" )
    private String _fechaCreacion;


    public String get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(String _pregunta) {
        this._pregunta = _pregunta;
    }

    public String get_fechaCreacion() {
        return _fechaCreacion;
    }

    public void set_fechaCreacion(String _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    public TipoPregunta get_idTipoPregunta()
    {
        return _idTipoPregunta;
    }

    public void set_idTipoPregunta(TipoPregunta _idTipoPregunta) {
        this._idTipoPregunta = _idTipoPregunta;
    }

    public SubCategoria get_subCategoria (){ return _subCategoria;}

    public void set_subCategoria(SubCategoria _subCategoria){
        this._subCategoria = _subCategoria;
    }

    public Usuario get_usuarioPregunta()
    {
        return _usuarioPregunta;
    }

    public void set_usuarioPregunta( Usuario _usuarioPregunta ) {
        this._usuarioPregunta = _usuarioPregunta;
    }


    @Override public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;


    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _idTipoPregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subCategoria;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuarioPregunta;

    public Pregunta(long id ) {
        super( id );
    }

    public Pregunta()
    {

    }


}

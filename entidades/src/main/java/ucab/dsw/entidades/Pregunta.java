package ucab.dsw.entidades;
import javax.persistence.*;

@Entity

@Table( name = "pregunta")
public class Pregunta extends EntidadBase{
    @Column( name = "pregunta")
    private String pregunta;

    @Column( name = "fechacreacion")
    private String fechaCreacion;

    @Column( name = "estatus")
    private String estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subcategoria;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta tipoPregunta;

    public Pregunta( long id )
    {
        super( id );
    }

    public Pregunta()
    {

    }

    public String get_pregunta() {
        return pregunta;
    }

    public String get_fecha() {
        return fechaCreacion;
    }

    public TipoPregunta get_tipoPregunta() {
        return tipoPregunta;
    }


    public SubCategoria get_subcategoria() {
      return _subcategoria;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_tipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public void set_subcategoria(SubCategoria _subcategoria) {
        this._subcategoria = _subcategoria;
     }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public void set_estatus(String estatus) {
        this.estatus = estatus;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }


}

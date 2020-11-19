package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta extends EntidadBase {

    @Temporal(TemporalType.TIMESTAMP)
    @Column( name = "fechacreacion")
    private Date _fechaCreacion;

    @Column( name = "estatus" )
    private String _estatus;

    @Column( name = "pregunta")
    private  String _pregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubCategoria _subCategoria;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipoPregunta;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opciones = new ArrayList<>();

    public Pregunta(long id) {
        super(id);
    }

    public Pregunta() {
    }

    public Date get_fechaCreacion() {
        return _fechaCreacion;
    }

    public void set_fechaCreacion(Date _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public String get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(String _pregunta) {
        this._pregunta = _pregunta;
    }

    public SubCategoria get_subCategoria() {
        return _subCategoria;
    }

    public void set_subCategoria(SubCategoria _subCategoria) {
        this._subCategoria = _subCategoria;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public TipoPregunta get_tipoPregunta() {
        return _tipoPregunta;
    }

    public void set_tipoPregunta(TipoPregunta _tipoPregunta) {
        this._tipoPregunta = _tipoPregunta;
    }
    public Pregunta( long id )
    {
        super( id );
    }

    public Pregunta()
    {

    }
}

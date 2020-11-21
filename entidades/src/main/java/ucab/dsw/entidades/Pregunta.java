package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pregunta")
public class Pregunta extends EntidadBase {

    @Column(name = "pregunta")
    private String _pregunta;

    public String get_pregunta() {return _pregunta; }
    public void set_pregunta(String _pregunta) { this._pregunta = _pregunta; }

    @Column (name = "fechacreacion")
    private Date _fechacreacion;

    public Date get_fechacreacion() { return _fechacreacion; }
    public void set_fechacreacion(Date _fechacreacion) { this._fechacreacion = _fechacreacion; }

    @Column( name = "estatus")
    private String _status;

    @Override
    public String get_estatus() { return super.get_estatus(); }
    public void set_status(String _status) { this._status = _status; }

    @ManyToOne
    @JoinColumn(name = "idSubCategoria" )
    private Subcategoria _subcategoria;
    public Subcategoria get_subcategoria() { return _subcategoria; }
    public void set_subcategoria(Subcategoria _subcategoria) { this._subcategoria = _subcategoria; }

    @ManyToOne
    @JoinColumn(name = "idUsuario" )
    private Usuario _idusuario;

    public Usuario get_idusuario() { return _idusuario; }

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    @OneToMany( mappedBy = "_idPregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opciones;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuestas;

    public Pregunta( long id ) { super( id ); }
    public Pregunta(){ }
}

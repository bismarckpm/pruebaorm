package ucab.dsw.entidades;


import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase {

    @Column(name = "pregunta")
    private  String _pregunta;

    public String get_pregunta()
    {
        return _pregunta;
    }
    public void set_pregunta( String _pregunta )
    {
        this._pregunta = _pregunta;
    }


    @Column(name = "fechacreacion")
    private Date _fechacreacion;

    public Date get_fechacreacion() {
        return _fechacreacion;
    }
    public void set_fechacreacion( Date _fechacreacion ) {

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


    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    public TipoPregunta get_tipopregunta() {
        return _tipopregunta;
    }
    public void set_tipopregunta(TipoPregunta _tipopregunta) {
        this._tipopregunta = _tipopregunta;
    }

    @ManyToOne
    @JoinColumn( name = "idSubCategoria")
    private Subcategoria _subcategoria;

    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }
    public void set_subcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }

    @ManyToOne
    @JoinColumn( name = "idUsuario")
    private Usuario _usuario;

    public Usuario get_usuario() {
        return _usuario;
    }
    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    /* Con Opcion
    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opcion;

    public List<Opcion> get_opcion()
    {
        return _opcion;
    }

    public void set_opcion( List<Opcion> _opcion )
    {
        this._opcion = _opcion;
    }
    */

    /* Con ejecucionencuesta
     @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
     private List<EjecucionEncuesta> _ejecucionencuesta;

     public List<EjecucionEncuesta> get_ejecucionencuesta()
     {
     return _ejecucionencuesta;
     }

     public void set_ejecucionencuesta( List<EjecucionEncuesta> _ejecucionencuesta )
     {
     this._ejecucionencuesta = _ejecucionencuesta;
     }
     */



    public Pregunta(long id) {
        super(id);
    }

    public Pregunta() {

    }

}

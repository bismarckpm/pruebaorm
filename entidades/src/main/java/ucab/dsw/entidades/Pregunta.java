package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{
    //Contructor
    public Pregunta(long id) { super(id); }
    public Pregunta() { }

    //Columnas
    @Column( name = "pregunta", nullable = false )
    private String _pregunta;

    @Column( name = "fechacreacion", nullable = false )
    private String _fechacreacion;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta")
    private TipoPregunta _idTipoPregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria")
    private SubCategoria _idSubCategoria;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _idUsuario;
    /*
    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opciones;
    //*/
    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEcuestas;



    //Getter and Setter
    public String get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(String _pregunta) {
        this._pregunta = _pregunta;
    }

    public String get_fechacreacion() {
        return _fechacreacion;
    }

    public void set_fechacreacion(String _fechacreacion) {
        this._fechacreacion = _fechacreacion;
    }

    public TipoPregunta get_idTipoPregunta() {
        return _idTipoPregunta;
    }

    public void set_idTipoPregunta(TipoPregunta _idTipoPregunta) {
        this._idTipoPregunta = _idTipoPregunta;
    }

    public SubCategoria get_idSubCategoria() {
        return _idSubCategoria;
    }

    public void set_idSubCategoria(SubCategoria _idSubCategoria) {
        this._idSubCategoria = _idSubCategoria;
    }

    public Usuario get_idUsuario() {
        return _idUsuario;
    }

    public void set_idUsuario(Usuario _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /*
    public List<Opcion> get_opciones() { return _opciones; }

    public void set_opciones(List<Opcion> _opciones) { this._opciones = _opciones; }
    */
    public List<EjecucionEncuesta> get_ejecucionEcuestas() { return _ejecucionEcuestas; }

    public void set_ejecucionEcuestas(List<EjecucionEncuesta> _ejecucionEcuestas) { this._ejecucionEcuestas = _ejecucionEcuestas; }

}

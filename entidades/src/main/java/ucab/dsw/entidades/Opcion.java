package ucab.dsw.entidades;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase{

    @Column( name = "descripcion" )
    private String _descripcion;

    public String get_descripcion() { return _descripcion; }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }

    public TipoPregunta get_tipopregunta() { return _tipopregunta; }

    public void set_tipopregunta() { this._tipopregunta = _tipopregunta; }

    @Override
    public String get_estatus() { return _estatus; }

    @Override
    public void set_estatus( String _estatus ) { this._estatus = _estatus; }

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    @OneToMany( mappedBy = "_opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuestas;

    public Opcion( long id ) { super( id ); }

    public Opcion(){

    }

    public void set_tipopregunta(TipoPregunta _tipopregunta) {
        this._tipopregunta = _tipopregunta;
    }

    public List<EjecucionEncuesta> get_ejecucionEncuestas() {
        return _ejecucionEncuestas;
    }

    public void set_ejecucionEncuestas(List<EjecucionEncuesta> _ejecucionEncuestas) {
        this._ejecucionEncuestas = _ejecucionEncuestas;
    }

    //Falta anadir pregunta
}

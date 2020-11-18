package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="opcion")
public class Opcion extends EntidadBase{

    @Column(name ="descripcion")
    private String _descripcion;

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    @Column(name ="estatus")
    private String _estatus;

    public String get_estatus() {
        return _estatus;
    }

    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    //ManyToOne
    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta _pregunta;

    //OneToMany
    @OneToMany( mappedBy = "_opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionencuesta;

    public List<EjecucionEncuesta> get_ejecucionencuesta()
    {
        return _ejecucionencuesta;
    }
    public void set_ejecucionencuesta( List<EjecucionEncuesta> _ejecucionencuesta )
    {
        this._ejecucionencuesta = _ejecucionencuesta;
    }

    public Opcion( long id )
    {
        super( id );
    }

    public Opcion( )
    {

    }
}

package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Omar David
 */
@Entity
@Table(name = "opcion")
public class Opcion extends EntidadBase{
    @Column(name = "descripcion")
    private String _descripcion;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta _idPregunta;

    public Opcion(long id) {
        super(id);
    }

    public Opcion() {
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    @OneToMany( mappedBy = "_opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuentas;

    public List<EjecucionEncuesta> get_ejecucionEncuentas() {
        return _ejecucionEncuentas;
    }

    public void set_ejecucionEncuentas(List<EjecucionEncuesta> _ejecucionEncuentas) {
        this._ejecucionEncuentas = _ejecucionEncuentas;
    }

    public Pregunta getIdPregunta() {
        return _idPregunta;
    }

    public void setIdPregunta(Pregunta _idPregunta) {
        this._idPregunta = _idPregunta;
    }
    
}

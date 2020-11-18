package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Omar David
 */
@Entity
@Table(name = "opcion")
public class Opcion extends EntidadBase{
    @Column(name = "descripcion")
    private String _descripcion;
    
    @Column(name = "estatus")
    private String _estatus;
    
//    @ManyToOne
//    @JoinColumn(name = "idPregunta")
//    private Pregunta _idPregunta;

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

    @Override
    public String get_estatus() {
        return _estatus;
    }
    
    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

//    public Pregunta getIdPregunta() {
//        return _idPregunta;
//    }
//
//    public void setIdPregunta(Pregunta _idPregunta) {
//        this._idPregunta = _idPregunta;
//    }
    
}

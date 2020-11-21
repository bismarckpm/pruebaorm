package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "estudio" )
public class Estudio extends EntidadBase{
    
    public Estudio ( long id ){
        super( id );
    }

    public Estudio (){

    }
    
    @Column( name = "fechacreacion" )
    private String _fechaCreacion;
    
    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;
    
    @ManyToOne
    @Column( name = "idSolicitud" )
    private Solicitud _solicitud;
    
    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Encuesta> _encuestas;

    public String getFechaCreacion() {
        return _fechaCreacion;
    }

    public void setFechaCreacion(String _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Solicitud getSolicitud() {
        return _solicitud;
    }

    public void setSolicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }

    public List<Encuesta> getEncuestas() {
        return _encuestas;
    }

    public void setEncuestas(List<Encuesta> _encuestas) {
        this._encuestas = _encuestas;
    }
    
}

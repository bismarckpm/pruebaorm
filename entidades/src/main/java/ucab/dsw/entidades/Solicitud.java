package ucab.dsw.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Omar David
 */
@Entity
@Table(name = "solicitud")
public class Solicitud extends EntidadBase{
    
    @Column(name = "nombre")
    private String _nombre;
    @Column(name = "fecha")
    private String _fecha;

    public Solicitud(long id) {
        super(id);
    }

    public Solicitud() {
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    
    //relaciones de entidad solicitud
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuario;
    
    @ManyToOne
    @JoinColumn(name = "idSubCategoria")
    private Subcategoria _subcategoria;

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Subcategoria getSubcategoria() {
        return _subcategoria;
    }

    public void setSubcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }
    
    //relacion a estudio
    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    public List<Estudio> getEstudios() {
        return _estudios;
    }

    public void setEstudios(List<Estudio> _estudios) {
        this._estudios = _estudios;
    }
    
}

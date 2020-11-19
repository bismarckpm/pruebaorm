package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="solicitud")
public class Solicitud extends EntidadBase {

    @Column(name = "nombre")
    private String _nombre;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date _fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario _usuarioSolicitud;

    @ManyToOne
    @JoinColumn(name = "idSubCategoria")
    private Subcategoria _subcategoria;

    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    public Solicitud(long id) {
        super(id);
    }

    public Solicitud() {
    }

    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }

    public void set_subcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Usuario get_usuarioSolicitud() {
        return _usuarioSolicitud;
    }

    public void set_usuarioSolicitud(Usuario _usuarioSolicitud) {
        this._usuarioSolicitud = _usuarioSolicitud;
    }

    public List<Estudio> get_estudios() {
        return _estudios;
    }

    public void set_estudios(List<Estudio> _estudios) {
        this._estudios = _estudios;
    }
}

package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "solicitud" )
public class Solicitud extends EntidadBase{
    //Constructor
    public Solicitud(long id) { super(id); }
    public Solicitud() { }

    //Columnas
    @Column( name = "nombre", nullable = false )
    private String _nombre;

    @Column( name = "fecha", nullable = false )
    private String _fecha;

    @ManyToOne
    @JoinColumn( name = "idUsuario")
    private Usuario _idUsuario;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria")
    private SubCategoria _idSubCategoria;
    /*
    @OneToMany( mappedBy = "_", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudio;
    */
    //Getter and Setter

    public String get_nombre() { return _nombre; }

    public void set_nombre(String _nombre) { this._nombre = _nombre; }

    public String get_fecha() { return _fecha; }

    public void set_fecha(String _fecha) { this._fecha = _fecha; }

    public Usuario get_idUsuario() { return _idUsuario; }

    public void set_idUsuario(Usuario _idUsuario) { this._idUsuario = _idUsuario; }

    public SubCategoria get_idSubCategoria() { return _idSubCategoria; }

    public void set_idSubCategoria(SubCategoria _idSubCategoria) { this._idSubCategoria = _idSubCategoria; }
    /*
    public List<Estudio> get_estudio() { return _estudio; }

    public void set_estudio(List<Estudio> _estudio) { this._estudio = _estudio; }
    */
}

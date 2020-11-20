package ucab.dsw.entidades;
import ucab.dsw.entidades.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="solicitud")
public class Solicitud extends EntidadBase{

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario _idUsuario;
    public Usuario getUsuario(){
        return this._idUsuario;
    }
    public void set_Usuario(Usuario usuario){
        this._idUsuario=usuario;
    }

    @ManyToOne
    @JoinColumn(name="idSubCategoria")
    private SubCategoria _idSubCategoria;

    public SubCategoria getSubCategoria(){
        return this._idSubCategoria;
    }
    public void set_SubCategoria(SubCategoria subCategoria){
        this._idSubCategoria=subCategoria;
    }

    @Column( name = "nombre",length = 45)
    private String _nombre;

    public String getNombre(){
        return this._nombre;
    }
    public void set_Nombre(String nombre){
        this._nombre=nombre;
    }

    @Column( name = "fecha",length = 45)
    private String _fecha;

    public String getFecha(){
        return this._fecha;
    }
    public void set_creado(String creado){
        this._fecha=creado;
    }

    @Column( name = "estatus" )
    private String _estatus;

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public Solicitud(long id) throws Exception{ super(id);}

    public Solicitud(){}
}

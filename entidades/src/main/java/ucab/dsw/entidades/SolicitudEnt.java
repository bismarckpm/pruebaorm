package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table(name = "solicitud", schema = "mydb")
public class SolicitudEnt extends EntidadBase{

    @Basic
    @Column(name = "nombre")
    private String nombre;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "fecha")
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    @ManyToOne
    @JoinColumn(name = "idSubCategoria")
    private SubcategoriaEnt subcategoria;
    public SubcategoriaEnt getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaEnt subcategoria) {
        this.subcategoria = subcategoria;
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SolicitudEnt( long id )
    {
        super( id );
    }

    public SolicitudEnt( )
    {

    }
}

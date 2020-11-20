package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "solicitud")
public class solicitud extends EntidadBase {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name="idSubCategoria")
    private subCategoria idsubcategoria;

    public void setNombre(String N){this.nombre=N; }
    public String getNombre(){return this.nombre; }

    public void setFecha(String F){this.fecha=F; }
    public String getFecha(){return this.fecha; }

    public Usuario get_usuario()
    {
        return this.idusuario;
    }
    public void set_usuario( Usuario idU ){ this.idusuario = idU;}

    public subCategoria get_subCategoria()
    {
        return this.idsubcategoria;
    }
    public void set_subCategoria( subCategoria idSC ){ this.idsubcategoria = idSC;}

    public solicitud(long id){super(id);}
    public solicitud(){}

}

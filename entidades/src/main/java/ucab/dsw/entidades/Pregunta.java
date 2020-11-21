package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta extends EntidadBase{

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    @Column(name = "pregunta")
    private String pregunta;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idusuario;

    @ManyToOne
    @JoinColumn(name="idTipoPregunta")
    private Tipopregunta idtipopregunta;

    @ManyToOne
    @JoinColumn(name="idSubCategoria")
    private subCategoria idsubcategoria;


    @OneToMany(mappedBy = "pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Ejecucionencuesta> ejecucionencuesta;

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Opcion> Opcion;


    public List<Opcion> get_opcion()
    {
        return this.Opcion;
    }
    public void set_opcion(List<Opcion> O)
    {
        this.Opcion=O;
    }

    public List<Ejecucionencuesta> get_ejecucionencuesta()
    {
        return ejecucionencuesta;
    }
    public void set_ejecucionencuesta(List<Ejecucionencuesta> EE)
    {
        this.ejecucionencuesta=EE;
    }


    public Usuario get_idusuario() {return this.idusuario;}
    public void set_idusuario(Usuario C) {this.idusuario=C;}

    public Tipopregunta get_idtipopregunta() {return this.idtipopregunta;}
    public void set_idtipopregunta(Tipopregunta TP) {this.idtipopregunta=TP;}

    public subCategoria get_subCategoria(){return this.idsubcategoria;}
    public void set_subCategoria( subCategoria idSC ){ this.idsubcategoria = idSC;}

    public Pregunta(long id){super(id);}

    public Pregunta(){ }
}
package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{

    @Column( name = "pregunta", nullable = false )
    private String pregunta;

    public String get_pregunta()
    {
        return pregunta;
    }

    public void set_pregunta( String pregunta )
    {
        this.pregunta = pregunta;
    }

    @Column( name = "fechacreacion", nullable = false  )
    private Date fechacreacion;

    public Date get_fechacreacion()
    {
        return fechacreacion;
    }

    public void set_fechacreacion( Date fechacreacion )
    {
        this.fechacreacion = fechacreacion;
    }

    public TipoPregunta get_tipopregunta()
    {
        return tipopregunta;
    }

    public void set_tipopregunta( TipoPregunta tipopregunta )
    {
        this.tipopregunta = tipopregunta;
    }

    public Usuario get_usuario()
    {
        return usuario;
    }

    public void set_usuario( Usuario usuario )
    {
        this.usuario = usuario;
    }

    public SubcategoriaEnt get_subcategoria()
    {
        return subcategoria;
    }

    public void set_subcategoria( SubcategoriaEnt subcategoria )
    {
        this.subcategoria = subcategoria;
    }

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta tipopregunta;

    @ManyToOne
    @JoinColumn( name = "idSubCategoria" )
    private SubcategoriaEnt subcategoria;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario usuario;

    public Pregunta(){ }

    public Pregunta( long id )
    {
        super( id );
    }
}

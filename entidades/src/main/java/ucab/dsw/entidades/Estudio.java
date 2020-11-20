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
public class Estudio extends EntidadBase
{

    @Column( name = "fechacreacion", nullable = false )
    private String _fechacreacion;

    public String get_fechacreacion()
    {
        return _fechacreacion;
    }

    public void set_fechacreacion(String _fechacreacion) { this._fechacreacion = _fechacreacion; }


    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus)
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn( name = "idSolicitud" )
    private Solicitud _solicitud;

    @OneToMany( mappedBy = "_Estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestas;

    public Estudio( long id )
    {
        super( id );
    }

    public Estudio()
    {

    }
}
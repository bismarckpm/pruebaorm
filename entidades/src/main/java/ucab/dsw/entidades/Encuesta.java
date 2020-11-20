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
@Table( name = "encuesta" )
public class Encuesta extends EntidadBase{
    
    public Encuesta ( long id ){
        super( id );
    }

    public Encuesta (){

    }
    
    @Column( name = "fechacreacion" )
    private String _fechaCreacion;
    
    @ManyToOne
    @JoinColumn( name = "idUsuario_Creador" )
    private Usuario _usuarioCreador;
    
    @ManyToOne
    @JoinColumn( name = "idUsuario_Analista" )
    private Usuario _usuarioAnalista;
    
    @ManyToOne
    @Column( name = "idEstudio" )
    private Estudio _estudio;
    
    @OneToMany( mappedBy = "_encuesta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EjecucionEncuesta> _ejecucionesEncuestas;

    public String getFechaCreacion() {
        return _fechaCreacion;
    }

    public void setFechaCreacion(String _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    public Usuario getUsuarioCreador() {
        return _usuarioCreador;
    }

    public void setUsuarioCreador(Usuario _usuarioCreador) {
        this._usuarioCreador = _usuarioCreador;
    }

    public Usuario getUsuarioAnalista() {
        return _usuarioAnalista;
    }

    public void setUsuarioAnalista(Usuario _usuarioAnalista) {
        this._usuarioAnalista = _usuarioAnalista;
    }

    public Estudio getEstudio() {
        return _estudio;
    }

    public void setEstudio(Estudio _estudio) {
        this._estudio = _estudio;
    }

    public List<EjecucionEncuesta> getEjecucionesEncuestas() {
        return _ejecucionesEncuestas;
    }

    public void setEjecucionesEncuestas(List<EjecucionEncuesta> _ejecucionesEncuestas) {
        this._ejecucionesEncuestas = _ejecucionesEncuestas;
    }
    
}

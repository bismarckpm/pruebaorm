package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "opcion" )
public class Opcion extends EntidadBase{
    //Constructor
    public Opcion(long id) { super(id); }
    public Opcion() { }

    //Columnas
    @Column( name = "descripcion", nullable = false )
    private String _descripcion;

    @ManyToOne
    @JoinColumn( name = "idPregunta")
    private Pregunta _idPregunta;
    /*
    @OneToMany( mappedBy = "_opcion", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuesta;
    //*/
    //Getter and Setter
    public String get_descripcion() { return _descripcion; }

    public void set_descripcion(String _descripcion) { this._descripcion = _descripcion; }

    public Pregunta get_idPregunta() { return _idPregunta; }

    public void set_idPregunta(Pregunta _idPregunta) { this._idPregunta = _idPregunta; }
    /*
    public List<EjecucionEncuesta> get_ejecucionEncuesta() { return _ejecucionEncuesta; }

    public void set_ejecucionEncuesta(List<EjecucionEncuesta> _ejecucionEncuesta) { this._ejecucionEncuesta = _ejecucionEncuesta; }
    */
}

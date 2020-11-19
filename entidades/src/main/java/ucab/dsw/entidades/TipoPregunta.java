package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase {


    @Column( name = "descripcion", nullable = false )
    private String descripcion;

    @Column( name = "estatus",columnDefinition = "CHECK (estatus IN ('I','A'))")
    private String estatus;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public TipoPregunta(long id )
    {
        super( id );
    }

    public TipoPregunta( )
    {

    }
}

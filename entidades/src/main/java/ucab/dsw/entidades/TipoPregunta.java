package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase {


    @Column( name = "descripcion", nullable = false )
    private String descripcion;

    @Column( name = "status",columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoPregunta( long id )
    {
        super( id );
    }

    public TipoPregunta( )
    {

    }
}

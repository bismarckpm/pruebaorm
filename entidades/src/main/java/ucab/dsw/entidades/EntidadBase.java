package ucab.dsw.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class EntidadBase implements Serializable
{

    @Id
    @Column( name = "Id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long _id;


    @Column( name = "estatus" )
    private String _estatus;

    //endregion

    //region Method


    public EntidadBase( long id )
    {
        _id = id;
    }

    public EntidadBase()
    {
    }


    public long getId()
    {
        return _id;
    }

    public String getEstatus()
    {
        return _estatus;
    }

    public void setEstatus( String _estatus )
    {
        this._estatus = _estatus;
    }


}

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
import java.sql.Date;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase {

    @Column( name = "pregunta" )
    private String _pregunta;

    @Column( name = "estatus" )
    private String _estatus;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private TipoUsuario _tipousuario;




}

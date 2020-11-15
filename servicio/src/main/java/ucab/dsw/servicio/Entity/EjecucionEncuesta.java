package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EjecucionEncuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuesta;

    @Column(columnDefinition = "CHECK (status IN ('P', 'C'))")
    private String status;

}

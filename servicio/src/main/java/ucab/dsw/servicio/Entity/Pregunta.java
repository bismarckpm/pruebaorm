package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;

    private Date fechaCreacion;

    @Column(columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;

}

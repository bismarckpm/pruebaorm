package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;

}

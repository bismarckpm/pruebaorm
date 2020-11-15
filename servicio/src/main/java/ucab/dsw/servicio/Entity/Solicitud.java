package ucab.dsw.servicio.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String fecha;

    @Column(columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;
}

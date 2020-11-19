package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(columnDefinition = "CHECK (status IN ('I','A'))")
    private String status;

}

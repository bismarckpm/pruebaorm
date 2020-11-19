package ucab.dsw.entidades;


import javax.persistence.*;

@Entity
public class EjecucionEncuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuesta;

    @Column(columnDefinition = "CHECK (status IN ('P', 'C'))")
    private String status;

}
